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
import com.cloudera.altus.environments.model.InfoForAzureCrossAccountAccess;

/**
 * Response object for a GetInfoForAzureCrossAccountAccess request.
 **/
@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-05-15T16:32:04.279-07:00")
public class GetInfoForAzureCrossAccountAccessResponse extends AltusResponse {

  /**
   * The information required for performing the Azure consent workflow.
   **/
  private InfoForAzureCrossAccountAccess infoForAzureCrossAccountAccess = null;

  /**
   * Getter for infoForAzureCrossAccountAccess.
   **/
  @JsonProperty("infoForAzureCrossAccountAccess")
  public InfoForAzureCrossAccountAccess getInfoForAzureCrossAccountAccess() {
    return infoForAzureCrossAccountAccess;
  }

  /**
   * Setter for infoForAzureCrossAccountAccess.
   **/
  public void setInfoForAzureCrossAccountAccess(InfoForAzureCrossAccountAccess infoForAzureCrossAccountAccess) {
    this.infoForAzureCrossAccountAccess = infoForAzureCrossAccountAccess;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetInfoForAzureCrossAccountAccessResponse getInfoForAzureCrossAccountAccessResponse = (GetInfoForAzureCrossAccountAccessResponse) o;
    if (!Objects.equals(this.infoForAzureCrossAccountAccess, getInfoForAzureCrossAccountAccessResponse.infoForAzureCrossAccountAccess)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(infoForAzureCrossAccountAccess, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetInfoForAzureCrossAccountAccessResponse {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    infoForAzureCrossAccountAccess: ").append(toIndentedString(infoForAzureCrossAccountAccess)).append("\n");
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

