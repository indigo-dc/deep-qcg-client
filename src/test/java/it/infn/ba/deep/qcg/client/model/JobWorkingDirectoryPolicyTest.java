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

public class JobWorkingDirectoryPolicyTest {

    @Test
    public void test() {
        
        JobWorkingDirectoryPolicy P = new JobWorkingDirectoryPolicy();
        
        // default values
        assertTrue(P.getCreate().compareTo(RemoveConditionCreateMode.OVERWRITE)==0);
        assertTrue(P.getRemove().compareTo(RemoveConditionWhen.FINISHED_OWNED)==0);
        assertTrue(P.getRemove_custom()==null);

        P.toString();
        
        JobWorkingDirectoryPolicy P1 = new JobWorkingDirectoryPolicy();
        
        P1.setCreate(RemoveConditionCreateMode.NOT_OVERWRITE);
        P1.setRemove(RemoveConditionWhen.CUSTOM);
        
        JobWorkingDirectoryPolicyRemoveCondition R = new JobWorkingDirectoryPolicyRemoveCondition(
                RemoveConditionJobStatus.FAILED,
                RemoveConditionOrigin.FOREIGN);   
        
        P1.setRemove_custom(R);
        
        assertTrue(P1.getCreate().compareTo(RemoveConditionCreateMode.NOT_OVERWRITE)==0);
        assertTrue(P1.getRemove().compareTo(RemoveConditionWhen.CUSTOM)==0);
        assertTrue(P1.getRemove_custom().equals(R));
        
        JobWorkingDirectoryPolicy P2 = new JobWorkingDirectoryPolicy(
                                            RemoveConditionCreateMode.OVERWRITE,
                                            RemoveConditionWhen.CUSTOM,
                                            R);

        assertTrue(P2.getCreate().compareTo(RemoveConditionCreateMode.OVERWRITE)==0);
        assertTrue(P2.getRemove().compareTo(RemoveConditionWhen.CUSTOM)==0);
        assertTrue(P2.getRemove_custom().equals(R));
        
    }

}
