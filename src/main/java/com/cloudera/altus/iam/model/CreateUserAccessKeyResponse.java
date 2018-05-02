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

package com.cloudera.altus.iam.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.cloudera.altus.client.AltusResponse;
import com.cloudera.altus.iam.model.AccessKey;

/**
 * Response object for a create user access key request.
 **/
@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-05-02T12:03:46.083-07:00")
public class CreateUserAccessKeyResponse extends AltusResponse {

  /**
   * The access key that was created.
   **/
  private AccessKey accessKey = null;

  /**
   * The private key associated with this access key. This string is the contents of a PEM file containing a PKCS#8 private key.
   **/
  private String privateKey = null;

  /**
   * Getter for accessKey.
   **/
  @JsonProperty("accessKey")
  public AccessKey getAccessKey() {
    return accessKey;
  }

  /**
   * Setter for accessKey.
   **/
  public void setAccessKey(AccessKey accessKey) {
    this.accessKey = accessKey;
  }

  /**
   * Getter for privateKey.
   **/
  @JsonProperty("privateKey")
  public String getPrivateKey() {
    return privateKey;
  }

  /**
   * Setter for privateKey.
   **/
  public void setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateUserAccessKeyResponse createUserAccessKeyResponse = (CreateUserAccessKeyResponse) o;
    if (!Objects.equals(this.accessKey, createUserAccessKeyResponse.accessKey)) {
      return false;
    }
    if (!Objects.equals(this.privateKey, createUserAccessKeyResponse.privateKey)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessKey, privateKey, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateUserAccessKeyResponse {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    accessKey: ").append(toIndentedString(accessKey)).append("\n");
    sb.append("    privateKey: ").append(toIndentedString(privateKey)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line except the first indented by 4 spaces.
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

