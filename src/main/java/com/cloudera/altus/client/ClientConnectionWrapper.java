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

import static com.cloudera.altus.ValidationUtils.checkNotNullAndThrow;

import com.cloudera.altus.AltusClientException;
import com.cloudera.altus.AltusServiceException;
import com.cloudera.altus.annotation.SdkInternalApi;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.common.base.Strings;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

/**
 * Utiltity class that wraps all HTTP calls from the client to Altus.
 */
@SdkInternalApi
class ClientConnectionWrapper {

  private static final KeyStore USE_DEFAULT_KEYSTORE = null;

  private final AltusClientConfiguration altusClientConfiguration;
  private final Client httpClient;

  /**
   * Constructor.
   * @param altusClientConfiguration the client configuration
   */
  ClientConnectionWrapper(AltusClientConfiguration altusClientConfiguration) {
    this.altusClientConfiguration =
        checkNotNullAndThrow(altusClientConfiguration);

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.setDateFormat(new StdDateFormat());
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    JacksonJsonProvider jsonProvider = new JacksonJsonProvider(objectMapper);

    ClientConfig config = new ClientConfig();
    config.register(jsonProvider);


    TrustManager[] trustManagers = null;
    try {
      TrustManagerFactory trustManagerFactory =
          TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      trustManagerFactory.init(USE_DEFAULT_KEYSTORE);
      trustManagers = trustManagerFactory.getTrustManagers();
    } catch (KeyStoreException | NoSuchAlgorithmException e) {
      throw new AltusClientException("Error initializing truststore", e);
    }

    SSLContext sslContext;
    try {
      sslContext = SSLContext.getInstance("TLS");
      sslContext.init(null, trustManagers, new SecureRandom());
    } catch (NoSuchAlgorithmException | KeyManagementException e) {
      throw new AltusClientException("Error initializing SSL", e);
    }

    HostnameVerifier hostnameVerifier = new DefaultHostnameVerifier();

    httpClient = ClientBuilder.newBuilder()
        .withConfig(config)
        .hostnameVerifier(hostnameVerifier)
        .sslContext(sslContext)
        .build();

    httpClient.property(ClientProperties.READ_TIMEOUT,
                        (int) altusClientConfiguration.getReadTimeout().toMillis());
    httpClient.property(ClientProperties.CONNECT_TIMEOUT,
                        (int) altusClientConfiguration.getConnectionTimeout().toMillis());
  }

  /**
   * Posts a request to Altus.
   * @param endPoint the Altus endpoint
   * @param path the HTTP path
   * @param auth the authentication header
   * @param date the date of the request
   * @param requestBody the request body
   * @return the response
   * @throws AltusServiceException an Altus service exception
   */
  Response doPost(
      String endPoint,
      String path,
      String auth,
      String date,
      Object requestBody) throws AltusServiceException {
    String altusClientApp = this.altusClientConfiguration.getClientApplicationName();

    Invocation.Builder builder = httpClient.target(endPoint + path).request()
        .accept(MediaType.APPLICATION_JSON)
        .header("x-altus-date", date)
        .header("x-altus-auth", auth)
        .header("content-type", MediaType.APPLICATION_JSON);

    if (!Strings.isNullOrEmpty(altusClientApp)) {
      builder.header("x-altus-client-app", altusClientApp);
    }

    return builder.post(Entity.entity(requestBody, MediaType.APPLICATION_JSON));
  }
}