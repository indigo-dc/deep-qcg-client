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

public class NodeTest {

    @Test
    public void test() {
        
        Node N1 = new Node();
        N1.setCpus(4);
        N1.setLoad(1.0);
        N1.setGres("tesla");
        N1.setHost("localhost");
        N1.setOs("linux");
        N1.setMemory(1024);
        N1.setMemory_alloc(512);
        N1.setMemory_free(256);
        N1.setState("state");
        N1.setQueues("queues");
        
        assertTrue(N1.getCpus()==4);
        assertTrue(N1.getLoad()==1.0);
        assertTrue(N1.getGres().equals("tesla"));
        assertTrue(N1.getHost().equals("localhost"));
        assertTrue(N1.getOs().equals("linux"));
        assertTrue(N1.getMemory()==1024);
        assertTrue(N1.getMemory_alloc()==512);
        assertTrue(N1.getMemory_free()==256);
        assertTrue(N1.getState().equals("state"));
        assertTrue(N1.getQueues().equals("queues"));
        
        N1.toString();
        
        Node N2 = new Node(4,
        				   1.0,
        				   "tesla",
                           "localhost",
                           "linux",
                           1024,
                           512,
                           256,
                           "state",
                           "queues");

        assertTrue(N2.getCpus()==4);
        assertTrue(N2.getLoad()==1.0);
        assertTrue(N2.getGres().equals("tesla"));
        assertTrue(N2.getHost().equals("localhost"));
        assertTrue(N2.getOs().equals("linux"));
        assertTrue(N2.getMemory()==1024);
        assertTrue(N2.getMemory_alloc()==512);
        assertTrue(N2.getMemory_free()==256);
        assertTrue(N2.getState().equals("state"));
        assertTrue(N2.getQueues().equals("queues"));
        
    }
}
