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

public class QueueCollectionTest {
    
    @Test
    public void test() {
        
        QueueCollection Q = new QueueCollection();
        
        //default values
        assertTrue(Q.getList()==null);        
        assertTrue(Q.getJob_stats()==null);

        QueueCollection C1 = new QueueCollection();
        
        Map<String, Queue> queues = new HashMap<String,Queue>();
        Queue Q1 = new Queue();
        Q1.setDefault(true);
        Q1.setDef_walltime("def_walltime");
        Q1.setMax_time("max_time");
        Q1.setMin_nodes(1);
        Q1.setMax_nodes(999);
        Q1.setNodes(5);
        Q1.setPriority(10);
        Q1.setState("ok");
        Q1.setCpus(16);
        queues.put("Q1", Q1);
        List<Map<String, Queue>> list = new ArrayList<Map<String, Queue>>();
        list.add(queues);
        Stats job_stats = new Stats();
        C1.setList(list);
        C1.setJob_stats(job_stats);
        
        assertTrue(C1.getList().equals(list));
        assertTrue(C1.getList().get(0).get("Q1").equals(Q1));        
        assertTrue(C1.getJob_stats().equals(job_stats));
        
        C1.toString();        
        
        QueueCollection Q2 = new QueueCollection(list,
                                               job_stats);
        
        assertTrue(Q2.getList().equals(list));
        assertTrue(Q2.getJob_stats().equals(job_stats));
    }
}
