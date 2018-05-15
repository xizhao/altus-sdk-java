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

/**
 * An EBS configuration for an instance. Any EBS disks configured are added in addition to the root volume.
 **/
@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-05-15T16:32:03.781-07:00")
public class EbsConfiguration  {

  /**
   * Size for each volume in GiB.
   **/
  private Integer sizeInGiB = null;

  /**
   * The volume type.
   **/
  private String volumeType = null;

  /**
   * Number of volumes per instance. The default and minimum value is 1. The miximum number is 15.
   **/
  private Integer volumesPerInstance = null;

  /**
   * Getter for sizeInGiB.
   **/
  @JsonProperty("sizeInGiB")
  public Integer getSizeInGiB() {
    return sizeInGiB;
  }

  /**
   * Setter for sizeInGiB.
   **/
  public void setSizeInGiB(Integer sizeInGiB) {
    this.sizeInGiB = sizeInGiB;
  }

  /**
   * Getter for volumeType.
   **/
  @JsonProperty("volumeType")
  public String getVolumeType() {
    return volumeType;
  }

  /**
   * Setter for volumeType.
   **/
  public void setVolumeType(String volumeType) {
    this.volumeType = volumeType;
  }

  /**
   * Getter for volumesPerInstance.
   **/
  @JsonProperty("volumesPerInstance")
  public Integer getVolumesPerInstance() {
    return volumesPerInstance;
  }

  /**
   * Setter for volumesPerInstance.
   **/
  public void setVolumesPerInstance(Integer volumesPerInstance) {
    this.volumesPerInstance = volumesPerInstance;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EbsConfiguration ebsConfiguration = (EbsConfiguration) o;
    if (!Objects.equals(this.sizeInGiB, ebsConfiguration.sizeInGiB)) {
      return false;
    }
    if (!Objects.equals(this.volumeType, ebsConfiguration.volumeType)) {
      return false;
    }
    if (!Objects.equals(this.volumesPerInstance, ebsConfiguration.volumesPerInstance)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(sizeInGiB, volumeType, volumesPerInstance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EbsConfiguration {\n");
    sb.append("    sizeInGiB: ").append(toIndentedString(sizeInGiB)).append("\n");
    sb.append("    volumeType: ").append(toIndentedString(volumeType)).append("\n");
    sb.append("    volumesPerInstance: ").append(toIndentedString(volumesPerInstance)).append("\n");
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

