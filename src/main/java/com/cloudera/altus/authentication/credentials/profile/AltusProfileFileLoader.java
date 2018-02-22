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
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Closeables;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.ini4j.Ini;
import org.ini4j.Profile.Section;

/**
 * Handles the actual loading of an Altus configuration file.
 */
@SdkInternalApi
class AltusProfileFileLoader {

  /**
   * Loads the Altus configuration file.
   * @param file the configuration file
   * @return the loaded profiles
   */
  AllAltusProfiles loadProfiles(File file) {
    checkNotNullAndThrow(file);

    if (!file.exists()) {
      throw new AltusClientException("Error loading Altus profile. Altus " +
          "profile file not found at: " + file.getAbsolutePath());
    }
    if (!file.isFile()) {
      throw new AltusClientException("Error loading Altus profile. File is " +
          "a directory " + file.getAbsolutePath());
    }

    FileInputStream is = null;
    try {
      is = new FileInputStream(file);
      Ini ini = new Ini(is);
      return loadProfiles(ini);
    } catch (IOException ioe) {
      throw new AltusClientException("Unable to load Altus profile specified " +
          "at " + file.getAbsolutePath(), ioe);
    } finally {
      if (is != null) {
        Closeables.closeQuietly(is);
      }
    }
  }

  private AllAltusProfiles loadProfiles(Ini ini) throws IOException {
    ImmutableMap.Builder<String, AltusProfile> profilesByName = ImmutableMap.builder();
    for (String sectionName : ini.keySet()) {
      Section section = ini.get(sectionName);
      ImmutableMap.Builder<String, String> mapBuilder = ImmutableMap.builder();
      for (String optionKey : section.keySet()) {
        mapBuilder.put(optionKey, section.get(optionKey));
      }
      profilesByName.put(sectionName, new AltusProfile(mapBuilder.build()));
    }
    return new AllAltusProfiles(profilesByName.build());
  }
}