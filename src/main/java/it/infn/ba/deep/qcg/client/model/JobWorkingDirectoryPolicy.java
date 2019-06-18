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

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * policy of creating and removing working directories
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class JobWorkingDirectoryPolicy  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5459544387273804643L;

	/**
	 *how the working directory should be created
	 *default: OVERWRITE 
	 */
	private RemoveConditionCreateMode create;

	/**
	 *how the working directory should be removed
	 *default: FINISHED_OWNED 
	 */
	private RemoveConditionWhen remove;
	
	/**
	 *detail specifiction of creating and removing working directory 
	 */
	private JobWorkingDirectoryPolicyRemoveCondition remove_custom;
	
	public JobWorkingDirectoryPolicy() {
		create = RemoveConditionCreateMode.OVERWRITE;
		remove = RemoveConditionWhen.FINISHED_OWNED;
		remove_custom = null;
	}
}
