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
 * A network endpoint that has both a public and a private IP address.
 **/
@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-05-02T12:03:45.446-07:00")
public class Endpoint  {

  /**
   * A private IP address. This is only accessible from within the local network.
   **/
  private String privateIpAddress = null;

  /**
   * A public IP address. This is internet routable.
   **/
  private String publicIpAddress = null;

  /**
   * A port.
   **/
  private Integer port = null;

  /**
   * Getter for privateIpAddress.
   **/
  @JsonProperty("privateIpAddress")
  public String getPrivateIpAddress() {
    return privateIpAddress;
  }

  /**
   * Setter for privateIpAddress.
   **/
  public void setPrivateIpAddress(String privateIpAddress) {
    this.privateIpAddress = privateIpAddress;
  }

  /**
   * Getter for publicIpAddress.
   **/
  @JsonProperty("publicIpAddress")
  public String getPublicIpAddress() {
    return publicIpAddress;
  }

  /**
   * Setter for publicIpAddress.
   **/
  public void setPublicIpAddress(String publicIpAddress) {
    this.publicIpAddress = publicIpAddress;
  }

  /**
   * Getter for port.
   **/
  @JsonProperty("port")
  public Integer getPort() {
    return port;
  }

  /**
   * Setter for port.
   **/
  public void setPort(Integer port) {
    this.port = port;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Endpoint endpoint = (Endpoint) o;
    if (!Objects.equals(this.privateIpAddress, endpoint.privateIpAddress)) {
      return false;
    }
    if (!Objects.equals(this.publicIpAddress, endpoint.publicIpAddress)) {
      return false;
    }
    if (!Objects.equals(this.port, endpoint.port)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(privateIpAddress, publicIpAddress, port);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Endpoint {\n");
    sb.append("    privateIpAddress: ").append(toIndentedString(privateIpAddress)).append("\n");
    sb.append("    publicIpAddress: ").append(toIndentedString(publicIpAddress)).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
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

