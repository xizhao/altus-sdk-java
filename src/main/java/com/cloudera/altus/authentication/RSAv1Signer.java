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

package com.cloudera.altus.authentication;

import static com.cloudera.altus.ValidationUtils.checkNotNullAndThrow;

import com.cloudera.altus.AltusClientException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Throwables;
import com.google.common.collect.Maps;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.SortedMap;

import org.apache.commons.codec.binary.Base64;

/**
 * An request signer appropriate for use with the RSAv1Authenticator. See that
 * classes comments for details.
 */
public class RSAv1Signer {

  private static final String AUTH_METHOD = "rsav1";

  /**
   * Computes the value for the x-altus-auth header for a request.
   * @param httpMethod the HTTP method
   * @param contentType the value of the content type header
   * @param date the value of the x-altus-date header
   * @param path the request portion of the URI, e.g. /iam/getUser
   * @param accessKeyId the access key ID
   * @param privateKey the access key private key
   * @return the value for the x-altus-auth header
   */
  public String computeAuthHeader(String httpMethod,
                                  String contentType,
                                  String date,
                                  String path,
                                  String accessKeyId,
                                  PrivateKey privateKey) {
    checkNotNullAndThrow(httpMethod);
    checkNotNullAndThrow(contentType);
    checkNotNullAndThrow(date);
    checkNotNullAndThrow(path);
    checkNotNullAndThrow(accessKeyId);
    checkNotNullAndThrow(privateKey);

    String stringToSign = new StringBuilder()
      .append(httpMethod)
      .append("\n")
      .append(contentType)
      .append("\n")
      .append(date)
      .append("\n")
      .append(path)
      .append("\n")
      .append(AUTH_METHOD)
      .toString();

    String signatureString;
    try {
      Signature signature = Signature.getInstance("SHA256withRSA");
      signature.initSign(privateKey);
      signature.update(stringToSign.getBytes(StandardCharsets.UTF_8));
      signatureString = Base64.encodeBase64URLSafeString(signature.sign());
    } catch (NoSuchAlgorithmException |
             InvalidKeyException |
             SignatureException e) {
      Throwables.throwIfUnchecked(e);
      throw new RuntimeException(e);
    }

    try {
      SortedMap<String, String> authParams = Maps.newTreeMap();
      authParams.put("access_key_id", accessKeyId);
      authParams.put("auth_method", AUTH_METHOD);
      String encodedAuthParams =
        new ObjectMapper().writeValueAsString(authParams);
      return String.format("%s.%s",
        Base64.encodeBase64URLSafeString(
          encodedAuthParams.getBytes(StandardCharsets.UTF_8)),
          signatureString);
    } catch (JsonProcessingException e) {
      throw new AltusClientException("Error while building authentication header");
    }
  }
}