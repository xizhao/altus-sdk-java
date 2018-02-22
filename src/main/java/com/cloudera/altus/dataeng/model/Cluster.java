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
import com.cloudera.altus.dataeng.model.ClusterComputeWorkersConfiguration;
import com.cloudera.altus.dataeng.model.ClusterNavigatorConfiguration;
import com.cloudera.altus.dataeng.model.ClusterWorkersConfiguration;
import com.cloudera.altus.dataeng.model.Endpoint;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * Information about a cluster.
 **/
@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-02-21T23:00:25.094-08:00")
public class Cluster  {

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
   * A flag indicating if a bootstrap script was provided or not during the cluster create request. The script content is not returned because it may be sensitive.
   **/
  private Boolean hasInstanceBootstrapScript = null;

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
   * The condition under which a cluster should be automatically terminated.
   **/
  private String automaticTerminationCondition = null;

  /**
   * If the cluster's status is FAILED, this will be set with related failure codes.
   **/
  private List<String> failureCodes = new ArrayList<String>();

  /**
   * If the cluster's status is FAILED, this will be set with a message explaining the reason.
   **/
  private String failureReason = null;

  /**
   * The location where cluster and job logs will be placed.
   **/
  private String logArchiveLocation = null;

  /**
   * The connection endpoint of the cluster's Cloudera Manager.
   **/
  private Endpoint clouderaManagerEndpoint = null;

  /**
   * 
   **/
  private ClusterComputeWorkersConfiguration computeWorkersConfiguration = null;

  /**
   * 
   **/
  private ClusterWorkersConfiguration workersConfiguration = null;

  /**
   * Whether this cluster was configured to send data to Altus Workload Analytics.
   **/
  private Boolean workloadAnalyticsEnabled = null;

  /**
   * 
   **/
  private ClusterNavigatorConfiguration navigatorConfiguration = null;

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
   * Getter for hasInstanceBootstrapScript.
   **/
  @JsonProperty("hasInstanceBootstrapScript")
  public Boolean getHasInstanceBootstrapScript() {
    return hasInstanceBootstrapScript;
  }

  /**
   * Setter for hasInstanceBootstrapScript.
   **/
  public void setHasInstanceBootstrapScript(Boolean hasInstanceBootstrapScript) {
    this.hasInstanceBootstrapScript = hasInstanceBootstrapScript;
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

  /**
   * Getter for automaticTerminationCondition.
   **/
  @JsonProperty("automaticTerminationCondition")
  public String getAutomaticTerminationCondition() {
    return automaticTerminationCondition;
  }

  /**
   * Setter for automaticTerminationCondition.
   **/
  public void setAutomaticTerminationCondition(String automaticTerminationCondition) {
    this.automaticTerminationCondition = automaticTerminationCondition;
  }

  /**
   * Getter for failureCodes.
   **/
  @JsonProperty("failureCodes")
  public List<String> getFailureCodes() {
    return failureCodes;
  }

  /**
   * Setter for failureCodes.
   **/
  public void setFailureCodes(List<String> failureCodes) {
    this.failureCodes = failureCodes;
  }

  /**
   * Getter for failureReason.
   **/
  @JsonProperty("failureReason")
  public String getFailureReason() {
    return failureReason;
  }

  /**
   * Setter for failureReason.
   **/
  public void setFailureReason(String failureReason) {
    this.failureReason = failureReason;
  }

  /**
   * Getter for logArchiveLocation.
   **/
  @JsonProperty("logArchiveLocation")
  public String getLogArchiveLocation() {
    return logArchiveLocation;
  }

  /**
   * Setter for logArchiveLocation.
   **/
  public void setLogArchiveLocation(String logArchiveLocation) {
    this.logArchiveLocation = logArchiveLocation;
  }

  /**
   * Getter for clouderaManagerEndpoint.
   **/
  @JsonProperty("clouderaManagerEndpoint")
  public Endpoint getClouderaManagerEndpoint() {
    return clouderaManagerEndpoint;
  }

  /**
   * Setter for clouderaManagerEndpoint.
   **/
  public void setClouderaManagerEndpoint(Endpoint clouderaManagerEndpoint) {
    this.clouderaManagerEndpoint = clouderaManagerEndpoint;
  }

  /**
   * Getter for computeWorkersConfiguration.
   **/
  @JsonProperty("computeWorkersConfiguration")
  public ClusterComputeWorkersConfiguration getComputeWorkersConfiguration() {
    return computeWorkersConfiguration;
  }

  /**
   * Setter for computeWorkersConfiguration.
   **/
  public void setComputeWorkersConfiguration(ClusterComputeWorkersConfiguration computeWorkersConfiguration) {
    this.computeWorkersConfiguration = computeWorkersConfiguration;
  }

  /**
   * Getter for workersConfiguration.
   **/
  @JsonProperty("workersConfiguration")
  public ClusterWorkersConfiguration getWorkersConfiguration() {
    return workersConfiguration;
  }

  /**
   * Setter for workersConfiguration.
   **/
  public void setWorkersConfiguration(ClusterWorkersConfiguration workersConfiguration) {
    this.workersConfiguration = workersConfiguration;
  }

  /**
   * Getter for workloadAnalyticsEnabled.
   **/
  @JsonProperty("workloadAnalyticsEnabled")
  public Boolean getWorkloadAnalyticsEnabled() {
    return workloadAnalyticsEnabled;
  }

  /**
   * Setter for workloadAnalyticsEnabled.
   **/
  public void setWorkloadAnalyticsEnabled(Boolean workloadAnalyticsEnabled) {
    this.workloadAnalyticsEnabled = workloadAnalyticsEnabled;
  }

  /**
   * Getter for navigatorConfiguration.
   **/
  @JsonProperty("navigatorConfiguration")
  public ClusterNavigatorConfiguration getNavigatorConfiguration() {
    return navigatorConfiguration;
  }

  /**
   * Setter for navigatorConfiguration.
   **/
  public void setNavigatorConfiguration(ClusterNavigatorConfiguration navigatorConfiguration) {
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
    Cluster cluster = (Cluster) o;
    if (!Objects.equals(this.clusterName, cluster.clusterName)) {
      return false;
    }
    if (!Objects.equals(this.crn, cluster.crn)) {
      return false;
    }
    if (!Objects.equals(this.creationDate, cluster.creationDate)) {
      return false;
    }
    if (!Objects.equals(this.status, cluster.status)) {
      return false;
    }
    if (!Objects.equals(this.cdhVersion, cluster.cdhVersion)) {
      return false;
    }
    if (!Objects.equals(this.instanceType, cluster.instanceType)) {
      return false;
    }
    if (!Objects.equals(this.hasInstanceBootstrapScript, cluster.hasInstanceBootstrapScript)) {
      return false;
    }
    if (!Objects.equals(this.workersGroupSize, cluster.workersGroupSize)) {
      return false;
    }
    if (!Objects.equals(this.serviceType, cluster.serviceType)) {
      return false;
    }
    if (!Objects.equals(this.environmentType, cluster.environmentType)) {
      return false;
    }
    if (!Objects.equals(this.environmentCrn, cluster.environmentCrn)) {
      return false;
    }
    if (!Objects.equals(this.automaticTerminationCondition, cluster.automaticTerminationCondition)) {
      return false;
    }
    if (!Objects.equals(this.failureCodes, cluster.failureCodes)) {
      return false;
    }
    if (!Objects.equals(this.failureReason, cluster.failureReason)) {
      return false;
    }
    if (!Objects.equals(this.logArchiveLocation, cluster.logArchiveLocation)) {
      return false;
    }
    if (!Objects.equals(this.clouderaManagerEndpoint, cluster.clouderaManagerEndpoint)) {
      return false;
    }
    if (!Objects.equals(this.computeWorkersConfiguration, cluster.computeWorkersConfiguration)) {
      return false;
    }
    if (!Objects.equals(this.workersConfiguration, cluster.workersConfiguration)) {
      return false;
    }
    if (!Objects.equals(this.workloadAnalyticsEnabled, cluster.workloadAnalyticsEnabled)) {
      return false;
    }
    if (!Objects.equals(this.navigatorConfiguration, cluster.navigatorConfiguration)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(clusterName, crn, creationDate, status, cdhVersion, instanceType, hasInstanceBootstrapScript, workersGroupSize, serviceType, environmentType, environmentCrn, automaticTerminationCondition, failureCodes, failureReason, logArchiveLocation, clouderaManagerEndpoint, computeWorkersConfiguration, workersConfiguration, workloadAnalyticsEnabled, navigatorConfiguration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cluster {\n");
    sb.append("    clusterName: ").append(toIndentedString(clusterName)).append("\n");
    sb.append("    crn: ").append(toIndentedString(crn)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    cdhVersion: ").append(toIndentedString(cdhVersion)).append("\n");
    sb.append("    instanceType: ").append(toIndentedString(instanceType)).append("\n");
    sb.append("    hasInstanceBootstrapScript: ").append(toIndentedString(hasInstanceBootstrapScript)).append("\n");
    sb.append("    workersGroupSize: ").append(toIndentedString(workersGroupSize)).append("\n");
    sb.append("    serviceType: ").append(toIndentedString(serviceType)).append("\n");
    sb.append("    environmentType: ").append(toIndentedString(environmentType)).append("\n");
    sb.append("    environmentCrn: ").append(toIndentedString(environmentCrn)).append("\n");
    sb.append("    automaticTerminationCondition: ").append(toIndentedString(automaticTerminationCondition)).append("\n");
    sb.append("    failureCodes: ").append(toIndentedString(failureCodes)).append("\n");
    sb.append("    failureReason: ").append(toIndentedString(failureReason)).append("\n");
    sb.append("    logArchiveLocation: ").append(toIndentedString(logArchiveLocation)).append("\n");
    sb.append("    clouderaManagerEndpoint: ").append(toIndentedString(clouderaManagerEndpoint)).append("\n");
    sb.append("    computeWorkersConfiguration: ").append(toIndentedString(computeWorkersConfiguration)).append("\n");
    sb.append("    workersConfiguration: ").append(toIndentedString(workersConfiguration)).append("\n");
    sb.append("    workloadAnalyticsEnabled: ").append(toIndentedString(workloadAnalyticsEnabled)).append("\n");
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

