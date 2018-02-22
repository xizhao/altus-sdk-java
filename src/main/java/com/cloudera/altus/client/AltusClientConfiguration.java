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

import static com.google.common.base.Preconditions.checkNotNull;

import com.cloudera.altus.http.RetryHandler;

import java.time.Duration;

/**
 * Class encapsulating properties that can be set on an Altus client.
 */
public class AltusClientConfiguration {

  private final Duration readTimeout;
  private final Duration connectionTimeout;
  private final RetryHandler retryHandler;
  private final String clientApplicationName;

  /**
   * Constructor.
   * @param builder the client configuration builder
   */
  public AltusClientConfiguration(AltusClientConfigurationBuilder builder) {
    checkNotNull(builder);
    readTimeout = builder.getReadTimeout();
    connectionTimeout = builder.getConnectionTimeout();
    retryHandler = builder.getRetryHandler();
    clientApplicationName = builder.getClientApplicationName();
  }

  /**
   * see: {@link AltusClientConfigurationBuilder#getConnectionTimeout()}.
   */
  public Duration getConnectionTimeout() {
    return this.connectionTimeout;
  }

  /**
   * see: {@link AltusClientConfigurationBuilder#getReadTimeout()}.
   */
  public Duration getReadTimeout() {
    return this.readTimeout;
  }

  /**
   * see: {@link AltusClientConfigurationBuilder#getRetryHandler()}.
   */
  public RetryHandler getRetryHandler() {
    return this.retryHandler;
  }

  /**
   * see: {@link AltusClientConfigurationBuilder#getClientApplicationName()}.
   */
  public String getClientApplicationName() {
    return this.clientApplicationName;
  }
}
