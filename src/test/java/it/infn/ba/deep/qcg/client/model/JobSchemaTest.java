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

public class JobSchemaTest {

    @Test
    public void test() {
      
        JobSchema S = new JobSchema();
        
        //default values
        assertTrue(S.getDescription()==null);        

        JobDescription description = QcgTestUtils.buildJobDescription("1");
        
        JobSchema S1 = new JobSchema();
        S1.setId(1);
        S1.setUser("user");
        S1.setDescription(description);
        S1.setName("name");
        S1.setCreated("created");
        S1.setUpdated("updated");
        
        assertTrue(S1.getId()==1);
        assertTrue(S1.getUser().equals("user"));
        assertTrue(S1.getDescription().equals(description));
        assertTrue(S1.getName().equals("name"));
        assertTrue(S1.getCreated().equals("created"));
        assertTrue(S1.getUpdated().equals("updated"));
        
        S1.toString();
        
        JobSchema S2 = new JobSchema(1,
                                     "user",
                                     description,
                                     "name",
                                     "created",
                                     "updated");
        
        assertTrue(S2.getId()==1);
        assertTrue(S2.getUser().equals("user"));
        assertTrue(S2.getDescription().equals(description));
        assertTrue(S2.getName().equals("name"));
        assertTrue(S2.getCreated().equals("created"));
        assertTrue(S2.getUpdated().equals("updated"));
        
    }

}
