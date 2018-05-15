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
import com.cloudera.altus.environments.model.AwsNavigatorConfigurationRequest;
import com.cloudera.altus.environments.model.S3GuardConfigurationRequest;
import com.cloudera.altus.environments.model.WorkloadAnalyticsConfigurationRequest;
import java.util.*;

/**
 * Request object for a CreateAWSEnvironment request.
 **/
@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-05-15T16:32:04.279-07:00")
public class CreateAWSEnvironmentRequest  {

  /**
   * The name of the environment. This name must be unique, must have a maximum of 128 characters, and must contain only alphanumeric characters and hyphens. Names are case-sensitive.
   **/
  private String name = null;

  /**
   * The ARN of the delegated role.
   **/
  private String delegatedRoleArn = null;

  /**
   * The name of the IAM instance profile.
   **/
  private String instanceProfileName = null;

  /**
   * The network subnets.
   **/
  private List<String> subnets = new ArrayList<String>();

  /**
   * The security groups.
   **/
  private List<String> securityGroups = new ArrayList<String>();

  /**
   * The network region.
   **/
  private String region = null;

  /**
   * The name of the S3 log archive bucket in which cluster logs will be stored.
   **/
  private String logArchiveBucketName = null;

  /**
   * The flag to allow auto registration of SSH keys provided during cluster creation. Key pairs will be imported with name \\'CLOUDERA-\\' followed by the corresponding private key fingerprint.
   **/
  private Boolean autoRegisterClusterSshKeys = null;

  /**
   * The configurations for S3Guard (S3 consistent view layer).
   **/
  private S3GuardConfigurationRequest s3GuardConfiguration = null;

  /**
   * Configuration for integration with Altus Workload Analytics.
   **/
  private WorkloadAnalyticsConfigurationRequest workloadAnalyticsConfiguration = null;

  /**
   * The configurations for Cloudera Navigator integration.
   **/
  private AwsNavigatorConfigurationRequest navigatorConfiguration = null;

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
   * Getter for delegatedRoleArn.
   **/
  @JsonProperty("delegatedRoleArn")
  public String getDelegatedRoleArn() {
    return delegatedRoleArn;
  }

  /**
   * Setter for delegatedRoleArn.
   **/
  public void setDelegatedRoleArn(String delegatedRoleArn) {
    this.delegatedRoleArn = delegatedRoleArn;
  }

  /**
   * Getter for instanceProfileName.
   **/
  @JsonProperty("instanceProfileName")
  public String getInstanceProfileName() {
    return instanceProfileName;
  }

  /**
   * Setter for instanceProfileName.
   **/
  public void setInstanceProfileName(String instanceProfileName) {
    this.instanceProfileName = instanceProfileName;
  }

  /**
   * Getter for subnets.
   **/
  @JsonProperty("subnets")
  public List<String> getSubnets() {
    return subnets;
  }

  /**
   * Setter for subnets.
   **/
  public void setSubnets(List<String> subnets) {
    this.subnets = subnets;
  }

  /**
   * Getter for securityGroups.
   **/
  @JsonProperty("securityGroups")
  public List<String> getSecurityGroups() {
    return securityGroups;
  }

  /**
   * Setter for securityGroups.
   **/
  public void setSecurityGroups(List<String> securityGroups) {
    this.securityGroups = securityGroups;
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
   * Getter for logArchiveBucketName.
   **/
  @JsonProperty("logArchiveBucketName")
  public String getLogArchiveBucketName() {
    return logArchiveBucketName;
  }

  /**
   * Setter for logArchiveBucketName.
   **/
  public void setLogArchiveBucketName(String logArchiveBucketName) {
    this.logArchiveBucketName = logArchiveBucketName;
  }

  /**
   * Getter for autoRegisterClusterSshKeys.
   **/
  @JsonProperty("autoRegisterClusterSshKeys")
  public Boolean getAutoRegisterClusterSshKeys() {
    return autoRegisterClusterSshKeys;
  }

  /**
   * Setter for autoRegisterClusterSshKeys.
   **/
  public void setAutoRegisterClusterSshKeys(Boolean autoRegisterClusterSshKeys) {
    this.autoRegisterClusterSshKeys = autoRegisterClusterSshKeys;
  }

  /**
   * Getter for s3GuardConfiguration.
   **/
  @JsonProperty("s3GuardConfiguration")
  public S3GuardConfigurationRequest getS3GuardConfiguration() {
    return s3GuardConfiguration;
  }

  /**
   * Setter for s3GuardConfiguration.
   **/
  public void setS3GuardConfiguration(S3GuardConfigurationRequest s3GuardConfiguration) {
    this.s3GuardConfiguration = s3GuardConfiguration;
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
   * Getter for navigatorConfiguration.
   **/
  @JsonProperty("navigatorConfiguration")
  public AwsNavigatorConfigurationRequest getNavigatorConfiguration() {
    return navigatorConfiguration;
  }

  /**
   * Setter for navigatorConfiguration.
   **/
  public void setNavigatorConfiguration(AwsNavigatorConfigurationRequest navigatorConfiguration) {
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
    CreateAWSEnvironmentRequest createAWSEnvironmentRequest = (CreateAWSEnvironmentRequest) o;
    if (!Objects.equals(this.name, createAWSEnvironmentRequest.name)) {
      return false;
    }
    if (!Objects.equals(this.delegatedRoleArn, createAWSEnvironmentRequest.delegatedRoleArn)) {
      return false;
    }
    if (!Objects.equals(this.instanceProfileName, createAWSEnvironmentRequest.instanceProfileName)) {
      return false;
    }
    if (!Objects.equals(this.subnets, createAWSEnvironmentRequest.subnets)) {
      return false;
    }
    if (!Objects.equals(this.securityGroups, createAWSEnvironmentRequest.securityGroups)) {
      return false;
    }
    if (!Objects.equals(this.region, createAWSEnvironmentRequest.region)) {
      return false;
    }
    if (!Objects.equals(this.logArchiveBucketName, createAWSEnvironmentRequest.logArchiveBucketName)) {
      return false;
    }
    if (!Objects.equals(this.autoRegisterClusterSshKeys, createAWSEnvironmentRequest.autoRegisterClusterSshKeys)) {
      return false;
    }
    if (!Objects.equals(this.s3GuardConfiguration, createAWSEnvironmentRequest.s3GuardConfiguration)) {
      return false;
    }
    if (!Objects.equals(this.workloadAnalyticsConfiguration, createAWSEnvironmentRequest.workloadAnalyticsConfiguration)) {
      return false;
    }
    if (!Objects.equals(this.navigatorConfiguration, createAWSEnvironmentRequest.navigatorConfiguration)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, delegatedRoleArn, instanceProfileName, subnets, securityGroups, region, logArchiveBucketName, autoRegisterClusterSshKeys, s3GuardConfiguration, workloadAnalyticsConfiguration, navigatorConfiguration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateAWSEnvironmentRequest {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    delegatedRoleArn: ").append(toIndentedString(delegatedRoleArn)).append("\n");
    sb.append("    instanceProfileName: ").append(toIndentedString(instanceProfileName)).append("\n");
    sb.append("    subnets: ").append(toIndentedString(subnets)).append("\n");
    sb.append("    securityGroups: ").append(toIndentedString(securityGroups)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    logArchiveBucketName: ").append(toIndentedString(logArchiveBucketName)).append("\n");
    sb.append("    autoRegisterClusterSshKeys: ").append(toIndentedString(autoRegisterClusterSshKeys)).append("\n");
    sb.append("    s3GuardConfiguration: ").append(toIndentedString(s3GuardConfiguration)).append("\n");
    sb.append("    workloadAnalyticsConfiguration: ").append(toIndentedString(workloadAnalyticsConfiguration)).append("\n");
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

