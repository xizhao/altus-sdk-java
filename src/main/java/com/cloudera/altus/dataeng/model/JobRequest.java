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
import com.cloudera.altus.dataeng.model.HiveJobRequest;
import com.cloudera.altus.dataeng.model.MR2JobRequest;
import com.cloudera.altus.dataeng.model.PySparkJobRequest;
import com.cloudera.altus.dataeng.model.SparkJobRequest;

/**
 * Object used to submit a job of any type.
 **/
@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-05-02T12:03:45.446-07:00")
public class JobRequest  {

  /**
   * A name for the job. If not specified, the job name depends on whether the job was submitted individually or in a list of jobs. If submitted individually the job name will be the job ID. If submitted in a list of jobs, the job will be named after the job submission group and the job's index in the list. This name must have at least one character and a maximum of 128 characters. It must contain only alphanumeric characters, spaces, colons, hyphens and underscores, and can only start and end with alphanumeric characters and underscores. Names are case-sensitive.
   **/
  private String name = null;

  /**
   * The action taken on failure if an error is encountered processing the job. If not specified, INTERRUPT_JOB_QUEUE will be used for the job.
   **/
  private String failureAction = null;

  /**
   * The Hive specific portion of the job request. This must be set for a Hive job and must not be set for other job types.
   **/
  private HiveJobRequest hiveJob = null;

  /**
   * The Spark specific portion of the job request. This must be set for a Spark job and must not be set for other job types.
   **/
  private SparkJobRequest sparkJob = null;

  /**
   * The PySpark specific portion of the job request. This must be set for a PySpark job and must not be set for other job types.
   **/
  private PySparkJobRequest pySparkJob = null;

  /**
   * The MR2 specific portion of the job request. This must be set for an MR2 job and must not be set for other job types.
   **/
  private MR2JobRequest mr2Job = null;

  /**
   * Getter for name.
   **/
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  /**
   * Setter for name.
   **/
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter for failureAction.
   **/
  @JsonProperty("failureAction")
  public String getFailureAction() {
    return failureAction;
  }

  /**
   * Setter for failureAction.
   **/
  public void setFailureAction(String failureAction) {
    this.failureAction = failureAction;
  }

  /**
   * Getter for hiveJob.
   **/
  @JsonProperty("hiveJob")
  public HiveJobRequest getHiveJob() {
    return hiveJob;
  }

  /**
   * Setter for hiveJob.
   **/
  public void setHiveJob(HiveJobRequest hiveJob) {
    this.hiveJob = hiveJob;
  }

  /**
   * Getter for sparkJob.
   **/
  @JsonProperty("sparkJob")
  public SparkJobRequest getSparkJob() {
    return sparkJob;
  }

  /**
   * Setter for sparkJob.
   **/
  public void setSparkJob(SparkJobRequest sparkJob) {
    this.sparkJob = sparkJob;
  }

  /**
   * Getter for pySparkJob.
   **/
  @JsonProperty("pySparkJob")
  public PySparkJobRequest getPySparkJob() {
    return pySparkJob;
  }

  /**
   * Setter for pySparkJob.
   **/
  public void setPySparkJob(PySparkJobRequest pySparkJob) {
    this.pySparkJob = pySparkJob;
  }

  /**
   * Getter for mr2Job.
   **/
  @JsonProperty("mr2Job")
  public MR2JobRequest getMr2Job() {
    return mr2Job;
  }

  /**
   * Setter for mr2Job.
   **/
  public void setMr2Job(MR2JobRequest mr2Job) {
    this.mr2Job = mr2Job;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobRequest jobRequest = (JobRequest) o;
    if (!Objects.equals(this.name, jobRequest.name)) {
      return false;
    }
    if (!Objects.equals(this.failureAction, jobRequest.failureAction)) {
      return false;
    }
    if (!Objects.equals(this.hiveJob, jobRequest.hiveJob)) {
      return false;
    }
    if (!Objects.equals(this.sparkJob, jobRequest.sparkJob)) {
      return false;
    }
    if (!Objects.equals(this.pySparkJob, jobRequest.pySparkJob)) {
      return false;
    }
    if (!Objects.equals(this.mr2Job, jobRequest.mr2Job)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, failureAction, hiveJob, sparkJob, pySparkJob, mr2Job);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobRequest {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    failureAction: ").append(toIndentedString(failureAction)).append("\n");
    sb.append("    hiveJob: ").append(toIndentedString(hiveJob)).append("\n");
    sb.append("    sparkJob: ").append(toIndentedString(sparkJob)).append("\n");
    sb.append("    pySparkJob: ").append(toIndentedString(pySparkJob)).append("\n");
    sb.append("    mr2Job: ").append(toIndentedString(mr2Job)).append("\n");
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

