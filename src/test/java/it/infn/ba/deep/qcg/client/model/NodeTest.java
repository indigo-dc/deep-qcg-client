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

public class NodeTest {

    @Test
    public void test() {
        
        Node N1 = new Node();
        N1.setName("name");
        N1.setCpus(4);
        N1.setHost("localhost");
        N1.setMemory(1024);
        N1.setMemory_alloc(512);
        N1.setState("state");
        N1.setQueues("queues");
        
        assertTrue(N1.getName().equals("name"));
        assertTrue(N1.getCpus()==4);
        assertTrue(N1.getHost().equals("localhost"));
        assertTrue(N1.getMemory()==1024);
        assertTrue(N1.getMemory_alloc()==512);
        assertTrue(N1.getState().equals("state"));
        assertTrue(N1.getQueues().equals("queues"));
        
        N1.toString();
        
        Node N2 = new Node("name",
                           4,
                           "localhost",
                           1024,
                           512,
                           "state",
                           "queues");

        assertTrue(N2.getName().equals("name"));
        assertTrue(N2.getCpus()==4);
        assertTrue(N2.getHost().equals("localhost"));
        assertTrue(N2.getMemory()==1024);
        assertTrue(N2.getMemory_alloc()==512);
        assertTrue(N2.getState().equals("state"));
        assertTrue(N2.getQueues().equals("queues"));
        
    }
}
