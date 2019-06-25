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
import java.util.List;

public class JobDescriptionResourcesComponentTest {

    @Test
    public void test() {
     
        JobDescriptionResourcesComponent D = new JobDescriptionResourcesComponent();
        
        //default values
        assertTrue(D.getNode_attrs() == null);
        assertTrue(D.get_native() == null);

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
        
        assertTrue(D1.getTotal_cores().equals(10));
        assertTrue(D1.getTotal_nodes().equals(5));
        assertTrue(D1.getCores_per_node().equals(2));
        assertTrue(D1.getNode_attrs().equals(node_attrs));
        assertTrue(D1.getMemory_per_node().equals(1024));
        assertTrue(D1.getMemory_per_core().equals(32));
        assertTrue(D1.getConsumable().equals("consumable"));
        assertTrue(D1.get_native().equals(_native));
        
        D1.toString();
        
        JobDescriptionResourcesComponent D2 = new JobDescriptionResourcesComponent(
                                                    10,
                                                    5,
                                                    2,
                                                    node_attrs,
                                                    1024,
                                                    32,
                                                    "consumable",
                                                    _native);
        
        assertTrue(D2.getTotal_cores().equals(10));
        assertTrue(D2.getTotal_nodes().equals(5));
        assertTrue(D2.getCores_per_node().equals(2));
        assertTrue(D2.getNode_attrs().equals(node_attrs));
        assertTrue(D2.getMemory_per_node().equals(1024));
        assertTrue(D2.getMemory_per_core().equals(32));
        assertTrue(D2.getConsumable().equals("consumable"));
        assertTrue(D2.get_native().equals(_native));        
    }

}
