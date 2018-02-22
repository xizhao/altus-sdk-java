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
package com.cloudera.altus.util;

import static org.junit.Assert.fail;

import com.cloudera.altus.annotation.SdkInternalApi;
import com.cloudera.altus.client.CredentialUtilities;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.util.Collections;
import java.util.Map;

import org.junit.rules.TemporaryFolder;

/**
 * Utility classed used in junit tests.
 */
@SdkInternalApi
public class AltusSDKTestUtils {
  private static final String PRIVATE_KEY;
  public static String DEFAULT_CREDENTIALS_FILENAME = "credentials";
  public static String DEFAULT_CREDENTIALS_FOLDERNAME = ".altus";
  public static String DEFAULT_CREDENTIALS_PATH = "/" + DEFAULT_CREDENTIALS_FOLDERNAME
      + "/" + DEFAULT_CREDENTIALS_FILENAME;
  public static String DEFAULT_CREDENTIALS_KEY_ID = "1232-232-11-1-123";
  public static String DEFAULT_CREDENTIALS_PRIVATE_KEY =
      "-----BEGIN PRIVATE KEY-----someprivatekey-----END PRIVATE KEY-----";
  public static String TEST_CREDENTIALS_KEY_ID = "TEST1232-232-11-1-123";
  public static String TEST_CREDENTIALS_PRIVATE_KEY =
      "-----BEGIN PRIVATE KEY-----testsomeprivatekey-----END PRIVATE KEY-----";

  static {
    String privateKey = null;
    try {
      privateKey = Resources.toString(
          Resources.getResource("testPrivateKey.pem"), Charsets.UTF_8);
    } catch (IOException e) {
      fail("Could not find private key resource.");
    }
    PRIVATE_KEY = privateKey;
  }

  private void AltusSDKTestUtils() {}

  /**
   * Sets the operating system environment.
   * @param newenv - a map containing the new environment variables -
   *  names and values.
   */
  public static void setEnv(Map<String, String> newenv)
  {
    try
    {
      Class<?> processEnvironmentClass = Class.forName("java.lang.ProcessEnvironment");
      Field theEnvironmentField =
           processEnvironmentClass.getDeclaredField("theEnvironment");
      theEnvironmentField.setAccessible(true);
      Map<String, String> env = (Map<String, String>) theEnvironmentField.get(null);
      env.putAll(newenv);
      Field theCaseInsensitiveEnvironmentField =
          processEnvironmentClass.getDeclaredField("theCaseInsensitiveEnvironment");
      theCaseInsensitiveEnvironmentField.setAccessible(true);
      Map<String, String> cienv =
          (Map<String, String>) theCaseInsensitiveEnvironmentField.get(null);
      cienv.putAll(newenv);
    }
    catch (NoSuchFieldException e)
    {
      try {
        Class<?>[] classes = Collections.class.getDeclaredClasses();
        Map<String, String> env = System.getenv();
        for(Class<?> cl : classes) {
          if("java.util.Collections$UnmodifiableMap".equals(cl.getName())) {
            Field field = cl.getDeclaredField("m");
            field.setAccessible(true);
            Object obj = field.get(env);
            Map<String, String> map = (Map<String, String>) obj;
            map.clear();
            map.putAll(newenv);
          }
        }
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    } catch (Exception e1) {
      e1.printStackTrace();
    }
  }

  /**
   * Sets the operating system environment.
   * @return fileName - Full path and filename of the test credentials file.
   */
  public static String getTestCredentialsFileName() {
    return AltusSDKTestUtils.class.getClassLoader()
      .getResource(DEFAULT_CREDENTIALS_FILENAME).getFile().toString();
  }

  /**
   * Copies the test credentials file to a specific folder.
   * @param folder - a map containing the new environment variables -
   *  names and values.
   */
  public static void copyTestCredentialsFileToFolder(TemporaryFolder folder) {
    try {
      folder.newFolder(".altus");
      Files.copy(Paths.get(getTestCredentialsFileName()),
        Paths.get(folder.getRoot().getAbsolutePath().toString() + DEFAULT_CREDENTIALS_PATH));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Returns a private key which can be used in test encoded as a string. The
   * key is valid but has no access to Altus.
   * @return an encoded test private key
   */
  public static String getEncodedPrivateKey() {
      return PRIVATE_KEY;
  }

  /**
   * Returns a private key which can be used in test. The key is valid but has
   * no access to Altus.
   * @return a test private key
   */
  public static PrivateKey getPrivateKey() {
      return CredentialUtilities.decodePrivateKey(PRIVATE_KEY);
  }

}
