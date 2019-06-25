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

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ResourcesTest {

    @Test
    public void test() {
        
        Resources R = new Resources();
        
        //default values
        assertTrue(R.getNodes()==null);
        assertTrue(R.getQueues()==null);        
        assertTrue(R.getConfig()==null);
        
        
        Resources R1 = new Resources();
        R1.setDate("date");
        List<Node> nodes = new ArrayList<Node>();
        List<Queue> queues = new ArrayList<Queue>();
        Map<String,String> config = new HashMap<String,String>();
        config.put("k", "v");
        R1.setNodes(nodes);
        R1.setQueues(queues);
        R1.setConfig(config);
        
        assertTrue(R1.getDate().equals("date"));
        assertTrue(R1.getNodes().equals(nodes));
        assertTrue(R1.getQueues().equals(queues));
        assertTrue(R1.getConfig().equals(config));
        
        R1.toString();
        
        Resources R2 = new Resources("date",
                                     nodes,
                                     queues,
                                     config);
        
        assertTrue(R2.getDate().equals("date"));
        assertTrue(R2.getNodes().equals(nodes));
        assertTrue(R2.getQueues().equals(queues));
        assertTrue(R2.getConfig().equals(config));
    }    
}
