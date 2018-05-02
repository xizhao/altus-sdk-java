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
 * The S3 consistent view (S3Guard) configuration.
 **/
@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-05-02T12:03:45.900-07:00")
public class S3GuardConfiguration  {

  /**
   * Whether S3Guard is enabled.
   **/
  private Boolean enable = null;

  /**
   * The name of the DynamoDB table that stores the S3Guard Metadata.
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
    S3GuardConfiguration s3GuardConfiguration = (S3GuardConfiguration) o;
    if (!Objects.equals(this.enable, s3GuardConfiguration.enable)) {
      return false;
    }
    if (!Objects.equals(this.tableName, s3GuardConfiguration.tableName)) {
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
    sb.append("class S3GuardConfiguration {\n");
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

