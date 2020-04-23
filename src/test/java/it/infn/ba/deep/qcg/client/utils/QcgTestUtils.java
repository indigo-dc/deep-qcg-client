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

package it.infn.ba.deep.qcg.client.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.infn.ba.deep.qcg.client.model.Job;
import it.infn.ba.deep.qcg.client.model.JobDescription;
import it.infn.ba.deep.qcg.client.model.JobDescriptionExecution;
import it.infn.ba.deep.qcg.client.model.JobDescriptionMonitoring;
import it.infn.ba.deep.qcg.client.model.JobDescriptionMonitoringEntry;
import it.infn.ba.deep.qcg.client.model.JobDescriptionResources;
import it.infn.ba.deep.qcg.client.model.JobDescriptionResourcesComponent;
import it.infn.ba.deep.qcg.client.model.JobWorkingDirectoryPolicy;
import it.infn.ba.deep.qcg.client.model.JobWorkingDirectoryPolicyRemoveCondition;
import it.infn.ba.deep.qcg.client.model.MonitoringScheme;
import it.infn.ba.deep.qcg.client.model.MonitoringWhen;
import it.infn.ba.deep.qcg.client.model.RemoveConditionCreateMode;
import it.infn.ba.deep.qcg.client.model.RemoveConditionJobStatus;
import it.infn.ba.deep.qcg.client.model.RemoveConditionOrigin;
import it.infn.ba.deep.qcg.client.model.RemoveConditionWhen;

public class QcgTestUtils {

	public static Job buildJob(String id) {
		Job job = new Job();
		
	    job.setId(id);
        Map<String,String> attributes = new HashMap<String,String>();
        attributes.put("k", "v");
        job.setAttributes(attributes);	    
	    job.setUser("default-user");
	    job.setState("FINISHED");
	    job.setNote("3c915645-5402-471c-b9c6-dcc84a114ae6");
	    job.setDescription(buildJobDescription(id));
	    job.setLocal_id(id);
	    job.setLocal_user("slurm_user");
	    job.setWork_dir("/qcg/" + id);
	    job.setResubmit(1);
	    job.setNodes("c1");
	    job.setCpus(1);
	    job.setQueue("normal");
	    job.setSubmit_time("2019-06-07T12:55:23.912772Z");
	    job.setStart_time("2019-06-07T12:55:25Z");
	    job.setFinish_time("2019-06-07T12:55:25Z");
	    job.setUpdated_time("2019-06-07T12:55:29.468312Z");
	    
		return job;
	}
	
	public static JobDescription buildJobDescription(String id) {
		
		JobDescription jd = new JobDescription();
		jd.setNote("test descriptor");
		jd.setSchema("default");
		JobDescriptionExecution execution = new JobDescriptionExecution();
		execution.setExecutable("/usr/bin/printf");
		execution.setArgs(Arrays.asList(new String[]{"qgc test"}));
		execution.setStdout("/tmp/deleteme1.txt");
		execution.setStderr("/tmp/deleteme2.txt");
		execution.setStd_outerr("/tmp/deleteme3.txt");
		execution.setStdin(null);
		Map<String,String> environment = new HashMap<String,String>();
		environment.put("USER","slurm_user");
		environment.put("QCGNCOMP_JOB_ID",id);
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
		jd.setExecution(execution);
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
		jd.setResources(resources);
        JobDescriptionMonitoring monitoring = new JobDescriptionMonitoring();
        JobDescriptionMonitoringEntry E = new JobDescriptionMonitoringEntry(
                MonitoringScheme.http,
                "127.0.0.1",
                MonitoringWhen.ALWAYS);
        List<JobDescriptionMonitoringEntry> notify = new ArrayList<JobDescriptionMonitoringEntry>();
        notify.add(E);
        monitoring.setNotify(notify);        
		jd.setMonitoring(monitoring);
        Map<String,String> attributes = new HashMap<String,String>();
        attributes.put("k1", "v1");
        jd.setAttributes(attributes);
		
		return jd;
	}
}