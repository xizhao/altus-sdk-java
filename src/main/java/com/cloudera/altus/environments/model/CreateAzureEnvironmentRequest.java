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
import com.cloudera.altus.environments.model.WorkloadAnalyticsConfigurationRequest;

/**
 * Request object for a CreateAzureEnvironment request.
 **/
@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-05-15T16:32:04.279-07:00")
public class CreateAzureEnvironmentRequest  {

  /**
   * The name of the environment. This name must be unique, must have a maximum of 128 characters, and must contain only alphanumeric characters and hyphens. Names are case-sensitive.
   **/
  private String name = null;

  /**
   * The subscription ID.
   **/
  private String subscriptionId = null;

  /**
   * Supported Azure regions. Altus Data Engineering supports Azure regions with the Azure Data Lake Store service.
   **/
  private String region = null;

  /**
   * The Azure AD tenant ID for the Azure subscription.
   **/
  private String aadTenantId = null;

  /**
   * The resource group where the virtual network is located.
   **/
  private String vnetResourceGroup = null;

  /**
   * The virtual network name.
   **/
  private String vnetName = null;

  /**
   * The subnet name.
   **/
  private String subnetName = null;

  /**
   * The resource group where the network security group is located.
   **/
  private String networkSecurityGroupResourceGroup = null;

  /**
   * The network security group name.
   **/
  private String networkSecurityGroupName = null;

  /**
   * The resource group where the cluster nodes are located.
   **/
  private String clusterNodeResourceGroup = null;

  /**
   * This field is no longer supported. Use User Assigned MSI Resource Group and User Assigned MSI Name instead.
   **/
  private String aadGroupName = null;

  /**
   * The resource group where the Assigned Managed Service Identity is located.
   **/
  private String userAssignedMsiResourceGroup = null;

  /**
   * The User Assigned Managed Service Identity Name.
   **/
  private String userAssignedMsiName = null;

  /**
   * Configuration for integration with Altus Workload Analytics.
   **/
  private WorkloadAnalyticsConfigurationRequest workloadAnalyticsConfiguration = null;

  /**
   * The full URL of the ADLS folder in which cluster logs will be stored.
   **/
  private String logArchiveFolderPath = null;

  /**
   * Getter for name.
   **/
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  /**
   * Setter for name.
   **/
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter for subscriptionId.
   **/
  @JsonProperty("subscriptionId")
  public String getSubscriptionId() {
    return subscriptionId;
  }

  /**
   * Setter for subscriptionId.
   **/
  public void setSubscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  /**
   * Getter for region.
   **/
  @JsonProperty("region")
  public String getRegion() {
    return region;
  }

  /**
   * Setter for region.
   **/
  public void setRegion(String region) {
    this.region = region;
  }

  /**
   * Getter for aadTenantId.
   **/
  @JsonProperty("aadTenantId")
  public String getAadTenantId() {
    return aadTenantId;
  }

  /**
   * Setter for aadTenantId.
   **/
  public void setAadTenantId(String aadTenantId) {
    this.aadTenantId = aadTenantId;
  }

  /**
   * Getter for vnetResourceGroup.
   **/
  @JsonProperty("vnetResourceGroup")
  public String getVnetResourceGroup() {
    return vnetResourceGroup;
  }

  /**
   * Setter for vnetResourceGroup.
   **/
  public void setVnetResourceGroup(String vnetResourceGroup) {
    this.vnetResourceGroup = vnetResourceGroup;
  }

  /**
   * Getter for vnetName.
   **/
  @JsonProperty("vnetName")
  public String getVnetName() {
    return vnetName;
  }

  /**
   * Setter for vnetName.
   **/
  public void setVnetName(String vnetName) {
    this.vnetName = vnetName;
  }

  /**
   * Getter for subnetName.
   **/
  @JsonProperty("subnetName")
  public String getSubnetName() {
    return subnetName;
  }

  /**
   * Setter for subnetName.
   **/
  public void setSubnetName(String subnetName) {
    this.subnetName = subnetName;
  }

  /**
   * Getter for networkSecurityGroupResourceGroup.
   **/
  @JsonProperty("networkSecurityGroupResourceGroup")
  public String getNetworkSecurityGroupResourceGroup() {
    return networkSecurityGroupResourceGroup;
  }

  /**
   * Setter for networkSecurityGroupResourceGroup.
   **/
  public void setNetworkSecurityGroupResourceGroup(String networkSecurityGroupResourceGroup) {
    this.networkSecurityGroupResourceGroup = networkSecurityGroupResourceGroup;
  }

  /**
   * Getter for networkSecurityGroupName.
   **/
  @JsonProperty("networkSecurityGroupName")
  public String getNetworkSecurityGroupName() {
    return networkSecurityGroupName;
  }

  /**
   * Setter for networkSecurityGroupName.
   **/
  public void setNetworkSecurityGroupName(String networkSecurityGroupName) {
    this.networkSecurityGroupName = networkSecurityGroupName;
  }

  /**
   * Getter for clusterNodeResourceGroup.
   **/
  @JsonProperty("clusterNodeResourceGroup")
  public String getClusterNodeResourceGroup() {
    return clusterNodeResourceGroup;
  }

  /**
   * Setter for clusterNodeResourceGroup.
   **/
  public void setClusterNodeResourceGroup(String clusterNodeResourceGroup) {
    this.clusterNodeResourceGroup = clusterNodeResourceGroup;
  }

  /**
   * Getter for aadGroupName.
   **/
  @JsonProperty("aadGroupName")
  public String getAadGroupName() {
    return aadGroupName;
  }

  /**
   * Setter for aadGroupName.
   **/
  public void setAadGroupName(String aadGroupName) {
    this.aadGroupName = aadGroupName;
  }

  /**
   * Getter for userAssignedMsiResourceGroup.
   **/
  @JsonProperty("userAssignedMsiResourceGroup")
  public String getUserAssignedMsiResourceGroup() {
    return userAssignedMsiResourceGroup;
  }

  /**
   * Setter for userAssignedMsiResourceGroup.
   **/
  public void setUserAssignedMsiResourceGroup(String userAssignedMsiResourceGroup) {
    this.userAssignedMsiResourceGroup = userAssignedMsiResourceGroup;
  }

  /**
   * Getter for userAssignedMsiName.
   **/
  @JsonProperty("userAssignedMsiName")
  public String getUserAssignedMsiName() {
    return userAssignedMsiName;
  }

  /**
   * Setter for userAssignedMsiName.
   **/
  public void setUserAssignedMsiName(String userAssignedMsiName) {
    this.userAssignedMsiName = userAssignedMsiName;
  }

  /**
   * Getter for workloadAnalyticsConfiguration.
   **/
  @JsonProperty("workloadAnalyticsConfiguration")
  public WorkloadAnalyticsConfigurationRequest getWorkloadAnalyticsConfiguration() {
    return workloadAnalyticsConfiguration;
  }

  /**
   * Setter for workloadAnalyticsConfiguration.
   **/
  public void setWorkloadAnalyticsConfiguration(WorkloadAnalyticsConfigurationRequest workloadAnalyticsConfiguration) {
    this.workloadAnalyticsConfiguration = workloadAnalyticsConfiguration;
  }

  /**
   * Getter for logArchiveFolderPath.
   **/
  @JsonProperty("logArchiveFolderPath")
  public String getLogArchiveFolderPath() {
    return logArchiveFolderPath;
  }

  /**
   * Setter for logArchiveFolderPath.
   **/
  public void setLogArchiveFolderPath(String logArchiveFolderPath) {
    this.logArchiveFolderPath = logArchiveFolderPath;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateAzureEnvironmentRequest createAzureEnvironmentRequest = (CreateAzureEnvironmentRequest) o;
    if (!Objects.equals(this.name, createAzureEnvironmentRequest.name)) {
      return false;
    }
    if (!Objects.equals(this.subscriptionId, createAzureEnvironmentRequest.subscriptionId)) {
      return false;
    }
    if (!Objects.equals(this.region, createAzureEnvironmentRequest.region)) {
      return false;
    }
    if (!Objects.equals(this.aadTenantId, createAzureEnvironmentRequest.aadTenantId)) {
      return false;
    }
    if (!Objects.equals(this.vnetResourceGroup, createAzureEnvironmentRequest.vnetResourceGroup)) {
      return false;
    }
    if (!Objects.equals(this.vnetName, createAzureEnvironmentRequest.vnetName)) {
      return false;
    }
    if (!Objects.equals(this.subnetName, createAzureEnvironmentRequest.subnetName)) {
      return false;
    }
    if (!Objects.equals(this.networkSecurityGroupResourceGroup, createAzureEnvironmentRequest.networkSecurityGroupResourceGroup)) {
      return false;
    }
    if (!Objects.equals(this.networkSecurityGroupName, createAzureEnvironmentRequest.networkSecurityGroupName)) {
      return false;
    }
    if (!Objects.equals(this.clusterNodeResourceGroup, createAzureEnvironmentRequest.clusterNodeResourceGroup)) {
      return false;
    }
    if (!Objects.equals(this.aadGroupName, createAzureEnvironmentRequest.aadGroupName)) {
      return false;
    }
    if (!Objects.equals(this.userAssignedMsiResourceGroup, createAzureEnvironmentRequest.userAssignedMsiResourceGroup)) {
      return false;
    }
    if (!Objects.equals(this.userAssignedMsiName, createAzureEnvironmentRequest.userAssignedMsiName)) {
      return false;
    }
    if (!Objects.equals(this.workloadAnalyticsConfiguration, createAzureEnvironmentRequest.workloadAnalyticsConfiguration)) {
      return false;
    }
    if (!Objects.equals(this.logArchiveFolderPath, createAzureEnvironmentRequest.logArchiveFolderPath)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, subscriptionId, region, aadTenantId, vnetResourceGroup, vnetName, subnetName, networkSecurityGroupResourceGroup, networkSecurityGroupName, clusterNodeResourceGroup, aadGroupName, userAssignedMsiResourceGroup, userAssignedMsiName, workloadAnalyticsConfiguration, logArchiveFolderPath);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateAzureEnvironmentRequest {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    aadTenantId: ").append(toIndentedString(aadTenantId)).append("\n");
    sb.append("    vnetResourceGroup: ").append(toIndentedString(vnetResourceGroup)).append("\n");
    sb.append("    vnetName: ").append(toIndentedString(vnetName)).append("\n");
    sb.append("    subnetName: ").append(toIndentedString(subnetName)).append("\n");
    sb.append("    networkSecurityGroupResourceGroup: ").append(toIndentedString(networkSecurityGroupResourceGroup)).append("\n");
    sb.append("    networkSecurityGroupName: ").append(toIndentedString(networkSecurityGroupName)).append("\n");
    sb.append("    clusterNodeResourceGroup: ").append(toIndentedString(clusterNodeResourceGroup)).append("\n");
    sb.append("    aadGroupName: ").append(toIndentedString(aadGroupName)).append("\n");
    sb.append("    userAssignedMsiResourceGroup: ").append(toIndentedString(userAssignedMsiResourceGroup)).append("\n");
    sb.append("    userAssignedMsiName: ").append(toIndentedString(userAssignedMsiName)).append("\n");
    sb.append("    workloadAnalyticsConfiguration: ").append(toIndentedString(workloadAnalyticsConfiguration)).append("\n");
    sb.append("    logArchiveFolderPath: ").append(toIndentedString(logArchiveFolderPath)).append("\n");
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

