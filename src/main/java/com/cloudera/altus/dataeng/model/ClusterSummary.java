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
import java.time.ZonedDateTime;

/**
 * Information about a cluster.
 **/
@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-05-15T16:32:03.781-07:00")
public class ClusterSummary  {

  /**
   * The name of the cluster.
   **/
  private String clusterName = null;

  /**
   * The CRN of the cluster.
   **/
  private String crn = null;

  /**
   * The date when the cluster was created.
   **/
  private ZonedDateTime creationDate = null;

  /**
   * The status of the cluster.
   **/
  private String status = null;

  /**
   * The CDH version for the cluster.
   **/
  private String cdhVersion = null;

  /**
   * The instance type for the worker instances.
   **/
  private String instanceType = null;

  /**
   * The worker group size.
   **/
  private Integer workersGroupSize = null;

  /**
   * The service type for the cluster.
   **/
  private String serviceType = null;

  /**
   * The type of the environment.
   **/
  private String environmentType = null;

  /**
   * The CRN of the environment.
   **/
  private String environmentCrn = null;

  /**
   * Getter for clusterName.
   **/
  @JsonProperty("clusterName")
  public String getClusterName() {
    return clusterName;
  }

  /**
   * Setter for clusterName.
   **/
  public void setClusterName(String clusterName) {
    this.clusterName = clusterName;
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
   * Getter for status.
   **/
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  /**
   * Setter for status.
   **/
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * Getter for cdhVersion.
   **/
  @JsonProperty("cdhVersion")
  public String getCdhVersion() {
    return cdhVersion;
  }

  /**
   * Setter for cdhVersion.
   **/
  public void setCdhVersion(String cdhVersion) {
    this.cdhVersion = cdhVersion;
  }

  /**
   * Getter for instanceType.
   **/
  @JsonProperty("instanceType")
  public String getInstanceType() {
    return instanceType;
  }

  /**
   * Setter for instanceType.
   **/
  public void setInstanceType(String instanceType) {
    this.instanceType = instanceType;
  }

  /**
   * Getter for workersGroupSize.
   **/
  @JsonProperty("workersGroupSize")
  public Integer getWorkersGroupSize() {
    return workersGroupSize;
  }

  /**
   * Setter for workersGroupSize.
   **/
  public void setWorkersGroupSize(Integer workersGroupSize) {
    this.workersGroupSize = workersGroupSize;
  }

  /**
   * Getter for serviceType.
   **/
  @JsonProperty("serviceType")
  public String getServiceType() {
    return serviceType;
  }

  /**
   * Setter for serviceType.
   **/
  public void setServiceType(String serviceType) {
    this.serviceType = serviceType;
  }

  /**
   * Getter for environmentType.
   **/
  @JsonProperty("environmentType")
  public String getEnvironmentType() {
    return environmentType;
  }

  /**
   * Setter for environmentType.
   **/
  public void setEnvironmentType(String environmentType) {
    this.environmentType = environmentType;
  }

  /**
   * Getter for environmentCrn.
   **/
  @JsonProperty("environmentCrn")
  public String getEnvironmentCrn() {
    return environmentCrn;
  }

  /**
   * Setter for environmentCrn.
   **/
  public void setEnvironmentCrn(String environmentCrn) {
    this.environmentCrn = environmentCrn;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClusterSummary clusterSummary = (ClusterSummary) o;
    if (!Objects.equals(this.clusterName, clusterSummary.clusterName)) {
      return false;
    }
    if (!Objects.equals(this.crn, clusterSummary.crn)) {
      return false;
    }
    if (!Objects.equals(this.creationDate, clusterSummary.creationDate)) {
      return false;
    }
    if (!Objects.equals(this.status, clusterSummary.status)) {
      return false;
    }
    if (!Objects.equals(this.cdhVersion, clusterSummary.cdhVersion)) {
      return false;
    }
    if (!Objects.equals(this.instanceType, clusterSummary.instanceType)) {
      return false;
    }
    if (!Objects.equals(this.workersGroupSize, clusterSummary.workersGroupSize)) {
      return false;
    }
    if (!Objects.equals(this.serviceType, clusterSummary.serviceType)) {
      return false;
    }
    if (!Objects.equals(this.environmentType, clusterSummary.environmentType)) {
      return false;
    }
    if (!Objects.equals(this.environmentCrn, clusterSummary.environmentCrn)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(clusterName, crn, creationDate, status, cdhVersion, instanceType, workersGroupSize, serviceType, environmentType, environmentCrn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClusterSummary {\n");
    sb.append("    clusterName: ").append(toIndentedString(clusterName)).append("\n");
    sb.append("    crn: ").append(toIndentedString(crn)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    cdhVersion: ").append(toIndentedString(cdhVersion)).append("\n");
    sb.append("    instanceType: ").append(toIndentedString(instanceType)).append("\n");
    sb.append("    workersGroupSize: ").append(toIndentedString(workersGroupSize)).append("\n");
    sb.append("    serviceType: ").append(toIndentedString(serviceType)).append("\n");
    sb.append("    environmentType: ").append(toIndentedString(environmentType)).append("\n");
    sb.append("    environmentCrn: ").append(toIndentedString(environmentCrn)).append("\n");
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

