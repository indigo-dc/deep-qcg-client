package it.infn.ba.deep.qcg.client.utils;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import it.infn.ba.deep.qcg.client.model.Job;
import it.infn.ba.deep.qcg.client.model.JobDescription;
import it.infn.ba.deep.qcg.client.model.JobDescriptionExecution;
import it.infn.ba.deep.qcg.client.model.JobDescriptionResources;
import it.infn.ba.deep.qcg.client.model.JobDescriptionResourcesComponent;
import it.infn.ba.deep.qcg.client.model.JobWorkingDirectoryPolicy;
import it.infn.ba.deep.qcg.client.model.JobWorkingDirectoryPolicyRemoveCondition;
import it.infn.ba.deep.qcg.client.model.RemoveConditionCreateMode;
import it.infn.ba.deep.qcg.client.model.RemoveConditionJobStatus;
import it.infn.ba.deep.qcg.client.model.RemoveConditionOrigin;
import it.infn.ba.deep.qcg.client.model.RemoveConditionWhen;

public class QcgTestUtils {

	public static Job buildJob(String id) {
		Job job = new Job();
		
	    job.setId(id);
	    job.setAttributes(new HashMap<String,String>());
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
		resources.setWall_clock(1.0);
		resources.setQueue("normal");
		jd.setResources(resources);
		jd.setMonitoring(null);
		
		return jd;
	}
//{"id":"60","attributes":{},"user":"default-user","state":"FINISHED","operation":null,"note":"3c915645-5402-471c-b9c6-dcc84a114ae6","description":{"note":"3c915645-5402-471c-b9c6-dcc84a114ae6","execution":{"directory":"/qcg/${QCGNCOMP_JOB_ID}","executable":"/usr/bin/date","environment":{"USER":"slurm_user","QCGNCOMP_JOB_ID":"60","QCGNCOMP_JOB_SECRET_AUTH":"0a05ef399fc54112abae2b9b1eb4bff8"},"directory_policy":{"create":"OVERWRITE","remove":"NEVER"}}},"operation_start":null,"resource":null,"queue":"normal","local_user":"slurm_user","local_group":null,"local_id":"53","submit_time":"2019-06-07T12:55:23.912772Z","start_time":"2019-06-07T12:55:25Z","finish_time":"2019-06-07T12:55:25Z","updated_time":"2019-06-07T12:55:29.468312Z","eta":null,"nodes":"c1","cpus":1,"exit_code":0,"errors":null,"resubmit":1,"work_dir":"/qcg/60","created_work_dir":true,"last_seen":"2019-06-07T12:55:29.466927Z"}
}
