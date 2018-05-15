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

package com.cloudera.altus.dataeng.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.cloudera.altus.client.AltusResponse;
import com.cloudera.altus.dataeng.model.ClusterNavigatorConfigurationAwsDetails;

/**
 * Navigator integration configuration.
 **/
@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-05-15T16:32:03.781-07:00")
public class ClusterNavigatorConfiguration  {

  /**
   * Whether this cluster was configured to be integrated with Cloudera Navigator.
   **/
  private Boolean clouderaNavigatorIntegrationEnabled = null;

  /**
   * 
   **/
  private ClusterNavigatorConfigurationAwsDetails awsDetails = null;

  /**
   * Getter for clouderaNavigatorIntegrationEnabled.
   **/
  @JsonProperty("clouderaNavigatorIntegrationEnabled")
  public Boolean getClouderaNavigatorIntegrationEnabled() {
    return clouderaNavigatorIntegrationEnabled;
  }

  /**
   * Setter for clouderaNavigatorIntegrationEnabled.
   **/
  public void setClouderaNavigatorIntegrationEnabled(Boolean clouderaNavigatorIntegrationEnabled) {
    this.clouderaNavigatorIntegrationEnabled = clouderaNavigatorIntegrationEnabled;
  }

  /**
   * Getter for awsDetails.
   **/
  @JsonProperty("awsDetails")
  public ClusterNavigatorConfigurationAwsDetails getAwsDetails() {
    return awsDetails;
  }

  /**
   * Setter for awsDetails.
   **/
  public void setAwsDetails(ClusterNavigatorConfigurationAwsDetails awsDetails) {
    this.awsDetails = awsDetails;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClusterNavigatorConfiguration clusterNavigatorConfiguration = (ClusterNavigatorConfiguration) o;
    if (!Objects.equals(this.clouderaNavigatorIntegrationEnabled, clusterNavigatorConfiguration.clouderaNavigatorIntegrationEnabled)) {
      return false;
    }
    if (!Objects.equals(this.awsDetails, clusterNavigatorConfiguration.awsDetails)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(clouderaNavigatorIntegrationEnabled, awsDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClusterNavigatorConfiguration {\n");
    sb.append("    clouderaNavigatorIntegrationEnabled: ").append(toIndentedString(clouderaNavigatorIntegrationEnabled)).append("\n");
    sb.append("    awsDetails: ").append(toIndentedString(awsDetails)).append("\n");
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

