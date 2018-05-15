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
 * Object used to submit a MR2 job.
 **/
@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-05-15T16:32:03.781-07:00")
public class MR2JobRequest  {

  /**
   * MR2 application main class. The entry point for your application.
   **/
  private String mainClass = null;

  /**
   * A list of jars to be added to the classpath (e.g. s3a://bucket-name/wordcount.jar).
   **/
  private List<String> jars = new ArrayList<String>();

  /**
   * Arguments for the MR2 application. They will be passed to the main method of the main class.
   **/
  private List<String> arguments = new ArrayList<String>();

  /**
   * A list of Java options for the JVM.
   **/
  private String javaOpts = null;

  /**
   * An optional XML document containing client configurations for MR2 or a local path when using the CLI (e.g. file:///absolute/path/to/job1.xml).
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
    MR2JobRequest mR2JobRequest = (MR2JobRequest) o;
    if (!Objects.equals(this.mainClass, mR2JobRequest.mainClass)) {
      return false;
    }
    if (!Objects.equals(this.jars, mR2JobRequest.jars)) {
      return false;
    }
    if (!Objects.equals(this.arguments, mR2JobRequest.arguments)) {
      return false;
    }
    if (!Objects.equals(this.javaOpts, mR2JobRequest.javaOpts)) {
      return false;
    }
    if (!Objects.equals(this.jobXml, mR2JobRequest.jobXml)) {
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
    sb.append("class MR2JobRequest {\n");
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

