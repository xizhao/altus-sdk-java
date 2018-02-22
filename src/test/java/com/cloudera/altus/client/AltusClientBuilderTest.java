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

import static org.junit.Assert.assertEquals;

import com.cloudera.altus.AltusClientException;
import com.cloudera.altus.authentication.credentials.AltusCredentials;

import org.junit.Test;

public class AltusClientBuilderTest {

  public class MockAltusClient extends AltusClient {
    public static final String SERVICE_NAME = "mock";

    public MockAltusClient(
        AltusCredentials credentials,
        String endPoint,
        AltusClientConfiguration clientConfiguration) {
      super(credentials, endPoint, clientConfiguration);
    }

  }

  public class MockClientBuilder extends AltusClientBuilder<MockClientBuilder> {

    private MockClientBuilder() {
      super(MockAltusClient.SERVICE_NAME);
    }

    protected AltusClient defaultClient() {
      return defaultBuilder().build();
    }

    public MockClientBuilder defaultBuilder() {
      return new MockClientBuilder();
    }

    public MockAltusClient build() {
      return new MockAltusClient(getAltusCredentials().getCredentials(),
                                 getAltusEndPoint(),
                                 getAltusClientConfiguration());
    }

    @Override
    public MockClientBuilder self() {
      return this;
    }
  }

  @Test
  public void testDefaultBuilder() {
    MockClientBuilder builder = new MockClientBuilder().defaultBuilder();
    assertEquals("https://mockapi.us-west-1.altus.cloudera.com:443",
        builder.getAltusEndPoint());
    AltusClientConfiguration config =
        builder.getAltusClientConfiguration();
    AltusClientConfiguration defaultConfig =
        AltusClientConfigurationBuilder.defaultBuilder().build();
    assertEquals(
        defaultConfig.getConnectionTimeout(),
        config.getConnectionTimeout());
    assertEquals(
        defaultConfig.getReadTimeout(),
        config.getReadTimeout());
    assertEquals(
        defaultConfig.getClientApplicationName(),
        config.getClientApplicationName());
    assertEquals(
        defaultConfig.getRetryHandler().getClass(),
        config.getRetryHandler().getClass());

  }

  @Test(expected = AltusClientException.class)
  public void testNullCredentialsProvider() {
    MockClientBuilder builder = new MockClientBuilder();
    builder.withCredentials(null);
  }

  @Test(expected = AltusClientException.class)
  public void testNullEndPoint() {
    MockClientBuilder builder = new MockClientBuilder();
    builder.withEndPoint(null);
  }

  @Test(expected = AltusClientException.class)
  public void testNullClientConfiguration() {
    MockClientBuilder builder = new MockClientBuilder();
    builder.withClientConfiguration(null);
  }
}
