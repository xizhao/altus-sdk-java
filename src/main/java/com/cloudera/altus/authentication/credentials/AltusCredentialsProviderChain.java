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

import com.cloudera.altus.AltusClientException;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AltusCredentialsProvider that chains together multiple credentials
 * providers. When a caller first requests credentials from this provider,
 * it calls all the providers in the chain, in the original order specified,
 * until one can provide credentials, and then returns those credentials. If all
 * of the credential providers in the chain have been called, and none of them
 * can provide credentials, then this class will throw an exception indicated
 * that no credentials are available.
 */
public class AltusCredentialsProviderChain implements AltusCredentialsProvider {

  private static final Logger LOG =
      LoggerFactory.getLogger(AltusCredentialsProviderChain.class);

  private final List<AltusCredentialsProvider> altusCredentialProviders =
      new LinkedList<AltusCredentialsProvider>();

  /**
   * Constructor.
   * @param altusCredentialProviders the credential providers
   */
  public AltusCredentialsProviderChain(
      AltusCredentialsProvider... altusCredentialProviders) {
    if (altusCredentialProviders == null || altusCredentialProviders.length == 0) {
      throw new IllegalArgumentException(
          "No Altus credentials providers specified");
    }
    for (AltusCredentialsProvider credentialsProvider: altusCredentialProviders) {
      this.altusCredentialProviders.add(credentialsProvider);
    }
  }

  @Override
  public AltusCredentials getCredentials() {
    for (AltusCredentialsProvider provider : altusCredentialProviders) {
      LOG.debug("trying to load credentials profile for provider " +
          provider.toString());
      try {
        AltusCredentials credentials = provider.getCredentials();
        if (credentials.getAccessKeyId() != null &&
            credentials.getPrivateKey() != null) {
          return credentials;
        }
      } catch (Exception e) {
        LOG.debug("Unable to load credentials for provider " +
            provider.toString() +  ": " + e.getMessage());
      }
    }
    throw new AltusClientException(
        "Unable to load credentials from provider files");
  }
}