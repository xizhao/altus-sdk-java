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

package com.cloudera.altus.authentication.credentials.profile;

import static com.cloudera.altus.ValidationUtils.checkNotNullAndThrow;

import com.cloudera.altus.AltusClientException;
import com.cloudera.altus.annotation.SdkInternalApi;
import com.cloudera.altus.authentication.credentials.AltusCredentials;
import com.cloudera.altus.authentication.credentials.BasicAltusCredentials;

import java.io.File;

/**
 * Handles loading an Altus profile from either the default location or from an
 * input path. Offers a convenience method for retreiving credentials from a
 * named profile.
 */
@SdkInternalApi
public class AltusProfileConfigFile {

  private AllAltusProfiles allProfiles;

  /**
   * Constructor. Loads the Altus credentials file from the default location.
   */
  public AltusProfileConfigFile() {
    this(getAltusCredentialsLocation());
  }

  /**
   * Loads the Altus credential profiles from the input path.
   * @param filePath path to Altus credentials file
   */
  public AltusProfileConfigFile(String filePath) {
    this(new File(checkNotNullAndThrow(filePath)));
  }

  /**
   * Loads the Altus credential profiles from the input file.
   * @param file Altus credentials file
   */
  public AltusProfileConfigFile(File file) {
    allProfiles = loadProfiles(checkNotNullAndThrow(file));
  }

  /**
   * Returns the AltusCredentials using the profile name provided.
   * @param profileName Altus profile name
   * @return AltusCredentials
   */
  public AltusCredentials getCredentials(String profileName) {
    checkNotNullAndThrow(profileName);
    AltusProfile profile = allProfiles.getProfile(profileName);
    if (profile == null) {
      throw new AltusClientException("Unable to find profile named " + profileName);
    }
    return new BasicAltusCredentials(
        profile.getAltusAccessKeyId(), profile.getAltusPrivateKey());
  }

  private static File getAltusCredentialsLocation() {
    File credProfiles = new File(getAltusDirectory(), "credentials");
    if (credProfiles.exists() && credProfiles.isFile()) {
      return credProfiles;
    }
    return null;
  }

  private static File getAltusDirectory() {
    return new File(getHomeDiretory(), ".altus");
  }

  private static String getHomeDiretory() {
    String userHomeDir = System.getProperty("user.home");
    if (userHomeDir == null) {
      throw new AltusClientException("Unable to load Altus profiles since " +
          "user.home system property is not set");
    }
    return userHomeDir;
  }

  private AllAltusProfiles loadProfiles(File file) {
    return new AltusProfileFileLoader().loadProfiles(file);
  }
}
