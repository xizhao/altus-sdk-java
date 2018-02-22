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

package com.cloudera.altus.http;

import static org.junit.Assert.assertEquals;

import com.cloudera.altus.AltusClientException;

import java.time.Duration;

import org.junit.Test;

public class ExponentialBackoffDelayPolicyTest {

  @Test
  public void testDelay() {
    ExponentialBackoffDelayPolicy delayPolicy =
        new ExponentialBackoffDelayPolicy(2, Duration.ofSeconds(1));
    for (int ii = 1; ii <= 10; ii++) {
      Duration expected = Duration.ofSeconds((long) Math.pow(2, ii - 1));
      assertEquals("Iteration: " + Integer.toString(ii),
          expected,
          delayPolicy.delay(ii));
    }
  }

  @Test(expected = AltusClientException.class)
  public void testNullBase() {
    new ExponentialBackoffDelayPolicy(1, null);
  }

  @Test(expected = AltusClientException.class)
  public void testZeroBase() {
    new ExponentialBackoffDelayPolicy(1, Duration.ofMillis(0));
  }

  @Test(expected = AltusClientException.class)
  public void testNegativeGrowthFactor() {
    new ExponentialBackoffDelayPolicy(-1, Duration.ofMillis(1));
  }

  @Test(expected = AltusClientException.class)
  public void testNegativeAttempts() {
    ExponentialBackoffDelayPolicy delayPolicy =
      new ExponentialBackoffDelayPolicy(2, Duration.ofSeconds(1));
    delayPolicy.delay(-1);
  }

  @Test(expected = AltusClientException.class)
  public void testZeroAttempts() {
    ExponentialBackoffDelayPolicy delayPolicy =
      new ExponentialBackoffDelayPolicy(2, Duration.ofSeconds(1));
    delayPolicy.delay(0);
  }
}
