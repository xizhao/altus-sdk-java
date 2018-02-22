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
 * AWS-specific Cloudera Navigator configuration information.
 **/
@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-02-21T23:00:25.422-08:00")
public class NavigatorConfigurationAwsDetails  {

  /**
   * The S3 bucket where metadata and lineage information used by Cloudera Navigator is stored.
   **/
  private String navigatorDataBucket = null;

  /**
   * Getter for navigatorDataBucket.
   **/
  @JsonProperty("navigatorDataBucket")
  public String getNavigatorDataBucket() {
    return navigatorDataBucket;
  }

  /**
   * Setter for navigatorDataBucket.
   **/
  public void setNavigatorDataBucket(String navigatorDataBucket) {
    this.navigatorDataBucket = navigatorDataBucket;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NavigatorConfigurationAwsDetails navigatorConfigurationAwsDetails = (NavigatorConfigurationAwsDetails) o;
    if (!Objects.equals(this.navigatorDataBucket, navigatorConfigurationAwsDetails.navigatorDataBucket)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(navigatorDataBucket);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NavigatorConfigurationAwsDetails {\n");
    sb.append("    navigatorDataBucket: ").append(toIndentedString(navigatorDataBucket)).append("\n");
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

