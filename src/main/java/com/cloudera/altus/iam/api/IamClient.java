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

package com.cloudera.altus.iam.api;

import javax.ws.rs.core.GenericType;
import com.cloudera.altus.AltusClientException;
import com.cloudera.altus.authentication.credentials.AltusCredentials;
import com.cloudera.altus.client.AltusClient;
import com.cloudera.altus.client.AltusClientConfiguration;
import com.cloudera.altus.iam.model.AssignMachineUserResourceRoleRequest;
import com.cloudera.altus.iam.model.AssignMachineUserResourceRoleResponse;
import com.cloudera.altus.iam.model.AssignMachineUserRoleRequest;
import com.cloudera.altus.iam.model.AssignMachineUserRoleResponse;
import com.cloudera.altus.iam.model.AssignUserResourceRoleRequest;
import com.cloudera.altus.iam.model.AssignUserResourceRoleResponse;
import com.cloudera.altus.iam.model.AssignUserRoleRequest;
import com.cloudera.altus.iam.model.AssignUserRoleResponse;
import com.cloudera.altus.iam.model.CreateMachineUserAccessKeyRequest;
import com.cloudera.altus.iam.model.CreateMachineUserAccessKeyResponse;
import com.cloudera.altus.iam.model.CreateMachineUserRequest;
import com.cloudera.altus.iam.model.CreateMachineUserResponse;
import com.cloudera.altus.iam.model.CreateUserAccessKeyRequest;
import com.cloudera.altus.iam.model.CreateUserAccessKeyResponse;
import com.cloudera.altus.iam.model.DeleteAccessKeyRequest;
import com.cloudera.altus.iam.model.DeleteAccessKeyResponse;
import com.cloudera.altus.iam.model.DeleteMachineUserRequest;
import com.cloudera.altus.iam.model.DeleteMachineUserResponse;
import com.cloudera.altus.iam.model.Error;
import com.cloudera.altus.iam.model.GetAccessKeyRequest;
import com.cloudera.altus.iam.model.GetAccessKeyResponse;
import com.cloudera.altus.iam.model.GetUserRequest;
import com.cloudera.altus.iam.model.GetUserResponse;
import com.cloudera.altus.iam.model.ListAccessKeysRequest;
import com.cloudera.altus.iam.model.ListAccessKeysResponse;
import com.cloudera.altus.iam.model.ListMachineUserAssignedResourceRolesRequest;
import com.cloudera.altus.iam.model.ListMachineUserAssignedResourceRolesResponse;
import com.cloudera.altus.iam.model.ListMachineUserAssignedRolesRequest;
import com.cloudera.altus.iam.model.ListMachineUserAssignedRolesResponse;
import com.cloudera.altus.iam.model.ListMachineUsersRequest;
import com.cloudera.altus.iam.model.ListMachineUsersResponse;
import com.cloudera.altus.iam.model.ListResourceAssigneesRequest;
import com.cloudera.altus.iam.model.ListResourceAssigneesResponse;
import com.cloudera.altus.iam.model.ListResourceRolesRequest;
import com.cloudera.altus.iam.model.ListResourceRolesResponse;
import com.cloudera.altus.iam.model.ListRolesRequest;
import com.cloudera.altus.iam.model.ListRolesResponse;
import com.cloudera.altus.iam.model.ListUserAssignedResourceRolesRequest;
import com.cloudera.altus.iam.model.ListUserAssignedResourceRolesResponse;
import com.cloudera.altus.iam.model.ListUserAssignedRolesRequest;
import com.cloudera.altus.iam.model.ListUserAssignedRolesResponse;
import com.cloudera.altus.iam.model.ListUsersRequest;
import com.cloudera.altus.iam.model.ListUsersResponse;
import com.cloudera.altus.iam.model.UnassignMachineUserResourceRoleRequest;
import com.cloudera.altus.iam.model.UnassignMachineUserResourceRoleResponse;
import com.cloudera.altus.iam.model.UnassignMachineUserRoleRequest;
import com.cloudera.altus.iam.model.UnassignMachineUserRoleResponse;
import com.cloudera.altus.iam.model.UnassignUserResourceRoleRequest;
import com.cloudera.altus.iam.model.UnassignUserResourceRoleResponse;
import com.cloudera.altus.iam.model.UnassignUserRoleRequest;
import com.cloudera.altus.iam.model.UnassignUserRoleResponse;
import com.cloudera.altus.iam.model.UpdateAccessKeyRequest;
import com.cloudera.altus.iam.model.UpdateAccessKeyResponse;

@javax.annotation.Generated(value = "com.cloudera.altus.client.codegen.AltusSDKJavaCodegen", date = "2018-05-15T16:32:04.425-07:00")
public class IamClient extends AltusClient {

  public static final String SERVICE_NAME = "iam";

  public IamClient(
      AltusCredentials credentials,
      String endPoint,
      AltusClientConfiguration clientConfiguration) {
    super(credentials, endPoint, clientConfiguration);
  }

  /**
   * Assign a resource role to a machine user.
   * @param input
   * @return AssignMachineUserResourceRoleResponse
   */
  public AssignMachineUserResourceRoleResponse assignMachineUserResourceRole(AssignMachineUserResourceRoleRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling assignMachineUserResourceRole");
     }
    return this.invokeAPI("/iam/assignMachineUserResourceRole", input, new GenericType<AssignMachineUserResourceRoleResponse>(){});
  }

  /**
   * Assign a role to a machine user.
   * @param input
   * @return AssignMachineUserRoleResponse
   */
  public AssignMachineUserRoleResponse assignMachineUserRole(AssignMachineUserRoleRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling assignMachineUserRole");
     }
    return this.invokeAPI("/iam/assignMachineUserRole", input, new GenericType<AssignMachineUserRoleResponse>(){});
  }

  /**
   * Assign a resource role to a user.
   * @param input
   * @return AssignUserResourceRoleResponse
   */
  public AssignUserResourceRoleResponse assignUserResourceRole(AssignUserResourceRoleRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling assignUserResourceRole");
     }
    return this.invokeAPI("/iam/assignUserResourceRole", input, new GenericType<AssignUserResourceRoleResponse>(){});
  }

  /**
   * Assign a role to a user.
   * @param input
   * @return AssignUserRoleResponse
   */
  public AssignUserRoleResponse assignUserRole(AssignUserRoleRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling assignUserRole");
     }
    return this.invokeAPI("/iam/assignUserRole", input, new GenericType<AssignUserRoleResponse>(){});
  }

  /**
   * Create a machine user.
   * @param input
   * @return CreateMachineUserResponse
   */
  public CreateMachineUserResponse createMachineUser(CreateMachineUserRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling createMachineUser");
     }
    return this.invokeAPI("/iam/createMachineUser", input, new GenericType<CreateMachineUserResponse>(){});
  }

  /**
   * Creates a new access key for a machine user.
   * @param input
   * @return CreateMachineUserAccessKeyResponse
   */
  public CreateMachineUserAccessKeyResponse createMachineUserAccessKey(CreateMachineUserAccessKeyRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling createMachineUserAccessKey");
     }
    return this.invokeAPI("/iam/createMachineUserAccessKey", input, new GenericType<CreateMachineUserAccessKeyResponse>(){});
  }

  /**
   * Creates a new access key for a user.
   * @param input
   * @return CreateUserAccessKeyResponse
   */
  public CreateUserAccessKeyResponse createUserAccessKey(CreateUserAccessKeyRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling createUserAccessKey");
     }
    return this.invokeAPI("/iam/createUserAccessKey", input, new GenericType<CreateUserAccessKeyResponse>(){});
  }

  /**
   * Deletes an access key.
   * @param input
   * @return DeleteAccessKeyResponse
   */
  public DeleteAccessKeyResponse deleteAccessKey(DeleteAccessKeyRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling deleteAccessKey");
     }
    return this.invokeAPI("/iam/deleteAccessKey", input, new GenericType<DeleteAccessKeyResponse>(){});
  }

  /**
   * Delete a machine user.
   * @param input
   * @return DeleteMachineUserResponse
   */
  public DeleteMachineUserResponse deleteMachineUser(DeleteMachineUserRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling deleteMachineUser");
     }
    return this.invokeAPI("/iam/deleteMachineUser", input, new GenericType<DeleteMachineUserResponse>(){});
  }

  /**
   * Gets information on an access key.
   * @param input
   * @return GetAccessKeyResponse
   */
  public GetAccessKeyResponse getAccessKey(GetAccessKeyRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling getAccessKey");
     }
    return this.invokeAPI("/iam/getAccessKey", input, new GenericType<GetAccessKeyResponse>(){});
  }

  /**
   * Gets information on a user.
   * @param input
   * @return GetUserResponse
   */
  public GetUserResponse getUser(GetUserRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling getUser");
     }
    return this.invokeAPI("/iam/getUser", input, new GenericType<GetUserResponse>(){});
  }

  /**
   * Lists access keys.
   * @param input
   * @return ListAccessKeysResponse
   */
  public ListAccessKeysResponse listAccessKeys(ListAccessKeysRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling listAccessKeys");
     }
    return this.invokeAPI("/iam/listAccessKeys", input, new GenericType<ListAccessKeysResponse>(){});
  }

  /**
   * Lists a machine user&#39;s assigned resource roles.
   * @param input
   * @return ListMachineUserAssignedResourceRolesResponse
   */
  public ListMachineUserAssignedResourceRolesResponse listMachineUserAssignedResourceRoles(ListMachineUserAssignedResourceRolesRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling listMachineUserAssignedResourceRoles");
     }
    return this.invokeAPI("/iam/listMachineUserAssignedResourceRoles", input, new GenericType<ListMachineUserAssignedResourceRolesResponse>(){});
  }

  /**
   * Lists the machine user&#39;s assigned roles.
   * @param input
   * @return ListMachineUserAssignedRolesResponse
   */
  public ListMachineUserAssignedRolesResponse listMachineUserAssignedRoles(ListMachineUserAssignedRolesRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling listMachineUserAssignedRoles");
     }
    return this.invokeAPI("/iam/listMachineUserAssignedRoles", input, new GenericType<ListMachineUserAssignedRolesResponse>(){});
  }

  /**
   * Lists machine users.
   * @param input
   * @return ListMachineUsersResponse
   */
  public ListMachineUsersResponse listMachineUsers(ListMachineUsersRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling listMachineUsers");
     }
    return this.invokeAPI("/iam/listMachineUsers", input, new GenericType<ListMachineUsersResponse>(){});
  }

  /**
   * List the resource assignees and their respective resource roles for the resource.
   * @param input
   * @return ListResourceAssigneesResponse
   */
  public ListResourceAssigneesResponse listResourceAssignees(ListResourceAssigneesRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling listResourceAssignees");
     }
    return this.invokeAPI("/iam/listResourceAssignees", input, new GenericType<ListResourceAssigneesResponse>(){});
  }

  /**
   * Lists all the available resource roles.
   * @param input
   * @return ListResourceRolesResponse
   */
  public ListResourceRolesResponse listResourceRoles(ListResourceRolesRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling listResourceRoles");
     }
    return this.invokeAPI("/iam/listResourceRoles", input, new GenericType<ListResourceRolesResponse>(){});
  }

  /**
   * Lists all the available roles.
   * @param input
   * @return ListRolesResponse
   */
  public ListRolesResponse listRoles(ListRolesRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling listRoles");
     }
    return this.invokeAPI("/iam/listRoles", input, new GenericType<ListRolesResponse>(){});
  }

  /**
   * Lists a user&#39;s assigned resource roles.
   * @param input
   * @return ListUserAssignedResourceRolesResponse
   */
  public ListUserAssignedResourceRolesResponse listUserAssignedResourceRoles(ListUserAssignedResourceRolesRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling listUserAssignedResourceRoles");
     }
    return this.invokeAPI("/iam/listUserAssignedResourceRoles", input, new GenericType<ListUserAssignedResourceRolesResponse>(){});
  }

  /**
   * Lists the user&#39;s assigned roles.
   * @param input
   * @return ListUserAssignedRolesResponse
   */
  public ListUserAssignedRolesResponse listUserAssignedRoles(ListUserAssignedRolesRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling listUserAssignedRoles");
     }
    return this.invokeAPI("/iam/listUserAssignedRoles", input, new GenericType<ListUserAssignedRolesResponse>(){});
  }

  /**
   * Lists users.
   * @param input
   * @return ListUsersResponse
   */
  public ListUsersResponse listUsers(ListUsersRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling listUsers");
     }
    return this.invokeAPI("/iam/listUsers", input, new GenericType<ListUsersResponse>(){});
  }

  /**
   * Unassign a resource role from a machine user.
   * @param input
   * @return UnassignMachineUserResourceRoleResponse
   */
  public UnassignMachineUserResourceRoleResponse unassignMachineUserResourceRole(UnassignMachineUserResourceRoleRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling unassignMachineUserResourceRole");
     }
    return this.invokeAPI("/iam/unassignMachineUserResourceRole", input, new GenericType<UnassignMachineUserResourceRoleResponse>(){});
  }

  /**
   * Unassign a role from a machine user.
   * @param input
   * @return UnassignMachineUserRoleResponse
   */
  public UnassignMachineUserRoleResponse unassignMachineUserRole(UnassignMachineUserRoleRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling unassignMachineUserRole");
     }
    return this.invokeAPI("/iam/unassignMachineUserRole", input, new GenericType<UnassignMachineUserRoleResponse>(){});
  }

  /**
   * Unassign a resource role from a user.
   * @param input
   * @return UnassignUserResourceRoleResponse
   */
  public UnassignUserResourceRoleResponse unassignUserResourceRole(UnassignUserResourceRoleRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling unassignUserResourceRole");
     }
    return this.invokeAPI("/iam/unassignUserResourceRole", input, new GenericType<UnassignUserResourceRoleResponse>(){});
  }

  /**
   * Unassign a role from a user.
   * @param input
   * @return UnassignUserRoleResponse
   */
  public UnassignUserRoleResponse unassignUserRole(UnassignUserRoleRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling unassignUserRole");
     }
    return this.invokeAPI("/iam/unassignUserRole", input, new GenericType<UnassignUserRoleResponse>(){});
  }

  /**
   * Updates an access key.
   * @param input
   * @return UpdateAccessKeyResponse
   */
  public UpdateAccessKeyResponse updateAccessKey(UpdateAccessKeyRequest input) {
     if (input == null) {
        throw new AltusClientException("Missing the required parameter 'input' when calling updateAccessKey");
     }
    return this.invokeAPI("/iam/updateAccessKey", input, new GenericType<UpdateAccessKeyResponse>(){});
  }
}
