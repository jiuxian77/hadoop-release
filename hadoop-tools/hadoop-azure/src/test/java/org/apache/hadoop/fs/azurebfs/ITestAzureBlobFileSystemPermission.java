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

package org.apache.hadoop.fs.azurebfs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsAction;
import org.apache.hadoop.fs.permission.FsPermission;
import org.apache.hadoop.fs.azurebfs.utils.Parallelized;

@RunWith(Parallelized.class)
public class ITestAzureBlobFileSystemPermission extends DependencyInjectedTest{


  private static Path testRoot = new Path("/test");
  private static final String DEFAULT_UMASK_VALUE = "027";
  private static final FsPermission DEFAULT_UMASK_PERMISSION = new FsPermission(DEFAULT_UMASK_VALUE);
  private FsPermission permission;

  private Path path;

  public ITestAzureBlobFileSystemPermission(FsPermission testPermission) throws Exception {
    super();
    permission = testPermission;

    Assume.assumeTrue(this.isNamespaceEnabled());
  }

  @Parameterized.Parameters(name = "{0}")
  public static Collection AbfsCreateNonRecursiveTestData()
      throws Exception {
    /*
      Test Data
      File/Folder name, User permission, Group permission, Other Permission,
      Parent already exist
      shouldCreateSucceed, expectedExceptionIfFileCreateFails
    */
    final Collection<Object[]> datas = new ArrayList<>();
    for (FsAction g : FsAction.values()) {
      for (FsAction o : FsAction.values()) {
        datas.add(new Object[] {new FsPermission(FsAction.ALL, g, o)});
      }
    }
    return datas;
  }

  @Test
  public void testFilePermission() throws Exception {
    final AzureBlobFileSystem fs = this.getFileSystem();
    path = new Path(testRoot, UUID.randomUUID().toString());

    fs.mkdirs(path.getParent(),
        new FsPermission(FsAction.ALL, FsAction.NONE, FsAction.NONE));
    fs.removeDefaultAcl(path.getParent());

    fs.create(path, permission, true, 1024, (short) 1, 1023, null);
    FileStatus status = fs.getFileStatus(path);
    Assert.assertEquals(permission.applyUMask(DEFAULT_UMASK_PERMISSION), status.getPermission());
  }

  @Test
  public void testFolderPermission() throws Exception {
    final AzureBlobFileSystem fs = this.getFileSystem();
    path = new Path(testRoot, UUID.randomUUID().toString());

    fs.mkdirs(path.getParent(),
        new FsPermission(FsAction.ALL, FsAction.WRITE, FsAction.NONE));
    fs.removeDefaultAcl(path.getParent());

    fs.mkdirs(path, permission);
    FileStatus status = fs.getFileStatus(path);
    Assert.assertEquals(permission.applyUMask(DEFAULT_UMASK_PERMISSION), status.getPermission());
  }
}
