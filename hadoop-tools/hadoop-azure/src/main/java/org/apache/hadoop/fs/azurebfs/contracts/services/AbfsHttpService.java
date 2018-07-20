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

package org.apache.hadoop.fs.azurebfs.contracts.services;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.List;

import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.classification.InterfaceStability;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.azurebfs.AzureBlobFileSystem;
import org.apache.hadoop.fs.azurebfs.contracts.exceptions.AzureBlobFileSystemException;
import org.apache.hadoop.fs.permission.AclEntry;
import org.apache.hadoop.fs.permission.AclStatus;
import org.apache.hadoop.fs.permission.FsPermission;

/**
 * File System http service to provide network calls for file system operations.
 */
@InterfaceAudience.Public
@InterfaceStability.Evolving
public interface AbfsHttpService extends InjectableService {
  /**
   * Gets filesystem properties on the Azure service.
   * @param azureBlobFileSystem filesystem to get the properties.
   * @return Hashtable<String, String> hash table containing all the filesystem properties.
   */
  Hashtable<String, String> getFilesystemProperties(AzureBlobFileSystem azureBlobFileSystem) throws AzureBlobFileSystemException;


  /**
   * Sets filesystem properties on the Azure service.
   * @param azureBlobFileSystem filesystem to get the properties.
   * @param properties file system properties to set.
   */
  void setFilesystemProperties(AzureBlobFileSystem azureBlobFileSystem, Hashtable<String, String> properties) throws
      AzureBlobFileSystemException;

  /**
   * Gets path properties on the Azure service.
   * @param azureBlobFileSystem filesystem to get the properties of the path.
   * @param path path to get properties.
   * @return Hashtable<String, String> hash table containing all the path properties.
   */
  Hashtable<String, String> getPathProperties(AzureBlobFileSystem azureBlobFileSystem, Path path) throws AzureBlobFileSystemException;

  /**
   * Sets path properties on the Azure service.
   * @param azureBlobFileSystem filesystem to get the properties of the path.
   * @param path path to set properties.
   * @param properties hash table containing all the path properties.
   */
  void setPathProperties(AzureBlobFileSystem azureBlobFileSystem, Path path, Hashtable<String, String> properties) throws
      AzureBlobFileSystemException;

  /**
   * Creates filesystem on the Azure service.
   * @param azureBlobFileSystem filesystem to be created.
   */
  void createFilesystem(AzureBlobFileSystem azureBlobFileSystem) throws AzureBlobFileSystemException;

  /**
   * Deletes filesystem on the Azure service.
   * @param azureBlobFileSystem filesystem to be deleted.
   */
  void deleteFilesystem(AzureBlobFileSystem azureBlobFileSystem) throws AzureBlobFileSystemException;

  /**
   * Creates a file on the Azure service.
   * @param azureBlobFileSystem filesystem to create file or directory.
   * @param path path of the file to be created.
   * @param overwrite should overwrite.
   * @param permission permission of the file created
   * @return OutputStream stream to the file.
   */
  OutputStream createFile(AzureBlobFileSystem azureBlobFileSystem, Path path, boolean overwrite, FsPermission permission) throws AzureBlobFileSystemException;

  /**
   * Creates a directory on the Azure service.
   * @param azureBlobFileSystem filesystem to create file or directory.
   * @param path path of the directory to be created.
   * @param permission permission of the directory created
   * @return OutputStream stream to the file.
   */
  Void createDirectory(AzureBlobFileSystem azureBlobFileSystem, Path path, FsPermission permission) throws AzureBlobFileSystemException;

  /**
   * Opens a file to read and returns the stream.
   * @param azureBlobFileSystem filesystem to read a file from.
   * @param path file path to read.
   * @return InputStream a stream to the file to read.
   */
  InputStream openFileForRead(AzureBlobFileSystem azureBlobFileSystem, Path path, FileSystem.Statistics statistics) throws AzureBlobFileSystemException;

  /**
   * Opens a file to write and returns the stream.
   * @param azureBlobFileSystem filesystem to write a file to.
   * @param path file path to write.
   * @param overwrite should overwrite.
   * @return OutputStream a stream to the file to write.
   */
  OutputStream openFileForWrite(AzureBlobFileSystem azureBlobFileSystem, Path path, boolean overwrite) throws AzureBlobFileSystemException;

  /**
   * Renames a file or directory from source to destination.
   * @param azureBlobFileSystem filesystem to rename a path.
   * @param source source path.
   * @param destination destination path.
   */
  void rename(AzureBlobFileSystem azureBlobFileSystem, Path source, Path destination) throws AzureBlobFileSystemException;

  /**
   * Deletes a file or directory.
   * @param azureBlobFileSystem filesystem to delete the path.
   * @param path file path to be deleted.
   * @param recursive true if path is a directory and recursive deletion is desired.
   */
  void delete(AzureBlobFileSystem azureBlobFileSystem, Path path, boolean recursive) throws AzureBlobFileSystemException;

  /**
   * Gets path's status under the provided path on the Azure service.
   * @param azureBlobFileSystem filesystem to perform the get file status operation.
   * @param path path delimiter.
   * @return FileStatus FileStatus of the path in the file system.
   */
  FileStatus getFileStatus(AzureBlobFileSystem azureBlobFileSystem, Path path) throws AzureBlobFileSystemException;

  /**
   * Lists all the paths under the provided path on the Azure service.
   * @param azureBlobFileSystem filesystem to perform the list operation.
   * @param path path delimiter.
   * @return FileStatus[] list of all paths in the file system.
   */
  FileStatus[] listStatus(AzureBlobFileSystem azureBlobFileSystem, Path path) throws AzureBlobFileSystemException;

 /**
 * Set owner of a path (i.e. a file or a directory).
 * The parameters owner and group cannot both be null.
 * @param azureBlobFileSystem filesystem to perform the setOwner operation.
 * @param path path delimiter.
 * @param owner owner of the path.
 * @param group group of the path.
 */
  void setOwner(AzureBlobFileSystem azureBlobFileSystem, Path path, String owner, String group) throws AzureBlobFileSystemException;

  /**
   * Set permission of a path.
   * @param azureBlobFileSystem filesystem to perform the setPermission operation.
   * @param path       The path
   * @param permission Access permission
   */
  void setPermission(AzureBlobFileSystem azureBlobFileSystem, Path path, FsPermission permission) throws AzureBlobFileSystemException;

  /**
   * Modifies ACL entries of files and directories.  This method can add new ACL
   * entries or modify the permissions on existing ACL entries.  All existing
   * ACL entries that are not specified in this call are retained without
   * changes.  (Modifications are merged into the current ACL.)
   * @param azureBlobFileSystem filesystem to perform the modifyAclEntries operation.
   * @param path    Path to modify
   * @param aclSpec List of AbfsAclEntry describing modifications
   */
  void modifyAclEntries(AzureBlobFileSystem azureBlobFileSystem, Path path, List<AclEntry> aclSpec) throws AzureBlobFileSystemException;

  /**
   * Removes ACL entries from files and directories.  Other ACL entries are
   * retained.
   * @param azureBlobFileSystem filesystem to perform the removeAclEntries operation.
   * @param path    Path to modify
   * @param aclSpec List of AclEntry describing entries to remove
   */
  void removeAclEntries(AzureBlobFileSystem azureBlobFileSystem, Path path, List<AclEntry> aclSpec) throws AzureBlobFileSystemException;

  /**
   * Removes all default ACL entries from files and directories.
   * @param azureBlobFileSystem filesystem to perform the getAclStatus operation.
   * @param path Path to modify
   */
  void removeDefaultAcl(AzureBlobFileSystem azureBlobFileSystem, Path path) throws AzureBlobFileSystemException;

  /**
   * Removes all but the base ACL entries of files and directories.  The entries
   * for user, group, and others are retained for compatibility with permission
   * bits.
   * @param azureBlobFileSystem filesystem to perform the getAclStatus operation.
   * @param path Path to modify
   */
  void removeAcl(AzureBlobFileSystem azureBlobFileSystem, Path path) throws AzureBlobFileSystemException;

  /**
   * Fully replaces ACL of files and directories, discarding all existing
   * entries.
   * @param azureBlobFileSystem filesystem to perform the getAclStatus operation.
   * @param path    Path to modify
   * @param aclSpec List of AclEntry describing modifications, must include
   *                entries for user, group, and others for compatibility with
   *                permission bits.
   */
  void setAcl(AzureBlobFileSystem azureBlobFileSystem, Path path, List<AclEntry> aclSpec) throws AzureBlobFileSystemException;

  /**
   * Gets the ACL of a file or directory.
   * @param azureBlobFileSystem filesystem to perform the getAclStatus operation.
   * @param path Path to get
   * @return AbfsAclStatus describing the ACL of the file or directory
   */
  AclStatus getAclStatus(AzureBlobFileSystem azureBlobFileSystem, Path path) throws AzureBlobFileSystemException;
}