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

import static  com.cloudera.altus.ValidationUtils.checkNotNullAndThrow;

import com.cloudera.altus.authentication.credentials.profile.AltusProfileConfigFile;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;

/**
 * Credentials provider based on Altus configuration profiles. This provider
 * reads credentials from the profile configuration file for the default
 * profile, or for a specific, named profile.
 */
public class AltusProfileCredentialsProvider
  implements AltusCredentialsProvider {

  /**
   * Name of system environment variable holding the name of profile to use
   * when reading the credentials file. Overrides ALTUS_DEFAULT_PROFILE_NAME.
   */
  public static final String ALTUS_DEFAULT_PROFILE = "ALTUS_DEFAULT_PROFILE";

  /**
   * Name of the profile in the users credentials file to read.
   */
  public static final String ALTUS_DEFAULT_PROFILE_NAME = "default";

  private volatile AltusProfileConfigFile altusProfileConfigFile;
  private final String altusProfileName;

  /**
   * Uses the default Altus location (~/.altus/credentials) and default profile
   * name. Loading of the credential file is deferred until getCredentials()
   * method is called
   */
  public AltusProfileCredentialsProvider() {
    this(null);
  }

  /**
   * Uses the default Altus location (~/.altus/credentials) and input profile
   * name, or the default if the input profile name is null. Loading of the
   * credential file is deferred until getCredentials() method is called.
   * @param profileName profile name to use, "default" is used if null
   */
  public AltusProfileCredentialsProvider(
      @Nullable String profileName) {
    this((AltusProfileConfigFile) null, profileName);
  }

  /**
   * Uses the input profile file path and input profile name, or the default
   * if the input profile name is null. Loading of credential file is deferred
   * until getCredentials() method is called.
   * @param profileFilePath path to the credentials file
   * @param profileName profile name to use, "default" is used if null
   */
  public AltusProfileCredentialsProvider(
      String profileFilePath,
      @Nullable String profileName) {
    this(new AltusProfileConfigFile(checkNotNullAndThrow(profileFilePath)),
         profileName);
  }

  private AltusProfileCredentialsProvider(
      @Nullable AltusProfileConfigFile profilesConfigFile,
      @Nullable String profileName) {
    this.altusProfileConfigFile = profilesConfigFile;
    if (StringUtils.isBlank(profileName)) {
      this.altusProfileName = getAltusProfileName();
    } else {
      this.altusProfileName = profileName;
    }
  }

  private String getAltusProfileName() {
    String envProfileName = System.getenv(ALTUS_DEFAULT_PROFILE);
    if (StringUtils.isBlank(envProfileName)) {
      return ALTUS_DEFAULT_PROFILE_NAME;
    } else {
      return envProfileName;
    }
  }

  @Override
  public AltusCredentials getCredentials() {
    if (altusProfileConfigFile == null) {
      synchronized (this) {
        if (altusProfileConfigFile == null) {
          altusProfileConfigFile = new AltusProfileConfigFile();
        }
      }
    }
    return altusProfileConfigFile.getCredentials(this.altusProfileName);
  }
}
