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

package com.cloudera.altus.authentication.credentials;

import static com.cloudera.altus.ValidationUtils.checkNotNullAndThrow;

import com.cloudera.altus.client.CredentialUtilities;

import java.security.PrivateKey;

/**
 * Basic implementation of the AltusCredentials interface that allows callers
 * to pass in the Altus access key ID and private key in the constructor.
 */
public class BasicAltusCredentials implements AltusCredentials {

  private final String accessKeyId;
  private final PrivateKey privateKey;

  /**
   * Construtor.
   * @param accessKeyId the Altus access key ID
   * @param privateKey the Altus private key
   */
  public BasicAltusCredentials(
      String accessKeyId,
      String privateKey) {
    this(accessKeyId,
         CredentialUtilities.decodePrivateKey(
             checkNotNullAndThrow(privateKey)));
  }

  /**
   * Construtor.
   * @param accessKeyId the Altus access key ID
   * @param privateKey the Altus private key
   */
  public BasicAltusCredentials(
      String accessKeyId,
      PrivateKey privateKey) {
    checkNotNullAndThrow(accessKeyId);
    checkNotNullAndThrow(privateKey);
    this.accessKeyId = accessKeyId;
    this.privateKey = privateKey;
  }

  @Override
  public String getAccessKeyId() {
    return accessKeyId;
  }

  @Override
  public PrivateKey getPrivateKey() {
    return privateKey;
  }
}
