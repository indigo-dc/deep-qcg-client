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


public class IndexJobEventTest {

    @Test
    public void test() {
        
        IndexJobEvent I1 = new IndexJobEvent();
        
        I1.setEvent_id("1");
        I1.setCreated("created");
        I1.setId("2");
        I1.setUser("user");
        I1.setState("state");
        I1.setOperation("operation");
        I1.setOperation_begin("operation_begin");
        I1.setQueue("queue");
        I1.setLocal_user("local_user");
        I1.setLocal_group("local_group");
        I1.setLocal_id("local_id");
        I1.setSubmit_time("submit_time");
        I1.setStart_time("start_time");
        I1.setFinish_time("finish_time");
        I1.setUpdated_time("updated_time");
        I1.setEta("eta");
        I1.setNodes("nodes");
        I1.setCpus(4);
        I1.setExit_code(401);
        I1.setErrors("errors");
        I1.setWork_dir("work_dir");
        
        assertTrue(I1.getEvent_id().equals("1"));
        assertTrue(I1.getCreated().equals("created"));
        assertTrue(I1.getId().equals("2"));
        assertTrue(I1.getUser().equals("user"));
        assertTrue(I1.getState().equals("state"));
        assertTrue(I1.getOperation().equals("operation"));
        assertTrue(I1.getOperation_begin().equals("operation_begin"));
        assertTrue(I1.getQueue().equals("queue"));
        assertTrue(I1.getLocal_user().equals("local_user"));
        assertTrue(I1.getLocal_group().equals("local_group"));
        assertTrue(I1.getLocal_id().equals("local_id"));
        assertTrue(I1.getSubmit_time().equals("submit_time"));
        assertTrue(I1.getStart_time().equals("start_time"));
        assertTrue(I1.getFinish_time().equals("finish_time"));
        assertTrue(I1.getUpdated_time().equals("updated_time"));
        assertTrue(I1.getEta().equals("eta"));
        assertTrue(I1.getNodes().equals("nodes"));
        assertTrue(I1.getCpus().equals(4));
        assertTrue(I1.getExit_code()==401);
        assertTrue(I1.getErrors().equals("errors"));
        assertTrue(I1.getWork_dir().equals("work_dir"));

        I1.toString();
        
        IndexJobEvent I2 = new IndexJobEvent("1",
                                             "created",
                                             "2",
                                             "user",
                                             "state",
                                             "operation",
                                             "operation_begin",
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
                                             "work_dir");
        
        assertTrue(I2.getEvent_id().equals("1"));
        assertTrue(I2.getCreated().equals("created"));
        assertTrue(I2.getId().equals("2"));
        assertTrue(I2.getUser().equals("user"));
        assertTrue(I2.getState().equals("state"));
        assertTrue(I2.getOperation().equals("operation"));
        assertTrue(I2.getOperation_begin().equals("operation_begin"));
        assertTrue(I2.getQueue().equals("queue"));
        assertTrue(I2.getLocal_user().equals("local_user"));
        assertTrue(I2.getLocal_group().equals("local_group"));
        assertTrue(I2.getLocal_id().equals("local_id"));
        assertTrue(I2.getSubmit_time().equals("submit_time"));
        assertTrue(I2.getStart_time().equals("start_time"));
        assertTrue(I2.getFinish_time().equals("finish_time"));
        assertTrue(I2.getUpdated_time().equals("updated_time"));
        assertTrue(I2.getEta().equals("eta"));
        assertTrue(I2.getNodes().equals("nodes"));
        assertTrue(I2.getCpus().equals(4));
        assertTrue(I2.getExit_code()==401);
        assertTrue(I2.getErrors().equals("errors"));
        assertTrue(I2.getWork_dir().equals("work_dir"));
        
    }
}
