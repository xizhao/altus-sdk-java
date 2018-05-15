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
import com.cloudera.altus.dataeng.model.Cluster;

/**
 * Response object for a create Azure cluster request.
 **/
@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-05-15T16:32:03.781-07:00")
public class CreateAzureClusterResponse extends AltusResponse {

  /**
   * The cluster that was created.
   **/
  private Cluster cluster = null;

  /**
   * The username that was created to login to cluster's Cloudera Manager as a readonly user. This value cannot be retrieved later.
   **/
  private String clouderaManagerUsername = null;

  /**
   * The password that was created to login to cluster's Cloudera Manager as a readonly user. This value cannot be retrieved later.
   **/
  private String clouderaManagerPassword = null;

  /**
   * Getter for cluster.
   **/
  @JsonProperty("cluster")
  public Cluster getCluster() {
    return cluster;
  }

  /**
   * Setter for cluster.
   **/
  public void setCluster(Cluster cluster) {
    this.cluster = cluster;
  }

  /**
   * Getter for clouderaManagerUsername.
   **/
  @JsonProperty("clouderaManagerUsername")
  public String getClouderaManagerUsername() {
    return clouderaManagerUsername;
  }

  /**
   * Setter for clouderaManagerUsername.
   **/
  public void setClouderaManagerUsername(String clouderaManagerUsername) {
    this.clouderaManagerUsername = clouderaManagerUsername;
  }

  /**
   * Getter for clouderaManagerPassword.
   **/
  @JsonProperty("clouderaManagerPassword")
  public String getClouderaManagerPassword() {
    return clouderaManagerPassword;
  }

  /**
   * Setter for clouderaManagerPassword.
   **/
  public void setClouderaManagerPassword(String clouderaManagerPassword) {
    this.clouderaManagerPassword = clouderaManagerPassword;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateAzureClusterResponse createAzureClusterResponse = (CreateAzureClusterResponse) o;
    if (!Objects.equals(this.cluster, createAzureClusterResponse.cluster)) {
      return false;
    }
    if (!Objects.equals(this.clouderaManagerUsername, createAzureClusterResponse.clouderaManagerUsername)) {
      return false;
    }
    if (!Objects.equals(this.clouderaManagerPassword, createAzureClusterResponse.clouderaManagerPassword)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(cluster, clouderaManagerUsername, clouderaManagerPassword, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateAzureClusterResponse {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    cluster: ").append(toIndentedString(cluster)).append("\n");
    sb.append("    clouderaManagerUsername: ").append(toIndentedString(clouderaManagerUsername)).append("\n");
    sb.append("    clouderaManagerPassword: ").append(toIndentedString(clouderaManagerPassword)).append("\n");
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

