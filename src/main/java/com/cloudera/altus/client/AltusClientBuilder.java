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

import com.cloudera.altus.annotation.SdkInternalApi;
import com.cloudera.altus.authentication.credentials.AltusCredentialsProvider;
import com.cloudera.altus.authentication.credentials.DefaultAltusCredentialProviderChain;

/**
 * The base class of all client builders. This should not be referenced
 * directly.
 */
@SdkInternalApi
public abstract class AltusClientBuilder <T extends AltusClientBuilder<T>> {

  private static final String ENDPOINT_FORMAT_STRING = "https://%sapi.us-west-1.altus.cloudera.com:443";

  private AltusCredentialsProvider altusCredentialsProvider;
  private AltusClientConfiguration altusClientConfiguration;
  private String altusEndPoint;

  /**
   * Constructor.
   * @param serviceName the service name
   */
  protected AltusClientBuilder(String serviceName) {
    checkNotNullAndThrow(serviceName);
    this.altusEndPoint =
        String.format(ENDPOINT_FORMAT_STRING, serviceName);
    this.altusCredentialsProvider =
        DefaultAltusCredentialProviderChain.getInstance();
    this.altusClientConfiguration =
        AltusClientConfigurationBuilder.defaultBuilder().build();
  }

  /**
   * Gets the current AltusCredentialsProvider.
   * @return the current value of the AltusCredentialsProvider
   */
  public AltusCredentialsProvider getAltusCredentials() {
    return altusCredentialsProvider;
  }

  /**
   * Sets the AltusCredentialsProvider.
   * @param altusCredentialsProvider the new value for the AltusCredentialsProvider
   * @return T the current builder object
   */
  public T withCredentials(AltusCredentialsProvider altusCredentialsProvider) {
    checkNotNullAndThrow(altusCredentialsProvider);
    this.altusCredentialsProvider = altusCredentialsProvider;
    return self();
  }

  /**
   * Sets the Altus service endpoint.
   * @param altusEndPoint the new value for the Altus service endpoint
   * @return T the current builder object
   */
  public T withEndPoint(String altusEndPoint) {
    checkNotNullAndThrow(altusEndPoint);
    this.altusEndPoint = altusEndPoint;
    return self();
  }

  /**
   * Gets the Altus service endpoint.
   * @param serviceName the name of the Altus service being used
   * @return String - A string with the fully formed Altus service endpoint
   */
  public String getAltusEndPoint() {
    return altusEndPoint;
  }

  /**
   * Sets the AltusClientConfiguration.
   * @param altusClientConfiguration the new value for the AltusClientConfiguration
   * @return T the current builder object
   */
  public T withClientConfiguration(AltusClientConfiguration altusClientConfiguration) {
    checkNotNullAndThrow(altusClientConfiguration);
    this.altusClientConfiguration = altusClientConfiguration;
    return self();
  }

  /**
   * Gets the current AltusClientConfiguration.
   * @return the current value of the AltusClientConfiguration
   */
  public final AltusClientConfiguration getAltusClientConfiguration() {
    return altusClientConfiguration;
  }

  /**
   * Get the builder.
   * @return the builder
   */
  protected abstract T self();
}
