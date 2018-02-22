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
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

public class DefaultCredentialsProviderChainTest {

  private String originalUserHome = null;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Rule
  public TemporaryFolder folder = new TemporaryFolder();

  @Before
  public void setEnvVariables() {
    //override user home in case server has existing altus credentials file
    originalUserHome = System.getProperty("user.home");
    System.setProperty("user.home", folder.getRoot().getAbsolutePath().toString());
  }

  @After
  public void resetEnvVariables() {
    System.setProperty("user.home",originalUserHome);
  }

  @Test
  public void testNoCredentials() {
    DefaultAltusCredentialProviderChain cp = new DefaultAltusCredentialProviderChain();

    thrown.expect(AltusClientException.class);
    thrown.expectMessage("Unable to load credentials from provider files");

    cp.getCredentials();
  }

  @Test
  public void testValidEnvironmentVariableCredentials() {
    Map<String, String> newEnvironment = Maps.newHashMap();
    String accessKeyId = UUID.randomUUID().toString();
    newEnvironment.put(
        AltusEnvironmentVariableCredentialsProvider.ALTUS_ACCESS_KEY_ID,
        accessKeyId);
    newEnvironment.put(
        AltusEnvironmentVariableCredentialsProvider.ALTUS_PRIVATE_KEY,
        AltusSDKTestUtils.getEncodedPrivateKey());
    AltusSDKTestUtils.setEnv(newEnvironment);

    DefaultAltusCredentialProviderChain cp = new DefaultAltusCredentialProviderChain();
    AltusCredentials credentials = cp.getCredentials();

    assertEquals(accessKeyId, credentials.getAccessKeyId());
    assertEquals(AltusSDKTestUtils.getPrivateKey(), credentials.getPrivateKey());

    newEnvironment = Maps.newHashMap();
    AltusSDKTestUtils.setEnv(newEnvironment);
  }

  @Test
  public void testValidSystemPropertiesCredentials() {
    String accessKeyId = UUID.randomUUID().toString();
    System.setProperty(
        AltusSystemPropertiesCredentialsProvider.ALTUS_ACCESS_KEY_ID,
        accessKeyId);
    System.setProperty(
        AltusSystemPropertiesCredentialsProvider.ALTUS_PRIVATE_KEY,
        AltusSDKTestUtils.getEncodedPrivateKey());

    DefaultAltusCredentialProviderChain cp = new DefaultAltusCredentialProviderChain();
    AltusCredentials credentials = cp.getCredentials();

    assertEquals(accessKeyId, credentials.getAccessKeyId());
    assertEquals(AltusSDKTestUtils.getPrivateKey(), credentials.getPrivateKey());

    System.clearProperty(
        AltusSystemPropertiesCredentialsProvider.ALTUS_PRIVATE_KEY);
    System.clearProperty(
        AltusSystemPropertiesCredentialsProvider.ALTUS_ACCESS_KEY_ID);
  }

  @Test
  public void testValidProfileCredentials() {
    AltusSDKTestUtils.copyTestCredentialsFileToFolder(folder);
    DefaultAltusCredentialProviderChain cp = new DefaultAltusCredentialProviderChain();
    AltusCredentials credentials = cp.getCredentials();
    assertNotNull(credentials.getPrivateKey());
    assertEquals(AltusSDKTestUtils.DEFAULT_CREDENTIALS_KEY_ID,
        credentials.getAccessKeyId());
  }

}
