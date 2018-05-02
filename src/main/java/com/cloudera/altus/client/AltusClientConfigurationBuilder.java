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

import com.cloudera.altus.http.ExponentialBackoffDelayPolicy;
import com.cloudera.altus.http.HttpCodesRetryChecker;
import com.cloudera.altus.http.RetryHandler;
import com.cloudera.altus.http.SimpleRetryHandler;
import com.google.common.base.MoreObjects;

import java.time.Duration;

/**
 * Class used to build an AltusClientConfiguration object.
 */
public class AltusClientConfigurationBuilder {

  private String clientApplicationName = null;
  private Duration readTimeout = Duration.ofMinutes(1);
  private Duration connectionTimeout = Duration.ofMinutes(1);
  private RetryHandler retryHandler = new SimpleRetryHandler(
      new HttpCodesRetryChecker(HttpCodesRetryChecker.DEFAULT_RETRY_CODES),
      /**
       * We use exponential backoff with parameters that gives us about
       * 1 minute and 20 seconds of wait.
       */
      new ExponentialBackoffDelayPolicy(2, Duration.ofMillis(10)),
      13);

  private AltusClientConfigurationBuilder() {}

  /**
   * Sets the client application name.
   * @param clientApplicationName - Name of the the client application.
   * @return a reference to the AltusClientConfiguration object so that method calls
   * can be chained together.
   */
  public AltusClientConfigurationBuilder withClientApplicationName(String clientApplicationName) {
    checkNotNullAndThrow(clientApplicationName);
    this.clientApplicationName = clientApplicationName;
    return this;
  }

  /**
   * Returns the client application name if set optionally by a customer or a partner
   * application. This client application name would be used by Cloudera to derive metrics
   * around Altus SDK adoption by different customers and partners.
   * @return the client application name, if set, otherwise returns "" (empty string) by default
   */
  public String getClientApplicationName() {
    return this.clientApplicationName;
  }

  /**
   * Sets the connection timeout on the underlying HTTP client.
   * @param connectionTimeout the connection timeout
   * @return the builder.
   */
  public AltusClientConfigurationBuilder withConnectionTimeout(Duration connectionTimeout) {
    checkArgumentAndThrow(connectionTimeout.toMillis() > 0);
    this.connectionTimeout = connectionTimeout;
    return this;
  }

  /**
   * Gets the connection timeout of the underlying HTTP connection.
   * @return the connection timeout
   */
  public Duration getConnectionTimeout() {
    return this.connectionTimeout;
  }

  /**
   * Sets the read timeout on the underlying HTTP client.
   * @param readTimeout the read timeout
   * @return Returns a reference to the AltusClientConfiguration object so
   * that method calls can be chained together
   */
  public AltusClientConfigurationBuilder withReadTimeout(Duration readTimeout) {
    checkArgumentAndThrow(readTimeout.toMillis() > 0);
    this.readTimeout = readTimeout;
    return this;
  }

  /**
   * Gets the read timeout on the underlying HTTP client.
   * @return the read timeout
   */
  public Duration getReadTimeout() {
    return this.readTimeout;
  }

  /**
   * Sets the value for RetryHandler.  If none is set the SimpleRetryHandler is used.
   * The retry handler determines whether or not to retry service operations in the
   * event of a failure or exception.
   * @param retryHandler The retry handler to use
   * @return the current value of the flag as a boolean
   */
  public AltusClientConfigurationBuilder withRetryHandler(RetryHandler retryHandler) {
    checkNotNullAndThrow(retryHandler);
    this.retryHandler = retryHandler;
    return this;
  }

  /**
   * Gets the current value of the retryHandler property.
   * @return a RetryHandler object with the current value of the retryHandler property
   */
  public RetryHandler getRetryHandler() {
    return this.retryHandler;
  }

  /**
   * Gets an AltusClientConfigurationBuilder object with all the default values set.
   * @return an AltusClientConfiguration object with default values for each property
   */
   public static AltusClientConfigurationBuilder defaultBuilder() {
     return new AltusClientConfigurationBuilder();
   }

  /**
   * Builds an AltusClientConfiguration object based on current settings.
   * @return an AltusClientConfiguration object with current settings
   */
  public AltusClientConfiguration build() {
    return new AltusClientConfiguration(this);
  }

  /**
   * Builds an string representation of the AltusClientConfiguration object based on
   * current settings.
   * @return a string with current settings
   */
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("readTimeout", this.getReadTimeout())
        .add("connectionTimeout", this.getConnectionTimeout())
        .add("clientApplicationName", this.getClientApplicationName())
        .toString();
  }

}
