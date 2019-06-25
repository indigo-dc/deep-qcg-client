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

import it.infn.ba.deep.qcg.client.utils.QcgTestUtils;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class JobCollectionTest {

    @Test
    public void test() {
        
        JobCollection C = new JobCollection();
   
       //default values
       assertTrue(C.getResults()==null);  
   
   
       JobCollection C1 = new JobCollection();
       C1.setCount(2);
       C1.setNext("next");
       C1.setPrevious("previous");
   
       Job J1 = QcgTestUtils.buildJob("1");
       Job J2 = QcgTestUtils.buildJob("2");
   
       List<Job> results = new ArrayList<Job>();
       results.add(J1);
       results.add(J2);
   
       C1.setResults(results);
       
       assertTrue(C1.getCount()==2);
       assertTrue(C1.getNext().equals("next"));
       assertTrue(C1.getPrevious().equals("previous"));
       assertTrue(C1.getResults().get(0).equals(J1));
       assertTrue(C1.getResults().get(1).equals(J2));
       
       C1.toString();
       
       JobCollection C2 = new JobCollection(2,
                                            "next",
                                            "previous",
                                            results);
       
       assertTrue(C2.getCount()==2);
       assertTrue(C2.getNext().equals("next"));
       assertTrue(C2.getPrevious().equals("previous"));
       assertTrue(C2.getResults().get(0).equals(J1));
       assertTrue(C2.getResults().get(1).equals(J2));
   
    }
}
