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
import com.cloudera.altus.dataeng.model.EbsConfiguration;

/**
 * AWS-specific instance configuration.
 **/
@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-05-15T16:32:03.781-07:00")
public class AWSInstanceConfiguration  {

  /**
   * Use AWS spot instances for this group (bidUSDPerHr becomes mandatory).
   **/
  private Boolean useSpot = null;

  /**
   * Bid price for AWS Spot instances in USD / hour.
   **/
  private Float bidUSDPerHr = null;

  /**
   * The per-instance EBS configuration.
   **/
  private EbsConfiguration ebsConfiguration = null;

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
  public EbsConfiguration getEbsConfiguration() {
    return ebsConfiguration;
  }

  /**
   * Setter for ebsConfiguration.
   **/
  public void setEbsConfiguration(EbsConfiguration ebsConfiguration) {
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
    AWSInstanceConfiguration aWSInstanceConfiguration = (AWSInstanceConfiguration) o;
    if (!Objects.equals(this.useSpot, aWSInstanceConfiguration.useSpot)) {
      return false;
    }
    if (!Objects.equals(this.bidUSDPerHr, aWSInstanceConfiguration.bidUSDPerHr)) {
      return false;
    }
    if (!Objects.equals(this.ebsConfiguration, aWSInstanceConfiguration.ebsConfiguration)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(useSpot, bidUSDPerHr, ebsConfiguration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AWSInstanceConfiguration {\n");
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

