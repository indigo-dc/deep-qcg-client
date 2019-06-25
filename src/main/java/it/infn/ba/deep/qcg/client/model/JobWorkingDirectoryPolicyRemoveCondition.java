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

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * detail specification of creating and removing working directory
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Builder
@AllArgsConstructor
public class JobWorkingDirectoryPolicyRemoveCondition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5242334317157864976L;

	private RemoveConditionJobStatus status;
	
	/**
	 *is the working directory has been created by the service or already existed 
	 */
	private RemoveConditionOrigin origin;
	
	public JobWorkingDirectoryPolicyRemoveCondition() {
		status = RemoveConditionJobStatus.FINISHED;
		origin = RemoveConditionOrigin.OWNED;
	}
}
