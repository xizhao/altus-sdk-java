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
import com.cloudera.altus.http.SimpleRetryHandler;

import java.time.Duration;

import org.junit.Test;

public class AltusClientConfigurationBuilderTest {

  @Test
  public void testDefaultReadTimeout() {
    AltusClientConfigurationBuilder builder = AltusClientConfigurationBuilder.defaultBuilder();
    assertEquals(Duration.ofMinutes(1), builder.getReadTimeout());
  }

  @Test
  public void testDefaultConnectionTimeout() {
    AltusClientConfigurationBuilder builder = AltusClientConfigurationBuilder.defaultBuilder();
    assertEquals(Duration.ofMinutes(1), builder.getConnectionTimeout());
  }

  @Test
  public void testDefaultApplicationName() {
    AltusClientConfigurationBuilder builder = AltusClientConfigurationBuilder.defaultBuilder();
    assertEquals(null, builder.getClientApplicationName());
  }

  @Test
  public void testDefaultRetryHandler() {
    AltusClientConfigurationBuilder builder = AltusClientConfigurationBuilder.defaultBuilder();
    builder.build();
    assertEquals(builder.getRetryHandler().getClass(), SimpleRetryHandler.class);
  }

  @Test(expected = AltusClientException.class)
  public void testInvalidConnectionTimeout() {
    AltusClientConfigurationBuilder.defaultBuilder()
      .withConnectionTimeout(Duration.ofMillis(0));
}

  @Test(expected = AltusClientException.class)
  public void testInvalidReadTimeout() {
    AltusClientConfigurationBuilder.defaultBuilder()
      .withReadTimeout(Duration.ofMillis(0));
  }

  @Test(expected = AltusClientException.class)
  public void testInvalidClientApplicationName() {
    AltusClientConfigurationBuilder.defaultBuilder()
      .withClientApplicationName(null);
  }

  @Test(expected = AltusClientException.class)
  public void testInvalidRetryHandler() {
    AltusClientConfigurationBuilder.defaultBuilder()
      .withRetryHandler(null);
  }

}
