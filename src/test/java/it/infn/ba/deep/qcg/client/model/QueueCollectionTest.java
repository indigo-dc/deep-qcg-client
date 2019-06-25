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

public class QueueCollectionTest {
    
    @Test
    public void test() {
        
        QueueCollection Q = new QueueCollection();
        
        //default values
        assertTrue(Q.getList()==null);        
        assertTrue(Q.getJob_stats()==null);

        QueueCollection Q1 = new QueueCollection();
        
        List<Queue> list = new ArrayList<Queue>();
        Stats job_stats = new Stats();
        Q1.setList(list);
        Q1.setJob_stats(job_stats);
        
        assertTrue(Q1.getList().equals(list));
        assertTrue(Q1.getJob_stats().equals(job_stats));
        
        Q1.toString();
        
        
        QueueCollection Q2 = new QueueCollection(list,
                                               job_stats);
        
        assertTrue(Q2.getList().equals(list));
        assertTrue(Q2.getJob_stats().equals(job_stats));
    }
}
