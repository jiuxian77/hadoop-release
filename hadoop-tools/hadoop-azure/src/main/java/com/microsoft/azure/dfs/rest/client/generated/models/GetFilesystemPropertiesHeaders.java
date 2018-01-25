/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Code generated by Microsoft (R) AutoRest Code Generator 1.2.2.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.dfs.rest.client.generated.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.hadoop.classification.InterfaceStability;

/**
 * Defines headers for GetFilesystemProperties operation.
 */
@InterfaceStability.Evolving
public class GetFilesystemPropertiesHeaders {
  /**
   * An HTTP entity tag associated with the filesystem.  Changes to
   * filesystem properties affect the entity tag, but operations on files and
   * directories do not.
   */
  @JsonProperty(value = "ETag")
  private String eTag;

  /**
   * The data and time the filesystem was last modified.  Changes to
   * filesystem properties update the last modified time, but operations on
   * files and directories do not.
   */
  @JsonProperty(value = "Last-Modified")
  private String lastModified;

  /**
   * A server-generated UUID recorded in the analytics logs for
   * troubleshooting and correlation.
   */
  @JsonProperty(value = "x-ms-request-id")
  private String xMsRequestId;

  /**
   * The version of the REST protocol used to process the request.
   */
  @JsonProperty(value = "x-ms-version")
  private String xMsVersion;

  /**
   * A comma-separated list of properties n1=v1,n2=v2,... associated with the
   * resource.
   */
  @JsonProperty(value = "x-ms-properties")
  private String xMsProperties;

  /**
   * The size of the resource in bytes.
   */
  @JsonProperty(value = "Content-Length")
  private String contentLength;

  /**
   * The x-ms-origination-id of the request that created the resource. When a
   * request fails on the client-side due to a timeout or network error, it
   * may have succeeded on the server-side. When retrying the request, if a
   * response is received with a 409 status and a FilesystemAlreadyExists
   * service error code, the client may compare the x-ms-origination-id
   * response header with the x-ms-origination-id of a previous failed
   * request to determine if the previous request succeeded on the
   * server-side.  This header will not be included in the response if the
   * originating request did not include the optional x-ms-origination-id
   * header.
   */
  @JsonProperty(value = "x-ms-origination-id")
  private String xMsOriginationId;

  /**
   * Get the eTag value.
   *
   * @return the eTag value
   */
  public String eTag() {
    return this.eTag;
  }

  /**
   * Set the eTag value.
   *
   * @param eTag the eTag value to set
   * @return the GetFilesystemPropertiesHeaders object itself.
   */
  public GetFilesystemPropertiesHeaders withETag(String eTag) {
    this.eTag = eTag;
    return this;
  }

  /**
   * Get the lastModified value.
   *
   * @return the lastModified value
   */
  public String lastModified() {
    return this.lastModified;
  }

  /**
   * Set the lastModified value.
   *
   * @param lastModified the lastModified value to set
   * @return the GetFilesystemPropertiesHeaders object itself.
   */
  public GetFilesystemPropertiesHeaders withLastModified(String lastModified) {
    this.lastModified = lastModified;
    return this;
  }

  /**
   * Get the xMsRequestId value.
   *
   * @return the xMsRequestId value
   */
  public String xMsRequestId() {
    return this.xMsRequestId;
  }

  /**
   * Get the contentLength value.
   *
   * @return the contentLength value
   */
  public String contentLength() {
    return this.contentLength;
  }

  /**
   * Set the xMsRequestId value.
   *
   * @param xMsRequestId the xMsRequestId value to set
   * @return the GetFilesystemPropertiesHeaders object itself.
   */
  public GetFilesystemPropertiesHeaders withXMsRequestId(String xMsRequestId) {
    this.xMsRequestId = xMsRequestId;
    return this;
  }

  /**
   * Get the xMsVersion value.
   *
   * @return the xMsVersion value
   */
  public String xMsVersion() {
    return this.xMsVersion;
  }

  /**
   * Set the xMsVersion value.
   *
   * @param xMsVersion the xMsVersion value to set
   * @return the GetFilesystemPropertiesHeaders object itself.
   */
  public GetFilesystemPropertiesHeaders withXMsVersion(String xMsVersion) {
    this.xMsVersion = xMsVersion;
    return this;
  }

  /**
   * Get the xMsProperties value.
   *
   * @return the xMsProperties value
   */
  public String xMsProperties() {
    return this.xMsProperties;
  }

  /**
   * Set the xMsProperties value.
   *
   * @param xMsProperties the xMsProperties value to set
   * @return the GetFilesystemPropertiesHeaders object itself.
   */
  public GetFilesystemPropertiesHeaders withXMsProperties(String xMsProperties) {
    this.xMsProperties = xMsProperties;
    return this;
  }

  /**
   * Get the xMsOriginationId value.
   *
   * @return the xMsOriginationId value
   */
  public String xMsOriginationId() {
    return this.xMsOriginationId;
  }

  /**
   * Set the xMsOriginationId value.
   *
   * @param xMsOriginationId the xMsOriginationId value to set
   * @return the GetFilesystemPropertiesHeaders object itself.
   */
  public GetFilesystemPropertiesHeaders withXMsOriginationId(String xMsOriginationId) {
    this.xMsOriginationId = xMsOriginationId;
    return this;
  }

}
