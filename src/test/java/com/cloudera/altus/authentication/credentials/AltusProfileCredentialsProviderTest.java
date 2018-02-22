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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.cloudera.altus.AltusClientException;
import com.cloudera.altus.util.AltusSDKTestUtils;
import com.google.common.collect.Maps;

import java.util.Map;

import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

public class AltusProfileCredentialsProviderTest {

  private String originalUserHome = null;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Rule
  public TemporaryFolder folder = new TemporaryFolder();

  @Before
  public void setEnvVariables() {
    originalUserHome = System.getProperty("user.home");
    System.setProperty("user.home",
        folder.getRoot().getAbsolutePath().toString());
    Map<String, String> newEnvironment = Maps.newHashMap();
    AltusSDKTestUtils.setEnv(newEnvironment);
  }

  @After
  public void resetEnvVariables() {
    System.setProperty("user.home", originalUserHome);
  }

  @Test
  public void readFromDefaultLocationDefaultProfileName() {
    AltusSDKTestUtils.copyTestCredentialsFileToFolder(folder);
    AltusProfileCredentialsProvider credentialsProvider =
        new AltusProfileCredentialsProvider();
    AltusCredentials credentials = credentialsProvider.getCredentials();
    assertNotNull(credentials.getPrivateKey());
    assertEquals(AltusSDKTestUtils.DEFAULT_CREDENTIALS_KEY_ID,
        credentials.getAccessKeyId());
  }

  @Test
  public void readFromDefaultLocationSpecifiedProfileName() {
    AltusSDKTestUtils.copyTestCredentialsFileToFolder(folder);
    AltusProfileCredentialsProvider credentialsProvider =
        new AltusProfileCredentialsProvider("altus_test");
    AltusCredentials credentials = credentialsProvider.getCredentials();
    assertNotNull(credentials.getPrivateKey());
    assertEquals(AltusSDKTestUtils.TEST_CREDENTIALS_KEY_ID,
        credentials.getAccessKeyId());
  }

  @Test
  public void invalidProfile() {
    AltusSDKTestUtils.copyTestCredentialsFileToFolder(folder);
    AltusProfileCredentialsProvider credentialsProvider =
        new AltusProfileCredentialsProvider("nonExistingName");
    thrown.expect(AltusClientException.class);
    thrown.expectMessage(IsEqual.equalTo(
        "Unable to find profile named nonExistingName"));
    credentialsProvider.getCredentials();
  }

  @Test
  public void invalidEnvVarProfile() {
    AltusSDKTestUtils.copyTestCredentialsFileToFolder(folder);
    Map<String, String> newEnvironment = Maps.newHashMap();
    newEnvironment.put(AltusProfileCredentialsProvider.ALTUS_DEFAULT_PROFILE,
        "newEnvironmentprofile");
    AltusSDKTestUtils.setEnv(newEnvironment);
    AltusProfileCredentialsProvider credentialsProvider =
        new AltusProfileCredentialsProvider();
    thrown.expect(AltusClientException.class);
    thrown.expectMessage("Unable to find profile named newEnvironmentprofile");
    credentialsProvider.getCredentials();
  }

  @Test
  public void readFromEnvVar() {
    Map<String, String> newEnvironment = Maps.newHashMap();
    newEnvironment.put(AltusProfileCredentialsProvider.ALTUS_DEFAULT_PROFILE,
        "altus_test");
    AltusSDKTestUtils.setEnv(newEnvironment);
    AltusSDKTestUtils.copyTestCredentialsFileToFolder(folder);
    AltusProfileCredentialsProvider credentialsProvider =
        new AltusProfileCredentialsProvider();
    AltusCredentials credentials = credentialsProvider.getCredentials();
    assertNotNull(credentials.getPrivateKey());
    assertEquals(AltusSDKTestUtils.TEST_CREDENTIALS_KEY_ID,
        credentials.getAccessKeyId());
  }

  @Test
  public void readFromSpecifiedPath() {
    AltusProfileCredentialsProvider credentialsProvider =
        new AltusProfileCredentialsProvider(
            AltusSDKTestUtils.getTestCredentialsFileName(), "default");
    AltusCredentials credentials = credentialsProvider.getCredentials();
    assertNotNull(AltusSDKTestUtils.DEFAULT_CREDENTIALS_PRIVATE_KEY);
    assertEquals(AltusSDKTestUtils.DEFAULT_CREDENTIALS_KEY_ID,
        credentials.getAccessKeyId());
  }

}
