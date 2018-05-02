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

package com.cloudera.altus.environments.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.cloudera.altus.client.AltusResponse;

/**
 * Defines configurations required to enable S3 consistent view (S3Guard).
 **/
@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-05-02T12:03:45.900-07:00")
public class S3GuardConfigurationRequest  {

  /**
   * Enable S3Guard for operations in the environment. Only applies to clusters using CDH 5.11 and higher. Note that S3Guard tracks S3 metadata using an AWS DynamoDB database, so you will incur AWS charges for using that database.
   **/
  private Boolean enable = null;

  /**
   * The name of the DynamoDB table that stores the S3Guard Metadata (default s3guard-metadata).
   **/
  private String tableName = null;

  /**
   * Getter for enable.
   **/
  @JsonProperty("enable")
  public Boolean getEnable() {
    return enable;
  }

  /**
   * Setter for enable.
   **/
  public void setEnable(Boolean enable) {
    this.enable = enable;
  }

  /**
   * Getter for tableName.
   **/
  @JsonProperty("tableName")
  public String getTableName() {
    return tableName;
  }

  /**
   * Setter for tableName.
   **/
  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    S3GuardConfigurationRequest s3GuardConfigurationRequest = (S3GuardConfigurationRequest) o;
    if (!Objects.equals(this.enable, s3GuardConfigurationRequest.enable)) {
      return false;
    }
    if (!Objects.equals(this.tableName, s3GuardConfigurationRequest.tableName)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(enable, tableName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class S3GuardConfigurationRequest {\n");
    sb.append("    enable: ").append(toIndentedString(enable)).append("\n");
    sb.append("    tableName: ").append(toIndentedString(tableName)).append("\n");
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

