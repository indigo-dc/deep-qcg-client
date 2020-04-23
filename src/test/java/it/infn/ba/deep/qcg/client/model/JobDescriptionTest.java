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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobDescriptionTest {

    @Test
    public void test() {
        
        JobDescription D = new  JobDescription();
        
        //default values
        assertTrue(D.getExecution()==null);        
        assertTrue(D.getResources()==null);        
        assertTrue(D.getMonitoring()==null);        
        assertTrue(D.getAttributes()==null);        

        
        JobDescription D1 = new JobDescription();
        
        D1.setNote("test descriptor");
        D1.setSchema("default");
        JobDescriptionExecution execution = new JobDescriptionExecution();
        execution.setExecutable("/usr/bin/printf");
        execution.setArgs(Arrays.asList(new String[]{"qgc test"}));
        execution.setStdout("/tmp/deleteme1.txt");
        execution.setStderr("/tmp/deleteme2.txt");
        execution.setStd_outerr("/tmp/deleteme3.txt");
        execution.setStdin(null);
        Map<String,String> environment = new HashMap<String,String>();
        environment.put("USER","slurm_user");
        environment.put("QCGNCOMP_JOB_ID","1");
        environment.put("QCGNCOMP_JOB_SECRET_AUTH","0a05ef399fc54112abae2b9b1eb4bff8");
        execution.setEnvironment(environment);
        execution.setDirectory("/qcg/${QCGNCOMP_JOB_ID}");
        JobWorkingDirectoryPolicy directory_policy = new JobWorkingDirectoryPolicy();
        directory_policy.setCreate(RemoveConditionCreateMode.OVERWRITE);
        directory_policy.setRemove(RemoveConditionWhen.NEVER);
        JobWorkingDirectoryPolicyRemoveCondition customremove = new JobWorkingDirectoryPolicyRemoveCondition();
        customremove.setStatus(RemoveConditionJobStatus.FAILED);
        customremove.setOrigin(RemoveConditionOrigin.ANY);
        directory_policy.setRemove_custom(customremove);
        execution.setDirectory_policy(directory_policy);
        D1.setExecution(execution);
        JobDescriptionResources resources = new JobDescriptionResources();
        JobDescriptionResourcesComponent component = new JobDescriptionResourcesComponent();
        component.setTotal_cores(4);
        component.setTotal_nodes(2);
        component.setCores_per_node(2);
        component.setNode_attrs(Arrays.asList(new String[]{"qgc test"}));
        component.setMemory_per_node(4);
        component.setMemory_per_core(8);
        component.setConsumable("nothing");
        resources.setComponents(Arrays.asList(new JobDescriptionResourcesComponent[]{component}));
        resources.setWall_clock("01:00:00");
        resources.setQueue("normal");
        D1.setResources(resources);
        JobDescriptionMonitoring monitoring = new JobDescriptionMonitoring();
        JobDescriptionMonitoringEntry E = new JobDescriptionMonitoringEntry(
                MonitoringScheme.http,
                "127.0.0.1",
                MonitoringWhen.ALWAYS);
        List<JobDescriptionMonitoringEntry> notify = new ArrayList<JobDescriptionMonitoringEntry>();
        notify.add(E);
        monitoring.setNotify(notify);        
        D1.setMonitoring(monitoring);     
        Map<String,String> attributes = new HashMap<String,String>();
        attributes.put("k1", "v1");
        D1.setAttributes(attributes);
        
        
        assertTrue(D1.getNote().equals("test descriptor"));
        assertTrue(D1.getSchema().equals("default"));
        assertTrue(D1.getExecution().equals(execution));
        assertTrue(D1.getResources().equals(resources));
        assertTrue(D1.getMonitoring().equals(monitoring));
        assertTrue(D1.getAttributes().equals(attributes));
        
        D1.toString();
        
        JobDescription D2 = new JobDescription("test descriptor",
                                               "default",
                                               execution,
                                               resources,
                                               monitoring,
                                               attributes);

        assertTrue(D2.getNote().equals("test descriptor"));
        assertTrue(D2.getSchema().equals("default"));
        assertTrue(D2.getExecution().equals(execution));
        assertTrue(D2.getResources().equals(resources));
        assertTrue(D2.getMonitoring().equals(monitoring));
        assertTrue(D2.getAttributes().equals(attributes));
        
    }

}
