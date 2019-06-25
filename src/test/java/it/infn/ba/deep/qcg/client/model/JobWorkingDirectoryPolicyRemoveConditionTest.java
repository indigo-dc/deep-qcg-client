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

public class JobWorkingDirectoryPolicyRemoveConditionTest {

    @Test
    public void test() {
        
        JobWorkingDirectoryPolicyRemoveCondition R = new JobWorkingDirectoryPolicyRemoveCondition();
        
        // default values
        assertTrue(R.getStatus().compareTo(RemoveConditionJobStatus.FINISHED)==0);
        assertTrue(R.getOrigin().compareTo(RemoveConditionOrigin.OWNED)==0);

        JobWorkingDirectoryPolicyRemoveCondition R1 = new JobWorkingDirectoryPolicyRemoveCondition();
        
        R1.setStatus(RemoveConditionJobStatus.CANCELED);
        R1.setOrigin(RemoveConditionOrigin.ANY);
        
        assertTrue(R1.getStatus().compareTo(RemoveConditionJobStatus.CANCELED)==0);
        assertTrue(R1.getOrigin().compareTo(RemoveConditionOrigin.ANY)==0);

        R1.toString();
        
        JobWorkingDirectoryPolicyRemoveCondition R2 = new JobWorkingDirectoryPolicyRemoveCondition(
                RemoveConditionJobStatus.FAILED,
                RemoveConditionOrigin.FOREIGN);

        assertTrue(R2.getStatus().compareTo(RemoveConditionJobStatus.FAILED)==0);
        assertTrue(R2.getOrigin().compareTo(RemoveConditionOrigin.FOREIGN)==0);
        
    }

}
