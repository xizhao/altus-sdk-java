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

package com.cloudera.altus;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.MultivaluedHashMap;

import org.junit.Test;

public class AltusServiceExceptionTest {

  @Test(expected = AltusClientException.class)
  public void testAllNulls() {
    new AltusServiceException(null, -1, null, null, null);
  }

  @Test
  public void testValidException() {
    AltusServiceException exception =
      new AltusServiceException("requestid", 502, new MultivaluedHashMap<>(),
        "statuscode", "statusmessage");
    assertEquals(String.format("%s: %d: %s: %s %s",
        AltusServiceException.class.getName().toString(),
        502,
        "statuscode",
        "statusmessage",
        "requestid"),
      exception.toString());
  }
}
