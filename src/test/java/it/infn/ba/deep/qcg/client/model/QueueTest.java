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

public class QueueTest {

    @Test
    public void test() {
        
        Queue Q1 = new Queue();
        Q1.setName("Q");
        Q1.setDefault(true);
        Q1.setDef_walltime("def_walltime");
        Q1.setMax_time("max_time");
        Q1.setMin_nodes(1);
        Q1.setMax_nodes(999);
        Q1.setNodes(5);
        Q1.setPriority(10);
        Q1.setState("ok");
        Q1.setCpus(16);

        assertTrue(Q1.getName().equals("Q"));
        assertTrue(Q1.isDefault()==true);
        assertTrue(Q1.getDef_walltime().equals("def_walltime"));
        assertTrue(Q1.getMax_time().equals("max_time"));
        assertTrue(Q1.getMin_nodes()==1);
        assertTrue(Q1.getMax_nodes()==999);
        assertTrue(Q1.getNodes()==5);
        assertTrue(Q1.getPriority()==10);
        assertTrue(Q1.getState().equals("ok"));
        assertTrue(Q1.getCpus()==16);
        
        Q1.toString();

        Queue Q2 = new Queue("Q",
                             true,
                             "def_walltime",
                             "max_time",
                             1,
                             999,
                             5,
                             10,
                             "ok",
                             16);
        
        assertTrue(Q2.getName().equals("Q"));
        assertTrue(Q2.isDefault()==true);
        assertTrue(Q2.getDef_walltime().equals("def_walltime"));
        assertTrue(Q2.getMax_time().equals("max_time"));
        assertTrue(Q2.getMin_nodes()==1);
        assertTrue(Q2.getMax_nodes()==999);
        assertTrue(Q2.getNodes()==5);
        assertTrue(Q2.getPriority()==10);
        assertTrue(Q2.getState().equals("ok"));
        assertTrue(Q2.getCpus()==16);
                
    }
}
