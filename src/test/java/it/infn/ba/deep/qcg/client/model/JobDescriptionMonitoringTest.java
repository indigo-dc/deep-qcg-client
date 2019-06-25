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

public class JobDescriptionMonitoringTest {

    @Test
    public void test() {
        
        JobDescriptionMonitoring M = new JobDescriptionMonitoring();
        
        //default values
        assertTrue(M.getNotify()==null);
        
        
        JobDescriptionMonitoring M1 = new JobDescriptionMonitoring();  
        
        JobDescriptionMonitoringEntry E = new JobDescriptionMonitoringEntry(
                MonitoringScheme.http,
                "127.0.0.1",
                MonitoringWhen.ALWAYS);
        
        List<JobDescriptionMonitoringEntry> notify = new ArrayList<JobDescriptionMonitoringEntry>();
        notify.add(E);
        
        M1.setNotify(notify);
        
        assertTrue(M1.getNotify().equals(notify));
        
        M1.toString();
        
        JobDescriptionMonitoring M2 = new JobDescriptionMonitoring(notify);  

        assertTrue(M2.getNotify().equals(notify));

    }

}
