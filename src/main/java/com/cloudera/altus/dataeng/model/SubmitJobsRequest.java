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
import com.cloudera.altus.dataeng.model.JobRequest;
import java.util.*;

/**
 * Request object for a submit jobs request.
 **/
@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-02-21T23:00:25.094-08:00")
public class SubmitJobsRequest  {

  /**
   * The name or CRN cluster on which to run the job.
   **/
  private String clusterName = null;

  /**
   * The jobs to submit. Each job in the list should specify only one of hiveJob, sparkJob, pySparkJob, or mr2Job.
   **/
  private List<JobRequest> jobs = new ArrayList<JobRequest>();

  /**
   * A name for the group of submitted jobs. If not specified and this is a request to submit a single, named job, the job submission group name will match the job name. Otherwise, the job submission group name will match the generated job submission group ID. This name must have at least one character and a maximum of 128 characters. It must contain only alphanumeric characters, spaces, colons, hyphens and underscores, and can only start and end with alphanumeric characters and underscores. Names are case-sensitive.
   **/
  private String jobSubmissionGroupName = null;

  /**
   * Getter for clusterName.
   **/
  @JsonProperty("clusterName")
  public String getClusterName() {
    return clusterName;
  }

  /**
   * Setter for clusterName.
   **/
  public void setClusterName(String clusterName) {
    this.clusterName = clusterName;
  }

  /**
   * Getter for jobs.
   **/
  @JsonProperty("jobs")
  public List<JobRequest> getJobs() {
    return jobs;
  }

  /**
   * Setter for jobs.
   **/
  public void setJobs(List<JobRequest> jobs) {
    this.jobs = jobs;
  }

  /**
   * Getter for jobSubmissionGroupName.
   **/
  @JsonProperty("jobSubmissionGroupName")
  public String getJobSubmissionGroupName() {
    return jobSubmissionGroupName;
  }

  /**
   * Setter for jobSubmissionGroupName.
   **/
  public void setJobSubmissionGroupName(String jobSubmissionGroupName) {
    this.jobSubmissionGroupName = jobSubmissionGroupName;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubmitJobsRequest submitJobsRequest = (SubmitJobsRequest) o;
    if (!Objects.equals(this.clusterName, submitJobsRequest.clusterName)) {
      return false;
    }
    if (!Objects.equals(this.jobs, submitJobsRequest.jobs)) {
      return false;
    }
    if (!Objects.equals(this.jobSubmissionGroupName, submitJobsRequest.jobSubmissionGroupName)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(clusterName, jobs, jobSubmissionGroupName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubmitJobsRequest {\n");
    sb.append("    clusterName: ").append(toIndentedString(clusterName)).append("\n");
    sb.append("    jobs: ").append(toIndentedString(jobs)).append("\n");
    sb.append("    jobSubmissionGroupName: ").append(toIndentedString(jobSubmissionGroupName)).append("\n");
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

