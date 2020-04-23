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
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class JobDescriptionResourcesTest {

    @Test
    public void test() {

        JobDescriptionResources R = new JobDescriptionResources();
        
        //default values
        assertTrue(R.getComponents() == null);
        
        JobDescriptionResources R1 = new JobDescriptionResources();
        
        JobDescriptionResourcesComponent D1 = new JobDescriptionResourcesComponent();
        D1.setTotal_cores(10);
        D1.setTotal_nodes(5);
        D1.setCores_per_node(2);
        List<String> node_attrs = new ArrayList<String>();
        node_attrs.add("na1");
        D1.setNode_attrs(node_attrs);
        D1.setMemory_per_node(1024);
        D1.setMemory_per_core(32);
        D1.setConsumable("consumable");
        List<String> _native = new ArrayList<String>();
        _native.add("nt1");
        D1.set_native(_native);
        
        List<JobDescriptionResourcesComponent> components = new ArrayList<JobDescriptionResourcesComponent>();
        components.add(D1);
        
        R1.setComponents(components);
        R1.setWall_clock("01:00:00");
        R1.setQueue("queue");
        
        assertTrue(R1.getComponents().equals(components));
        assertTrue(R1.getWall_clock()== "01:00:00");
        assertTrue(R1.getQueue().equals("queue"));
        
        R1.toString();
        
        JobDescriptionResources R2 = new JobDescriptionResources(components,
                                                                 "01:00:00",
                                                                 "queue");
        
        assertTrue(R2.getComponents().equals(components));
        assertTrue(R2.getWall_clock()== "01:00:00");
        assertTrue(R2.getQueue().equals("queue"));
        
    }

}
