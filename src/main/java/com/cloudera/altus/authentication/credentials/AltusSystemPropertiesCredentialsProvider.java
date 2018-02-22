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

import org.apache.commons.lang3.StringUtils;

/**
 * AltusCredentialsProvider implementation that provides credentials by looking
 * at the ALTUS_ACCESS_KEY_ID and ALTUS_PRIVATE_KEY system properties.
 */
public class AltusSystemPropertiesCredentialsProvider
  implements AltusCredentialsProvider {

  /**
   * Name of system variable holding the users Altus access key ID.
   */
  public static final String ALTUS_ACCESS_KEY_ID = "ALTUS_ACCESS_KEY_ID";

  /**
   * Name of system variable holding the users Altus private key.
   */
  public static final String ALTUS_PRIVATE_KEY = "ALTUS_PRIVATE_KEY";

  @Override
  public AltusCredentials getCredentials() {
    String accessKeyId = StringUtils.trim(System.getProperty(ALTUS_ACCESS_KEY_ID));
    String privateKey = StringUtils.trim(System.getProperty(ALTUS_PRIVATE_KEY));
    accessKeyId = StringUtils.trim(accessKeyId);
    privateKey = StringUtils.trim(privateKey);
    if (StringUtils.isEmpty(accessKeyId) || StringUtils.isEmpty(privateKey)) {
      throw new AltusClientException(
          "Unable to load Altus credentials from Java system properties " +
              ALTUS_ACCESS_KEY_ID + " and " + ALTUS_PRIVATE_KEY);
    }
    return new BasicAltusCredentials(accessKeyId, privateKey);
  }

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }
}
