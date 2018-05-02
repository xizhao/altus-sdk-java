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
import java.util.*;

/**
 * MR2 specific details of job. This will be set if the jobType is MR2.
 **/
@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-05-02T12:03:45.446-07:00")
public class JobMr2JobDetails  {

  /**
   * MR2 application main class.
   **/
  private String mainClass = null;

  /**
   * A list of jar files.
   **/
  private List<String> jars = new ArrayList<String>();

  /**
   * Arguments for the MR2 application.
   **/
  private List<String> arguments = new ArrayList<String>();

  /**
   * A list of Java JVM options.
   **/
  private String javaOpts = null;

  /**
   * XML document containing configuration for MR2.
   **/
  private String jobXml = null;

  /**
   * Getter for mainClass.
   **/
  @JsonProperty("mainClass")
  public String getMainClass() {
    return mainClass;
  }

  /**
   * Setter for mainClass.
   **/
  public void setMainClass(String mainClass) {
    this.mainClass = mainClass;
  }

  /**
   * Getter for jars.
   **/
  @JsonProperty("jars")
  public List<String> getJars() {
    return jars;
  }

  /**
   * Setter for jars.
   **/
  public void setJars(List<String> jars) {
    this.jars = jars;
  }

  /**
   * Getter for arguments.
   **/
  @JsonProperty("arguments")
  public List<String> getArguments() {
    return arguments;
  }

  /**
   * Setter for arguments.
   **/
  public void setArguments(List<String> arguments) {
    this.arguments = arguments;
  }

  /**
   * Getter for javaOpts.
   **/
  @JsonProperty("javaOpts")
  public String getJavaOpts() {
    return javaOpts;
  }

  /**
   * Setter for javaOpts.
   **/
  public void setJavaOpts(String javaOpts) {
    this.javaOpts = javaOpts;
  }

  /**
   * Getter for jobXml.
   **/
  @JsonProperty("jobXml")
  public String getJobXml() {
    return jobXml;
  }

  /**
   * Setter for jobXml.
   **/
  public void setJobXml(String jobXml) {
    this.jobXml = jobXml;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobMr2JobDetails jobMr2JobDetails = (JobMr2JobDetails) o;
    if (!Objects.equals(this.mainClass, jobMr2JobDetails.mainClass)) {
      return false;
    }
    if (!Objects.equals(this.jars, jobMr2JobDetails.jars)) {
      return false;
    }
    if (!Objects.equals(this.arguments, jobMr2JobDetails.arguments)) {
      return false;
    }
    if (!Objects.equals(this.javaOpts, jobMr2JobDetails.javaOpts)) {
      return false;
    }
    if (!Objects.equals(this.jobXml, jobMr2JobDetails.jobXml)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(mainClass, jars, arguments, javaOpts, jobXml);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobMr2JobDetails {\n");
    sb.append("    mainClass: ").append(toIndentedString(mainClass)).append("\n");
    sb.append("    jars: ").append(toIndentedString(jars)).append("\n");
    sb.append("    arguments: ").append(toIndentedString(arguments)).append("\n");
    sb.append("    javaOpts: ").append(toIndentedString(javaOpts)).append("\n");
    sb.append("    jobXml: ").append(toIndentedString(jobXml)).append("\n");
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

