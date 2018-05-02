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
import com.cloudera.altus.environments.model.EnvironmentAwsDetails;
import com.cloudera.altus.environments.model.NavigatorConfiguration;
import com.cloudera.altus.environments.model.WorkloadAnalyticsConfiguration;
import java.time.ZonedDateTime;

/**
 * Container for the environment access data.
 **/
@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-05-02T12:03:45.900-07:00")
public class Environment  {

  /**
   * The name of the environment.
   **/
  private String environmentName = null;

  /**
   * The CRN of the environment.
   **/
  private String crn = null;

  /**
   * The date when the cloud account was created.
   **/
  private ZonedDateTime creationDate = null;

  /**
   * The type of the environment.
   **/
  private String type = null;

  /**
   * Configurations for integration with Altus Workload Analytics.
   **/
  private WorkloadAnalyticsConfiguration workloadAnalyticsConfiguration = null;

  /**
   * 
   **/
  private EnvironmentAwsDetails awsDetails = null;

  /**
   * The configurations for Cloudera Navigator integration.
   **/
  private NavigatorConfiguration navigatorConfiguration = null;

  /**
   * Getter for environmentName.
   **/
  @JsonProperty("environmentName")
  public String getEnvironmentName() {
    return environmentName;
  }

  /**
   * Setter for environmentName.
   **/
  public void setEnvironmentName(String environmentName) {
    this.environmentName = environmentName;
  }

  /**
   * Getter for crn.
   **/
  @JsonProperty("crn")
  public String getCrn() {
    return crn;
  }

  /**
   * Setter for crn.
   **/
  public void setCrn(String crn) {
    this.crn = crn;
  }

  /**
   * Getter for creationDate.
   **/
  @JsonProperty("creationDate")
  public ZonedDateTime getCreationDate() {
    return creationDate;
  }

  /**
   * Setter for creationDate.
   **/
  public void setCreationDate(ZonedDateTime creationDate) {
    this.creationDate = creationDate;
  }

  /**
   * Getter for type.
   **/
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  /**
   * Setter for type.
   **/
  public void setType(String type) {
    this.type = type;
  }

  /**
   * Getter for workloadAnalyticsConfiguration.
   **/
  @JsonProperty("workloadAnalyticsConfiguration")
  public WorkloadAnalyticsConfiguration getWorkloadAnalyticsConfiguration() {
    return workloadAnalyticsConfiguration;
  }

  /**
   * Setter for workloadAnalyticsConfiguration.
   **/
  public void setWorkloadAnalyticsConfiguration(WorkloadAnalyticsConfiguration workloadAnalyticsConfiguration) {
    this.workloadAnalyticsConfiguration = workloadAnalyticsConfiguration;
  }

  /**
   * Getter for awsDetails.
   **/
  @JsonProperty("awsDetails")
  public EnvironmentAwsDetails getAwsDetails() {
    return awsDetails;
  }

  /**
   * Setter for awsDetails.
   **/
  public void setAwsDetails(EnvironmentAwsDetails awsDetails) {
    this.awsDetails = awsDetails;
  }

  /**
   * Getter for navigatorConfiguration.
   **/
  @JsonProperty("navigatorConfiguration")
  public NavigatorConfiguration getNavigatorConfiguration() {
    return navigatorConfiguration;
  }

  /**
   * Setter for navigatorConfiguration.
   **/
  public void setNavigatorConfiguration(NavigatorConfiguration navigatorConfiguration) {
    this.navigatorConfiguration = navigatorConfiguration;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Environment environment = (Environment) o;
    if (!Objects.equals(this.environmentName, environment.environmentName)) {
      return false;
    }
    if (!Objects.equals(this.crn, environment.crn)) {
      return false;
    }
    if (!Objects.equals(this.creationDate, environment.creationDate)) {
      return false;
    }
    if (!Objects.equals(this.type, environment.type)) {
      return false;
    }
    if (!Objects.equals(this.workloadAnalyticsConfiguration, environment.workloadAnalyticsConfiguration)) {
      return false;
    }
    if (!Objects.equals(this.awsDetails, environment.awsDetails)) {
      return false;
    }
    if (!Objects.equals(this.navigatorConfiguration, environment.navigatorConfiguration)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(environmentName, crn, creationDate, type, workloadAnalyticsConfiguration, awsDetails, navigatorConfiguration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Environment {\n");
    sb.append("    environmentName: ").append(toIndentedString(environmentName)).append("\n");
    sb.append("    crn: ").append(toIndentedString(crn)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    workloadAnalyticsConfiguration: ").append(toIndentedString(workloadAnalyticsConfiguration)).append("\n");
    sb.append("    awsDetails: ").append(toIndentedString(awsDetails)).append("\n");
    sb.append("    navigatorConfiguration: ").append(toIndentedString(navigatorConfiguration)).append("\n");
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

