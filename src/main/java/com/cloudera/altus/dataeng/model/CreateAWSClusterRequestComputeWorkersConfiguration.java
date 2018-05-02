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
import com.cloudera.altus.dataeng.model.EbsConfigurationRequest;

/**
 * Defines compute workers group configuration, such as, size, bidding price and custom volume configurations.
 **/
@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-05-02T12:03:45.446-07:00")
public class CreateAWSClusterRequestComputeWorkersConfiguration  {

  /**
   * The compute workers group size.
   **/
  private Integer groupSize = null;

  /**
   * Use AWS spot instances for this group (bidUSDPerHr becomes mandatory).
   **/
  private Boolean useSpot = null;

  /**
   * Bid price for AWS Spot instances in USD per hour.
   **/
  private Float bidUSDPerHr = null;

  /**
   * Defines an EBS configuration. Any EBS disks configured here are added in addition to the root volume.
   **/
  private EbsConfigurationRequest ebsConfiguration = null;

  /**
   * Getter for groupSize.
   **/
  @JsonProperty("groupSize")
  public Integer getGroupSize() {
    return groupSize;
  }

  /**
   * Setter for groupSize.
   **/
  public void setGroupSize(Integer groupSize) {
    this.groupSize = groupSize;
  }

  /**
   * Getter for useSpot.
   **/
  @JsonProperty("useSpot")
  public Boolean getUseSpot() {
    return useSpot;
  }

  /**
   * Setter for useSpot.
   **/
  public void setUseSpot(Boolean useSpot) {
    this.useSpot = useSpot;
  }

  /**
   * Getter for bidUSDPerHr.
   **/
  @JsonProperty("bidUSDPerHr")
  public Float getBidUSDPerHr() {
    return bidUSDPerHr;
  }

  /**
   * Setter for bidUSDPerHr.
   **/
  public void setBidUSDPerHr(Float bidUSDPerHr) {
    this.bidUSDPerHr = bidUSDPerHr;
  }

  /**
   * Getter for ebsConfiguration.
   **/
  @JsonProperty("ebsConfiguration")
  public EbsConfigurationRequest getEbsConfiguration() {
    return ebsConfiguration;
  }

  /**
   * Setter for ebsConfiguration.
   **/
  public void setEbsConfiguration(EbsConfigurationRequest ebsConfiguration) {
    this.ebsConfiguration = ebsConfiguration;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateAWSClusterRequestComputeWorkersConfiguration createAWSClusterRequestComputeWorkersConfiguration = (CreateAWSClusterRequestComputeWorkersConfiguration) o;
    if (!Objects.equals(this.groupSize, createAWSClusterRequestComputeWorkersConfiguration.groupSize)) {
      return false;
    }
    if (!Objects.equals(this.useSpot, createAWSClusterRequestComputeWorkersConfiguration.useSpot)) {
      return false;
    }
    if (!Objects.equals(this.bidUSDPerHr, createAWSClusterRequestComputeWorkersConfiguration.bidUSDPerHr)) {
      return false;
    }
    if (!Objects.equals(this.ebsConfiguration, createAWSClusterRequestComputeWorkersConfiguration.ebsConfiguration)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupSize, useSpot, bidUSDPerHr, ebsConfiguration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateAWSClusterRequestComputeWorkersConfiguration {\n");
    sb.append("    groupSize: ").append(toIndentedString(groupSize)).append("\n");
    sb.append("    useSpot: ").append(toIndentedString(useSpot)).append("\n");
    sb.append("    bidUSDPerHr: ").append(toIndentedString(bidUSDPerHr)).append("\n");
    sb.append("    ebsConfiguration: ").append(toIndentedString(ebsConfiguration)).append("\n");
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

