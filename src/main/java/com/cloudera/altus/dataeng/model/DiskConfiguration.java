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
 * A Disk storage configuration for an instance. Any disks configured are added in addition to the root volume.
 **/
@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-05-15T16:32:03.781-07:00")
public class DiskConfiguration  {

  /**
   * Size of each data disk in GB.
   **/
  private Integer sizeGB = null;

  /**
   * Number of volumes per instance. The default and minimum value is 1. The miximum number is 15.
   **/
  private Integer dataDisksPerInstance = null;

  /**
   * The storage account type.
   **/
  private String storageAccountType = null;

  /**
   * Getter for sizeGB.
   **/
  @JsonProperty("sizeGB")
  public Integer getSizeGB() {
    return sizeGB;
  }

  /**
   * Setter for sizeGB.
   **/
  public void setSizeGB(Integer sizeGB) {
    this.sizeGB = sizeGB;
  }

  /**
   * Getter for dataDisksPerInstance.
   **/
  @JsonProperty("dataDisksPerInstance")
  public Integer getDataDisksPerInstance() {
    return dataDisksPerInstance;
  }

  /**
   * Setter for dataDisksPerInstance.
   **/
  public void setDataDisksPerInstance(Integer dataDisksPerInstance) {
    this.dataDisksPerInstance = dataDisksPerInstance;
  }

  /**
   * Getter for storageAccountType.
   **/
  @JsonProperty("storageAccountType")
  public String getStorageAccountType() {
    return storageAccountType;
  }

  /**
   * Setter for storageAccountType.
   **/
  public void setStorageAccountType(String storageAccountType) {
    this.storageAccountType = storageAccountType;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DiskConfiguration diskConfiguration = (DiskConfiguration) o;
    if (!Objects.equals(this.sizeGB, diskConfiguration.sizeGB)) {
      return false;
    }
    if (!Objects.equals(this.dataDisksPerInstance, diskConfiguration.dataDisksPerInstance)) {
      return false;
    }
    if (!Objects.equals(this.storageAccountType, diskConfiguration.storageAccountType)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(sizeGB, dataDisksPerInstance, storageAccountType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DiskConfiguration {\n");
    sb.append("    sizeGB: ").append(toIndentedString(sizeGB)).append("\n");
    sb.append("    dataDisksPerInstance: ").append(toIndentedString(dataDisksPerInstance)).append("\n");
    sb.append("    storageAccountType: ").append(toIndentedString(storageAccountType)).append("\n");
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

