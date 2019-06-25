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

public class JobDescriptionMonitoringEntryTest {

    @Test
    public void test() {

        JobDescriptionMonitoringEntry E = new JobDescriptionMonitoringEntry();
        
        //default values
        assertTrue(E.getScheme().equals(MonitoringScheme.http));
        assertTrue(E.getWhen().equals(MonitoringWhen.ALWAYS));
        

        JobDescriptionMonitoringEntry E1 = new JobDescriptionMonitoringEntry();
        E1.setScheme(MonitoringScheme.email);
        E1.setAddress("127.0.0.1");
        E1.setWhen(MonitoringWhen.CANCELED);
        
        assertTrue(E1.getScheme().equals(MonitoringScheme.email));
        assertTrue(E1.getAddress().equals("127.0.0.1"));
        assertTrue(E1.getWhen().equals(MonitoringWhen.CANCELED));
        
        E1.toString();
        
        JobDescriptionMonitoringEntry E2 = new JobDescriptionMonitoringEntry(
                                                    MonitoringScheme.email,
                                                    "127.0.0.2",
                                                    MonitoringWhen.FAILED);

        assertTrue(E2.getScheme().equals(MonitoringScheme.email));
        assertTrue(E2.getAddress().equals("127.0.0.2"));
        assertTrue(E2.getWhen().equals(MonitoringWhen.FAILED));
        
    }

}
