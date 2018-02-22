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

package com.cloudera.altus.authentication.credentials.profile.path;

import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.cloudera.altus.AltusClientException;
import com.cloudera.altus.authentication.credentials.AltusCredentials;
import com.cloudera.altus.authentication.credentials.AltusProfileCredentialsProvider;
import com.cloudera.altus.authentication.credentials.profile.AltusProfileConfigFile;
import com.cloudera.altus.util.AltusSDKTestUtils;

import java.io.File;

import org.hamcrest.core.IsEqual;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

public class AltusProfileConfigFileTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Rule
  public TemporaryFolder folder = new TemporaryFolder();

  @Test
  public void testNullConfigFileName() {
    thrown.expect(AltusClientException.class);
    thrown.expectMessage(IsEqual.equalTo("Argument is null"));
    new AltusProfileConfigFile((String)null);
  }

  @Test
  public void testNullConfigFileHandle() {
    thrown.expect(AltusClientException.class);
    thrown.expectMessage(IsEqual.equalTo("Argument is null"));
    new AltusProfileConfigFile((File)null);
  }

  @Test
  public void testNonExistantFileName() {
    thrown.expect(AltusClientException.class);
    thrown.expectMessage(startsWith("Error loading Altus profile. Altus " +
        "profile file not found at:"));
    new AltusProfileConfigFile(
        folder.getRoot().getAbsolutePath() + "/junk.txt");
  }

  @Test
  public void testNonExistantFileHandle() {
    thrown.expect(AltusClientException.class);
    thrown.expectMessage(startsWith("Error loading Altus profile. Altus " +
        "profile file not found at:"));
    new AltusProfileConfigFile(
        new File(folder.getRoot().getAbsolutePath() + "/junk.txt"));
  }

  @Test
  public void testNonExistantProfileName() {
    thrown.expect(AltusClientException.class);
    thrown.expectMessage("Unable to find profile named foobar");
    AltusProfileConfigFile config = new AltusProfileConfigFile(
        AltusSDKTestUtils.getTestCredentialsFileName());
    config.getCredentials("foobar");
  }

  @Test
  public void testValidProfile() {
    AltusProfileCredentialsProvider credentialsProvider =
        new AltusProfileCredentialsProvider(
            AltusSDKTestUtils.getTestCredentialsFileName(), "default");
    AltusCredentials credentials = credentialsProvider.getCredentials();
    assertNotNull(credentials.getPrivateKey());
    assertEquals(AltusSDKTestUtils.DEFAULT_CREDENTIALS_KEY_ID,
        credentials.getAccessKeyId());
  }
}