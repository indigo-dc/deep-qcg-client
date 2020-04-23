/*
 * Copyright © 2019-2020 I.N.F.N.
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

import it.infn.ba.deep.qcg.client.utils.QcgTestUtils;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class JobTest {

    @Test
    public void test() {
        
        Job J = new Job();
        
        //default values
        assertTrue(J.getAttributes()==null); 
        assertTrue(J.getDescription()==null);
        assertTrue(J.getCpus()==null);
        assertTrue(J.getExit_code()==null);
        assertTrue(J.getResubmit()==null);
        assertTrue(J.getCreated_work_dir()==null);
        
        Job J1 = new Job();
        J1.setId("1");
        
        Map<String,String> attributes = new HashMap<String,String>();
        attributes.put("k", "v");
        J1.setAttributes(attributes);
        J1.setUser("user");
        J1.setType("type");
        J1.setState("state");
        J1.setOperation("operation");
        J1.setNote("note");
        J1.setTask_id("taskid");
        
        JobDescription description = QcgTestUtils.buildJobDescription("1");
        
        J1.setDescription(description);
        J1.setOperation_start("operation_start");
        J1.setResource("resource");
        J1.setQueue("queue");
        J1.setLocal_user("local_user");
        J1.setLocal_group("local_group");
        J1.setLocal_id("local_id");
        J1.setSubmit_time("submit_time");
        J1.setStart_time("start_time");
        J1.setFinish_time("finish_time");
        J1.setUpdated_time("updated_time");        
        J1.setEta("eta");
        J1.setNodes("nodes");
        J1.setCpus(4);
        J1.setExit_code(401);
        J1.setErrors("errors");
        J1.setResubmit(1);
        J1.setWork_dir("work_dir");
        J1.setCreated_work_dir(true);
        J1.setLast_seen("last_seen");
        J1.setParent_job(2);
        
        assertTrue(J1.getId().equals("1"));
        assertTrue(J1.getAttributes().equals(attributes));
        assertTrue(J1.getUser().equals("user"));
        assertTrue(J1.getType().equals("type"));
        assertTrue(J1.getState().equals("state"));
        assertTrue(J1.getOperation().equals("operation"));
        assertTrue(J1.getNote().equals("note"));
        assertTrue(J1.getTask_id().equals("taskid"));
        assertTrue(J1.getDescription().equals(description));
        assertTrue(J1.getOperation_start().equals("operation_start"));
        assertTrue(J1.getResource().equals("resource"));
        assertTrue(J1.getQueue().equals("queue"));
        assertTrue(J1.getLocal_user().equals("local_user"));
        assertTrue(J1.getLocal_group().equals("local_group"));
        assertTrue(J1.getLocal_id().equals("local_id"));
        assertTrue(J1.getSubmit_time().equals("submit_time"));
        assertTrue(J1.getStart_time().equals("start_time"));
        assertTrue(J1.getFinish_time().equals("finish_time"));
        assertTrue(J1.getUpdated_time().equals("updated_time"));
        assertTrue(J1.getEta().equals("eta"));
        assertTrue(J1.getNodes().equals("nodes"));
        assertTrue(J1.getCpus().equals(4));
        assertTrue(J1.getExit_code()==401);
        assertTrue(J1.getErrors().equals("errors"));
        assertTrue(J1.getResubmit().equals(1));
        assertTrue(J1.getWork_dir().equals("work_dir"));
        assertTrue(J1.getCreated_work_dir().equals(true));
        assertTrue(J1.getLast_seen().equals("last_seen"));
        assertTrue(J1.getParent_job().equals(2));
        
        J1.toString();
        
        Job J2 = new Job("1",
                         attributes,
                         "user",  
                         "type",
                         "state",
                         "operation",
                         "note",
                         "taskid",
                         description,
                         "operation_start",
                         "resource",
                         "queue",
                         "local_user",
                         "local_group",
                         "local_id",
                         "submit_time",
                         "start_time",
                         "finish_time",
                         "updated_time",        
                         "eta",
                         "nodes",
                         4,
                         401,
                         "errors",
                         1,
                         "work_dir",
                         true,
                         "last_seen",
                         2);
        
        assertTrue(J2.getId().equals("1"));
        assertTrue(J2.getAttributes().equals(attributes));
        assertTrue(J2.getUser().equals("user"));
        assertTrue(J2.getType().equals("type"));
        assertTrue(J2.getState().equals("state"));
        assertTrue(J2.getOperation().equals("operation"));
        assertTrue(J2.getNote().equals("note"));
        assertTrue(J2.getTask_id().equals("taskid"));
        assertTrue(J2.getDescription().equals(description));
        assertTrue(J2.getOperation_start().equals("operation_start"));
        assertTrue(J2.getResource().equals("resource"));
        assertTrue(J2.getQueue().equals("queue"));
        assertTrue(J2.getLocal_user().equals("local_user"));
        assertTrue(J2.getLocal_group().equals("local_group"));
        assertTrue(J2.getLocal_id().equals("local_id"));
        assertTrue(J2.getSubmit_time().equals("submit_time"));
        assertTrue(J2.getStart_time().equals("start_time"));
        assertTrue(J2.getFinish_time().equals("finish_time"));
        assertTrue(J2.getUpdated_time().equals("updated_time"));
        assertTrue(J2.getEta().equals("eta"));
        assertTrue(J2.getNodes().equals("nodes"));
        assertTrue(J2.getCpus().equals(4));
        assertTrue(J2.getExit_code()==401);
        assertTrue(J2.getErrors().equals("errors"));
        assertTrue(J2.getResubmit().equals(1));
        assertTrue(J2.getWork_dir().equals("work_dir"));
        assertTrue(J2.getCreated_work_dir().equals(true));
        assertTrue(J2.getLast_seen().equals("last_seen"));
        assertTrue(J2.getParent_job().equals(2));
        
    }

}