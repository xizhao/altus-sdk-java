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

/**
 * Container for information required to set up an AWS cross-account access role.
 **/
@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-02-21T23:00:25.422-08:00")
public class InfoForAWSCrossAccountAccess  {

  /**
   * The AWS IAM role that will be used by Cloudera when assuming the customer provided cross-account access role when accessing the cusotmer's AWS account.
   **/
  private String clouderaRoleARN = null;

  /**
   * The role that will be used by Cloudera to assume the cross-account access role in the customer AWS account.
   **/
  private String clouderaAccountId = null;

  /**
   * The external ID that will be used by Cloudera when assuming the customer provided cross-account access role when accessing the customer's AWS account.
   **/
  private String externalIdForAWSDelegatedAccess = null;

  /**
   * Getter for clouderaRoleARN.
   **/
  @JsonProperty("clouderaRoleARN")
  public String getClouderaRoleARN() {
    return clouderaRoleARN;
  }

  /**
   * Setter for clouderaRoleARN.
   **/
  public void setClouderaRoleARN(String clouderaRoleARN) {
    this.clouderaRoleARN = clouderaRoleARN;
  }

  /**
   * Getter for clouderaAccountId.
   **/
  @JsonProperty("clouderaAccountId")
  public String getClouderaAccountId() {
    return clouderaAccountId;
  }

  /**
   * Setter for clouderaAccountId.
   **/
  public void setClouderaAccountId(String clouderaAccountId) {
    this.clouderaAccountId = clouderaAccountId;
  }

  /**
   * Getter for externalIdForAWSDelegatedAccess.
   **/
  @JsonProperty("externalIdForAWSDelegatedAccess")
  public String getExternalIdForAWSDelegatedAccess() {
    return externalIdForAWSDelegatedAccess;
  }

  /**
   * Setter for externalIdForAWSDelegatedAccess.
   **/
  public void setExternalIdForAWSDelegatedAccess(String externalIdForAWSDelegatedAccess) {
    this.externalIdForAWSDelegatedAccess = externalIdForAWSDelegatedAccess;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InfoForAWSCrossAccountAccess infoForAWSCrossAccountAccess = (InfoForAWSCrossAccountAccess) o;
    if (!Objects.equals(this.clouderaRoleARN, infoForAWSCrossAccountAccess.clouderaRoleARN)) {
      return false;
    }
    if (!Objects.equals(this.clouderaAccountId, infoForAWSCrossAccountAccess.clouderaAccountId)) {
      return false;
    }
    if (!Objects.equals(this.externalIdForAWSDelegatedAccess, infoForAWSCrossAccountAccess.externalIdForAWSDelegatedAccess)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(clouderaRoleARN, clouderaAccountId, externalIdForAWSDelegatedAccess);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InfoForAWSCrossAccountAccess {\n");
    sb.append("    clouderaRoleARN: ").append(toIndentedString(clouderaRoleARN)).append("\n");
    sb.append("    clouderaAccountId: ").append(toIndentedString(clouderaAccountId)).append("\n");
    sb.append("    externalIdForAWSDelegatedAccess: ").append(toIndentedString(externalIdForAWSDelegatedAccess)).append("\n");
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

