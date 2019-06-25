/*
 * Copyright © 2019 I.N.F.N.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.infn.ba.deep.qcg.client.model;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobDescriptionExecutionTest {

    @Test
    public void test() {
                
        JobDescriptionExecution E = new JobDescriptionExecution();
        
        //default values
        assertTrue(E.getArgs()==null);        
        assertTrue(E.getEnvironment()==null);        
        assertTrue(E.getDirectory_policy()==null);
        
        JobDescriptionExecution E1 = new JobDescriptionExecution();
        
        E1.setExecutable("/usr/bin/printf");
        List<String> args = new ArrayList<String>();
        args.add("qgc test");
        E1.setArgs(args);
        E1.setStdout("/tmp/deleteme1.txt");
        E1.setStderr("/tmp/deleteme2.txt");
        E1.setStd_outerr("/tmp/deleteme3.txt");
        E1.setStdin("/tmp/deleteme4.txt");
        Map<String,String> environment = new HashMap<String,String>();
        environment.put("USER","slurm_user");
        environment.put("QCGNCOMP_JOB_ID","1");
        environment.put("QCGNCOMP_JOB_SECRET_AUTH","0a05ef399fc54112abae2b9b1eb4bff8");
        E1.setEnvironment(environment);
        E1.setDirectory("/qcg/${QCGNCOMP_JOB_ID}");
        JobWorkingDirectoryPolicy directory_policy = new JobWorkingDirectoryPolicy();
        directory_policy.setCreate(RemoveConditionCreateMode.OVERWRITE);
        directory_policy.setRemove(RemoveConditionWhen.NEVER);
        JobWorkingDirectoryPolicyRemoveCondition customremove = new JobWorkingDirectoryPolicyRemoveCondition();
        customremove.setStatus(RemoveConditionJobStatus.FAILED);
        customremove.setOrigin(RemoveConditionOrigin.ANY);
        directory_policy.setRemove_custom(customremove);
        E1.setDirectory_policy(directory_policy); 
        
        assertTrue(E1.getExecutable().equals("/usr/bin/printf"));
        assertTrue(E1.getArgs().equals(args));
        assertTrue(E1.getStdout().equals("/tmp/deleteme1.txt"));
        assertTrue(E1.getStderr().equals("/tmp/deleteme2.txt"));
        assertTrue(E1.getStd_outerr().equals("/tmp/deleteme3.txt"));
        assertTrue(E1.getStdin().equals("/tmp/deleteme4.txt"));
        assertTrue(E1.getEnvironment().equals(environment));
        assertTrue(E1.getDirectory().equals("/qcg/${QCGNCOMP_JOB_ID}"));
        assertTrue(E1.getDirectory_policy().equals(directory_policy));
        
        E1.toString();

        JobDescriptionExecution E2 = new JobDescriptionExecution("/usr/bin/printf",
                                                                 args,
                                                                 "/tmp/deleteme1.txt",
                                                                 "/tmp/deleteme2.txt",
                                                                 "/tmp/deleteme3.txt",
                                                                 "/tmp/deleteme4.txt",
                                                                 environment,
                                                                 "/qcg/${QCGNCOMP_JOB_ID}",
                                                                 directory_policy);
        
        assertTrue(E2.getExecutable().equals("/usr/bin/printf"));
        assertTrue(E2.getArgs().equals(args));
        assertTrue(E2.getStdout().equals("/tmp/deleteme1.txt"));
        assertTrue(E2.getStderr().equals("/tmp/deleteme2.txt"));
        assertTrue(E2.getStd_outerr().equals("/tmp/deleteme3.txt"));
        assertTrue(E2.getStdin().equals("/tmp/deleteme4.txt"));
        assertTrue(E2.getEnvironment().equals(environment));
        assertTrue(E2.getDirectory().equals("/qcg/${QCGNCOMP_JOB_ID}"));
        assertTrue(E2.getDirectory_policy().equals(directory_policy));
        
    }

}
