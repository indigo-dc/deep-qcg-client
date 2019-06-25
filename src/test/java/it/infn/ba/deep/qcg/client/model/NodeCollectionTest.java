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

public class NodeCollectionTest {
    
    @Test
    public void test() {
        
        NodeCollection C = new NodeCollection();
        
        //default values
        assertTrue(C.getList()==null);        
        assertTrue(C.getNode_stats()==null);

        NodeCollection C1 = new NodeCollection();
        
        List<Node> list = new ArrayList<Node>();
        Stats node_stats = new Stats();
        C1.setList(list);
        C1.setNode_stats(node_stats);
        
        assertTrue(C1.getList().equals(list));
        assertTrue(C1.getNode_stats().equals(node_stats));
        
        C1.toString();
        
        
        NodeCollection C2 = new NodeCollection(list,
                                               node_stats);
        
        assertTrue(C2.getList().equals(list));
        assertTrue(C2.getNode_stats().equals(node_stats));
    }
}
