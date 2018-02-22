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

/**
 * Interface for providing Altus credentials. Implementations are free to use
 * any strategy for providing Altus credentials, such as simply providing
 * static credentials that don't change, or more complicated implementations,
 * such as integrating with existing key management systems.
 */
public interface AltusCredentialsProvider {

  /**
   * Returns AltusCredentials which the caller can use to authorize an Altus
   * request. Each implementation of AltusCredentialsProvider can chose its own
   * strategy for loading credentials.  For example, an implementation might
   * load credentials from an existing key management system, or load new
   * credentials when credentials are rotated.
   *
   * @return AltusCredentials which the caller can use to authorize an Altus
   * request.
   */
  AltusCredentials getCredentials();
}
