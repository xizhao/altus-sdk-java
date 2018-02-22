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
import com.cloudera.altus.AltusHTTPException;

import java.util.Collections;

import org.junit.Test;

public class HttpCodesRetryCheckerTest {

  @Test(expected = AltusClientException.class)
  public void testNullSet() {
    new HttpCodesRetryChecker(null);
  }

  @Test
  public void testNonRetryCode() {
    HttpCodesRetryChecker retryChecker = new HttpCodesRetryChecker(
        HttpCodesRetryChecker.DEFAULT_RETRY_CODES);
    AltusHTTPException exception = new AltusHTTPException(500, "BOOM!");
    assertEquals(retryChecker.shouldRetry(5, exception), false);
  }

  @Test
  public void testNonHTTPError() {
    HttpCodesRetryChecker retryChecker = new HttpCodesRetryChecker(
        HttpCodesRetryChecker.DEFAULT_RETRY_CODES);
    AltusClientException exception = new AltusClientException("BOOM!");
    assertEquals(retryChecker.shouldRetry(5, exception), false);
  }

  @Test(expected = AltusClientException.class)
  public void testEmptySet() {
    new HttpCodesRetryChecker(Collections.emptySet());
  }

  @Test
  public void testRetryCodes() {
    for (int httpCode : HttpCodesRetryChecker.DEFAULT_RETRY_CODES) {
      HttpCodesRetryChecker retryChecker =
          new HttpCodesRetryChecker(HttpCodesRetryChecker.DEFAULT_RETRY_CODES);
      AltusHTTPException exception = new AltusHTTPException(httpCode, "BOOM!");
      assertEquals(retryChecker.shouldRetry(5, exception), true);
    }
  }
}
