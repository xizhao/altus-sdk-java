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
import com.cloudera.altus.dataeng.model.JobHiveJobDetails;
import com.cloudera.altus.dataeng.model.JobMr2JobDetails;
import com.cloudera.altus.dataeng.model.JobPySparkJobDetails;
import com.cloudera.altus.dataeng.model.JobSparkJobDetails;
import java.time.ZonedDateTime;

/**
 * Information about a job.
 **/
@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-05-02T12:03:45.446-07:00")
public class Job  {

  /**
   * The ID of the job.
   **/
  private String jobId = null;

  /**
   * The name of the job.
   **/
  private String jobName = null;

  /**
   * The CRN of the job.
   **/
  private String crn = null;

  /**
   * The date when the job was created.
   **/
  private ZonedDateTime creationDate = null;

  /**
   * The status of a job.
   **/
  private String status = null;

  /**
   * The CRN of the cluster.
   **/
  private String clusterCrn = null;

  /**
   * The CRN of the job submitter.
   **/
  private String submitterCrn = null;

  /**
   * The type of job.
   **/
  private String jobType = null;

  /**
   * The action taken on failure if an error is encountered processing the job.
   **/
  private String failureAction = null;

  /**
   * An ID assigned to the job shared by all jobs submitted in the same submit-jobs or create-cluster request.
   **/
  private String jobSubmissionGroupId = null;

  /**
   * A name assigned to the job shared by all jobs submitted in the same submit-jobs or create-cluster request.
   **/
  private String jobSubmissionGroupName = null;

  /**
   * The index of this job in the job list in its submit-jobs or create-cluster request.
   **/
  private Integer jobSubmissionGroupIndex = null;

  /**
   * The total number of jobs submitted in its submit-jobs or create-cluster request.
   **/
  private Integer jobSubmissionGroupSize = null;

  /**
   * Whether this job was run against a cluster configured to send data to Altus Workload Analytics.
   **/
  private Boolean workloadAnalyticsEnabled = null;

  /**
   * The CRN of the environment.
   **/
  private String environmentCrn = null;

  /**
   * The type of the environment.
   **/
  private String environmentType = null;

  /**
   * 
   **/
  private JobHiveJobDetails hiveJobDetails = null;

  /**
   * 
   **/
  private JobSparkJobDetails sparkJobDetails = null;

  /**
   * 
   **/
  private JobPySparkJobDetails pySparkJobDetails = null;

  /**
   * 
   **/
  private JobMr2JobDetails mr2JobDetails = null;

  /**
   * Getter for jobId.
   **/
  @JsonProperty("jobId")
  public String getJobId() {
    return jobId;
  }

  /**
   * Setter for jobId.
   **/
  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

  /**
   * Getter for jobName.
   **/
  @JsonProperty("jobName")
  public String getJobName() {
    return jobName;
  }

  /**
   * Setter for jobName.
   **/
  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

  /**
   * Getter for crn.
   **/
  @JsonProperty("crn")
  public String getCrn() {
    return crn;
  }

  /**
   * Setter for crn.
   **/
  public void setCrn(String crn) {
    this.crn = crn;
  }

  /**
   * Getter for creationDate.
   **/
  @JsonProperty("creationDate")
  public ZonedDateTime getCreationDate() {
    return creationDate;
  }

  /**
   * Setter for creationDate.
   **/
  public void setCreationDate(ZonedDateTime creationDate) {
    this.creationDate = creationDate;
  }

  /**
   * Getter for status.
   **/
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  /**
   * Setter for status.
   **/
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * Getter for clusterCrn.
   **/
  @JsonProperty("clusterCrn")
  public String getClusterCrn() {
    return clusterCrn;
  }

  /**
   * Setter for clusterCrn.
   **/
  public void setClusterCrn(String clusterCrn) {
    this.clusterCrn = clusterCrn;
  }

  /**
   * Getter for submitterCrn.
   **/
  @JsonProperty("submitterCrn")
  public String getSubmitterCrn() {
    return submitterCrn;
  }

  /**
   * Setter for submitterCrn.
   **/
  public void setSubmitterCrn(String submitterCrn) {
    this.submitterCrn = submitterCrn;
  }

  /**
   * Getter for jobType.
   **/
  @JsonProperty("jobType")
  public String getJobType() {
    return jobType;
  }

  /**
   * Setter for jobType.
   **/
  public void setJobType(String jobType) {
    this.jobType = jobType;
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
   * Getter for jobSubmissionGroupId.
   **/
  @JsonProperty("jobSubmissionGroupId")
  public String getJobSubmissionGroupId() {
    return jobSubmissionGroupId;
  }

  /**
   * Setter for jobSubmissionGroupId.
   **/
  public void setJobSubmissionGroupId(String jobSubmissionGroupId) {
    this.jobSubmissionGroupId = jobSubmissionGroupId;
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

  /**
   * Getter for jobSubmissionGroupIndex.
   **/
  @JsonProperty("jobSubmissionGroupIndex")
  public Integer getJobSubmissionGroupIndex() {
    return jobSubmissionGroupIndex;
  }

  /**
   * Setter for jobSubmissionGroupIndex.
   **/
  public void setJobSubmissionGroupIndex(Integer jobSubmissionGroupIndex) {
    this.jobSubmissionGroupIndex = jobSubmissionGroupIndex;
  }

  /**
   * Getter for jobSubmissionGroupSize.
   **/
  @JsonProperty("jobSubmissionGroupSize")
  public Integer getJobSubmissionGroupSize() {
    return jobSubmissionGroupSize;
  }

  /**
   * Setter for jobSubmissionGroupSize.
   **/
  public void setJobSubmissionGroupSize(Integer jobSubmissionGroupSize) {
    this.jobSubmissionGroupSize = jobSubmissionGroupSize;
  }

  /**
   * Getter for workloadAnalyticsEnabled.
   **/
  @JsonProperty("workloadAnalyticsEnabled")
  public Boolean getWorkloadAnalyticsEnabled() {
    return workloadAnalyticsEnabled;
  }

  /**
   * Setter for workloadAnalyticsEnabled.
   **/
  public void setWorkloadAnalyticsEnabled(Boolean workloadAnalyticsEnabled) {
    this.workloadAnalyticsEnabled = workloadAnalyticsEnabled;
  }

  /**
   * Getter for environmentCrn.
   **/
  @JsonProperty("environmentCrn")
  public String getEnvironmentCrn() {
    return environmentCrn;
  }

  /**
   * Setter for environmentCrn.
   **/
  public void setEnvironmentCrn(String environmentCrn) {
    this.environmentCrn = environmentCrn;
  }

  /**
   * Getter for environmentType.
   **/
  @JsonProperty("environmentType")
  public String getEnvironmentType() {
    return environmentType;
  }

  /**
   * Setter for environmentType.
   **/
  public void setEnvironmentType(String environmentType) {
    this.environmentType = environmentType;
  }

  /**
   * Getter for hiveJobDetails.
   **/
  @JsonProperty("hiveJobDetails")
  public JobHiveJobDetails getHiveJobDetails() {
    return hiveJobDetails;
  }

  /**
   * Setter for hiveJobDetails.
   **/
  public void setHiveJobDetails(JobHiveJobDetails hiveJobDetails) {
    this.hiveJobDetails = hiveJobDetails;
  }

  /**
   * Getter for sparkJobDetails.
   **/
  @JsonProperty("sparkJobDetails")
  public JobSparkJobDetails getSparkJobDetails() {
    return sparkJobDetails;
  }

  /**
   * Setter for sparkJobDetails.
   **/
  public void setSparkJobDetails(JobSparkJobDetails sparkJobDetails) {
    this.sparkJobDetails = sparkJobDetails;
  }

  /**
   * Getter for pySparkJobDetails.
   **/
  @JsonProperty("pySparkJobDetails")
  public JobPySparkJobDetails getPySparkJobDetails() {
    return pySparkJobDetails;
  }

  /**
   * Setter for pySparkJobDetails.
   **/
  public void setPySparkJobDetails(JobPySparkJobDetails pySparkJobDetails) {
    this.pySparkJobDetails = pySparkJobDetails;
  }

  /**
   * Getter for mr2JobDetails.
   **/
  @JsonProperty("mr2JobDetails")
  public JobMr2JobDetails getMr2JobDetails() {
    return mr2JobDetails;
  }

  /**
   * Setter for mr2JobDetails.
   **/
  public void setMr2JobDetails(JobMr2JobDetails mr2JobDetails) {
    this.mr2JobDetails = mr2JobDetails;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Job job = (Job) o;
    if (!Objects.equals(this.jobId, job.jobId)) {
      return false;
    }
    if (!Objects.equals(this.jobName, job.jobName)) {
      return false;
    }
    if (!Objects.equals(this.crn, job.crn)) {
      return false;
    }
    if (!Objects.equals(this.creationDate, job.creationDate)) {
      return false;
    }
    if (!Objects.equals(this.status, job.status)) {
      return false;
    }
    if (!Objects.equals(this.clusterCrn, job.clusterCrn)) {
      return false;
    }
    if (!Objects.equals(this.submitterCrn, job.submitterCrn)) {
      return false;
    }
    if (!Objects.equals(this.jobType, job.jobType)) {
      return false;
    }
    if (!Objects.equals(this.failureAction, job.failureAction)) {
      return false;
    }
    if (!Objects.equals(this.jobSubmissionGroupId, job.jobSubmissionGroupId)) {
      return false;
    }
    if (!Objects.equals(this.jobSubmissionGroupName, job.jobSubmissionGroupName)) {
      return false;
    }
    if (!Objects.equals(this.jobSubmissionGroupIndex, job.jobSubmissionGroupIndex)) {
      return false;
    }
    if (!Objects.equals(this.jobSubmissionGroupSize, job.jobSubmissionGroupSize)) {
      return false;
    }
    if (!Objects.equals(this.workloadAnalyticsEnabled, job.workloadAnalyticsEnabled)) {
      return false;
    }
    if (!Objects.equals(this.environmentCrn, job.environmentCrn)) {
      return false;
    }
    if (!Objects.equals(this.environmentType, job.environmentType)) {
      return false;
    }
    if (!Objects.equals(this.hiveJobDetails, job.hiveJobDetails)) {
      return false;
    }
    if (!Objects.equals(this.sparkJobDetails, job.sparkJobDetails)) {
      return false;
    }
    if (!Objects.equals(this.pySparkJobDetails, job.pySparkJobDetails)) {
      return false;
    }
    if (!Objects.equals(this.mr2JobDetails, job.mr2JobDetails)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobId, jobName, crn, creationDate, status, clusterCrn, submitterCrn, jobType, failureAction, jobSubmissionGroupId, jobSubmissionGroupName, jobSubmissionGroupIndex, jobSubmissionGroupSize, workloadAnalyticsEnabled, environmentCrn, environmentType, hiveJobDetails, sparkJobDetails, pySparkJobDetails, mr2JobDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Job {\n");
    sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
    sb.append("    jobName: ").append(toIndentedString(jobName)).append("\n");
    sb.append("    crn: ").append(toIndentedString(crn)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    clusterCrn: ").append(toIndentedString(clusterCrn)).append("\n");
    sb.append("    submitterCrn: ").append(toIndentedString(submitterCrn)).append("\n");
    sb.append("    jobType: ").append(toIndentedString(jobType)).append("\n");
    sb.append("    failureAction: ").append(toIndentedString(failureAction)).append("\n");
    sb.append("    jobSubmissionGroupId: ").append(toIndentedString(jobSubmissionGroupId)).append("\n");
    sb.append("    jobSubmissionGroupName: ").append(toIndentedString(jobSubmissionGroupName)).append("\n");
    sb.append("    jobSubmissionGroupIndex: ").append(toIndentedString(jobSubmissionGroupIndex)).append("\n");
    sb.append("    jobSubmissionGroupSize: ").append(toIndentedString(jobSubmissionGroupSize)).append("\n");
    sb.append("    workloadAnalyticsEnabled: ").append(toIndentedString(workloadAnalyticsEnabled)).append("\n");
    sb.append("    environmentCrn: ").append(toIndentedString(environmentCrn)).append("\n");
    sb.append("    environmentType: ").append(toIndentedString(environmentType)).append("\n");
    sb.append("    hiveJobDetails: ").append(toIndentedString(hiveJobDetails)).append("\n");
    sb.append("    sparkJobDetails: ").append(toIndentedString(sparkJobDetails)).append("\n");
    sb.append("    pySparkJobDetails: ").append(toIndentedString(pySparkJobDetails)).append("\n");
    sb.append("    mr2JobDetails: ").append(toIndentedString(mr2JobDetails)).append("\n");
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

