/*
 * Copyright (c) 2018 Cloudera, Inc. All Rights Reserved.
 *
 * Portions Copyright (c) Copyright 2013-2018 Amazon.com, Inc. or its
 * affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cloudera.altus.client;

import static com.cloudera.altus.ValidationUtils.checkArgumentAndThrow;
import static com.cloudera.altus.ValidationUtils.checkNotNullAndThrow;
import static com.google.common.base.Preconditions.checkNotNull;

import com.cloudera.altus.AltusClientException;
import com.cloudera.altus.AltusHTTPException;
import com.cloudera.altus.AltusServiceException;
import com.cloudera.altus.annotation.SdkInternalApi;
import com.cloudera.altus.authentication.RSAv1Signer;
import com.cloudera.altus.authentication.credentials.AltusCredentials;
import com.cloudera.altus.http.RetryHandler;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;

import java.io.IOException;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Abstract base class for all API client classes. This should not be
 * referenced directly.
 */
@SdkInternalApi
public abstract class AltusClient {

  private static final ObjectMapper MAPPER = new ObjectMapper();

  private static class MapReference extends TypeReference<Map<String, String>> {
  }

  private final AltusCredentials credentials;
  private final String endPoint;
  private final RetryHandler retryHandler;
  private final ClientConnectionWrapper clientConnectionWrapper;

  /**
   * Constructor.
   * @param credentials the Altus credentials
   * @param endpoint the Altus service endpoint
   * @param clientConfiguration the client configuration
   */
  protected AltusClient(AltusCredentials credentials,
                        String endpoint,
                        AltusClientConfiguration clientConfiguration) {
    checkNotNullAndThrow(clientConfiguration);
    checkNotNullAndThrow(clientConfiguration.getRetryHandler());
    this.credentials = checkNotNullAndThrow(credentials);
    this.endPoint = checkNotNullAndThrow(endpoint);
    this.retryHandler = clientConfiguration.getRetryHandler();
    this.clientConnectionWrapper = new ClientConnectionWrapper(clientConfiguration);
  }

  /**
   * Invoke API by sending HTTP request with the given options.
   * @param path The subpath of the HTTP URL
   * @param body The request body object
   * @param returnType The return type as a GenericType
   * @return The response body in type of string
   */
  protected <T extends AltusResponse> T invokeAPI(String path, Object body, GenericType<T> returnType) {
    checkNotNullAndThrow(path);
    checkNotNullAndThrow(body);
    checkNotNullAndThrow(returnType);
    int attempts = 0;
    do {
      attempts++;
      Response response = getAPIResponse(path, body);
      checkNotNullAndThrow(response);
      checkArgumentAndThrow(response.getStatusInfo() != Response.Status.NO_CONTENT);
      try {
        return parse(response, returnType);
      } catch (AltusClientException exception) {
        Duration delay = retryHandler.shouldRetry(attempts, exception);
        if (delay == RetryHandler.DO_NOT_RETRY) {
          throw exception;
        }
        try {
          Thread.sleep(delay.toMillis());
        } catch (InterruptedException e) {
          throw new AltusClientException("Error while retrying request", e);
        }
      }
    } while (true);
  }

  /**
   * Builds the authentication header and then calls the doPost method on the ClientConnectionWrapper.
   * @param path - the path on the URI of the request
   * @param requestBody - the request object containing the full request (e.g. ListClusterRequest).
   * @return response The Response object received from the Altus server
   */
  @VisibleForTesting
  protected Response getAPIResponse(String path, Object requestBody)
      throws AltusServiceException {
    String date = ZonedDateTime.now(ZoneId.of("GMT")).format(
        DateTimeFormatter.RFC_1123_DATE_TIME);

    String auth = new RSAv1Signer().computeAuthHeader(
        "POST",
        MediaType.APPLICATION_JSON,
        date,
        path,
        credentials.getAccessKeyId(),
        credentials.getPrivateKey());

    return clientConnectionWrapper.doPost(endPoint, path, auth, date, requestBody);
  }

  private <T extends AltusResponse> T parse(
      Response response,
      GenericType<T> returnType) {
    checkNotNull(response);
    checkNotNull(returnType);

    int httpCode = response.getStatusInfo().getStatusCode();

    ImmutableMap.Builder<String, List<String>> mapBuilder = ImmutableMap.builder();
    for (Entry<String, List<Object>> entry : response.getHeaders().entrySet()) {
      ImmutableList.Builder<String> listBuilder = new ImmutableList.Builder<>();
      for (Object o : entry.getValue()) {
        listBuilder.add(String.valueOf(o));
      }
      mapBuilder.put(entry.getKey(), listBuilder.build());
    }
    Map<String, List<String>> responseHeaders = mapBuilder.build();

    if (response.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL) {
      T altusResponse = response.readEntity(returnType);
      if (altusResponse == null) {
        throw new AltusHTTPException(httpCode, "Invalid response from server");
      }
      altusResponse.setHttpCode(httpCode);
      altusResponse.setResponseHeaders(responseHeaders);
      return altusResponse;
    }

    String body;
    try {
      body = response.readEntity(String.class);
    }  catch (ProcessingException | NullPointerException e) {
      throw new AltusHTTPException(
          httpCode, "Error reading message from server", e);
    }

    String code;
    String message;
    String requestId;
    try {
      Map<String, String> map = MAPPER.readValue(body, new MapReference());
      code = map.get("code");
      checkNotNull(code);
      message = map.get("message");
      checkNotNull(message);
      List<String> values =
          responseHeaders.get(AltusResponse.ALTUS_HEADER_REQUESTID);
      checkNotNull(values);
      requestId = Iterables.getOnlyElement(values);
    } catch (IOException | NullPointerException | IllegalArgumentException e) {
      throw new AltusHTTPException(httpCode, body, e);
    }

    throw new AltusServiceException(
        requestId,
        httpCode,
        responseHeaders,
        code,
        message);
  }
}
