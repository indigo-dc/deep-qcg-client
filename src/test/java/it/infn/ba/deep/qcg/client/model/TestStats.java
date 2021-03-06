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

import java.util.HashMap;
import java.util.Map;

public class TestStats {

    @Test
    public void test() {
        
        Stats S = new Stats();
        
        //default values
        assertTrue(S.getTotal()==null);        
        assertTrue(S.getStates()==null);
        
        Stats S1 = new Stats();
        
        Map<String,Integer> total = new HashMap<String,Integer>();
        total.put("jobs", 1);
        
        Map<String,Integer> running = new HashMap<String,Integer>();
        running.put("jobs", 2);
        
        Map<String, Map<String,Integer>> states = new HashMap<String, Map<String,Integer>>();
        states.put("RUNNING", running);
        
        String es = "2019-12-01T23:59:59+01:00";
        
        S1.setTotal(total);
        S1.setStates(states);
        S1.setEarliest_submit(es);
        
        assertTrue(S1.getTotal().equals(total));
        assertTrue(S1.getStates().equals(states));
        assertTrue(S1.getEarliest_submit().equals(es));
        
        S1.toString();
        
        Stats S2 = new Stats(total,
                             states,
                             es);
        
        assertTrue(S2.getTotal().equals(total));
        assertTrue(S2.getStates().equals(states));
        assertTrue(S2.getEarliest_submit().equals(es));
        
    }
}
