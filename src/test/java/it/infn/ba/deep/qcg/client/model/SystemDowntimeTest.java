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

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SystemDowntimeTest {

    @Test
    public void test() {
        
        SystemDowntime S = new SystemDowntime();
        S.setUser_message("user_message");
        S.setAdmin_message("admin_message");
        S.setRetry_period(100);
        
        assertTrue(S.getUser_message().compareTo("user_message")==0);
        assertTrue(S.getAdmin_message().compareTo("admin_message")==0);
        assertTrue(S.getRetry_period() == 100);
        
        S.toString();
        
        SystemDowntime S2 = new SystemDowntime("user_message", "admin_message", 100);
        
        assertTrue(S2.getUser_message().compareTo("user_message")==0);
        assertTrue(S2.getAdmin_message().compareTo("admin_message")==0);
        assertTrue(S2.getRetry_period() == 100);        
    }

}
