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

package com.cloudera.altus.dataeng.api;

import javax.ws.rs.core.GenericType;
import com.cloudera.altus.AltusClientException;
import com.cloudera.altus.authentication.credentials.AltusCredentials;
import com.cloudera.altus.client.AltusClient;
import com.cloudera.altus.client.AltusClientConfiguration;
import com.cloudera.altus.dataeng.model.CreateAWSClusterRequest;
import com.cloudera.altus.dataeng.model.CreateAWSClusterResponse;
import com.cloudera.altus.dataeng.model.DeleteClusterRequest;
import com.cloudera.altus.dataeng.model.DeleteClusterResponse;
import com.cloudera.altus.dataeng.model.DescribeClusterRequest;
import com.cloudera.altus.dataeng.model.DescribeClusterResponse;
import com.cloudera.altus.dataeng.model.DescribeJobRequest;
import com.cloudera.altus.dataeng.model.DescribeJobResponse;
import com.cloudera.altus.dataeng.model.Error;
import com.cloudera.altus.dataeng.model.ListClustersRequest;
import com.cloudera.altus.dataeng.model.ListClustersResponse;
import com.cloudera.altus.dataeng.model.ListJobsRequest;
import com.cloudera.altus.dataeng.model.ListJobsResponse;
import com.cloudera.altus.dataeng.model.SubmitJobsRequest;
import com.cloudera.altus.dataeng.model.SubmitJobsResponse;
import com.cloudera.altus.dataeng.model.TerminateJobRequest;
import com.cloudera.altus.dataeng.model.TerminateJobResponse;

@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-02-21T23:00:25.094-08:00")
public class DataengClient extends AltusClient {

  public static final String SERVICE_NAME = "dataeng";

  public DataengClient(
      AltusCredentials credentials,
      String endPoint,
      AltusClientConfiguration clientConfiguration) {
    super(credentials, endPoint, clientConfiguration);
  }

  /**
   * Creates a new AWS cluster.
   * @param input
   * @return CreateAWSClusterResponse
   */
  public CreateAWSClusterResponse createAWSCluster(CreateAWSClusterRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling createAWSCluster");
     }
    return this.invokeAPI("/dataeng/createAWSCluster", input, new GenericType<CreateAWSClusterResponse>(){});
  }

  /**
   * Deletes a cluster.
   * @param input
   * @return DeleteClusterResponse
   */
  public DeleteClusterResponse deleteCluster(DeleteClusterRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling deleteCluster");
     }
    return this.invokeAPI("/dataeng/deleteCluster", input, new GenericType<DeleteClusterResponse>(){});
  }

  /**
   * Describe a cluster.
   * @param input
   * @return DescribeClusterResponse
   */
  public DescribeClusterResponse describeCluster(DescribeClusterRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling describeCluster");
     }
    return this.invokeAPI("/dataeng/describeCluster", input, new GenericType<DescribeClusterResponse>(){});
  }

  /**
   * Describe a job.
   * @param input
   * @return DescribeJobResponse
   */
  public DescribeJobResponse describeJob(DescribeJobRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling describeJob");
     }
    return this.invokeAPI("/dataeng/describeJob", input, new GenericType<DescribeJobResponse>(){});
  }

  /**
   * Lists clusters.
   * @param input
   * @return ListClustersResponse
   */
  public ListClustersResponse listClusters(ListClustersRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling listClusters");
     }
    return this.invokeAPI("/dataeng/listClusters", input, new GenericType<ListClustersResponse>(){});
  }

  /**
   * Lists jobs.
   * @param input
   * @return ListJobsResponse
   */
  public ListJobsResponse listJobs(ListJobsRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling listJobs");
     }
    return this.invokeAPI("/dataeng/listJobs", input, new GenericType<ListJobsResponse>(){});
  }

  /**
   * Submit new jobs.
   * @param input
   * @return SubmitJobsResponse
   */
  public SubmitJobsResponse submitJobs(SubmitJobsRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling submitJobs");
     }
    return this.invokeAPI("/dataeng/submitJobs", input, new GenericType<SubmitJobsResponse>(){});
  }

  /**
   * Terminate a job.
   * @param input
   * @return TerminateJobResponse
   */
  public TerminateJobResponse terminateJob(TerminateJobRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling terminateJob");
     }
    return this.invokeAPI("/dataeng/terminateJob", input, new GenericType<TerminateJobResponse>(){});
  }
}
