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
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class JobDescriptionResources implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1271239842338801274L;

	
	private List<JobDescriptionResourcesComponent> components;
	
	/**
	 * maximum total execution time
	 */
	Double wall_clock;

	/**
	 * queue/partition name
	 */
	private String queue;
	
	/**
	 * list of resource requirements components
	 */
	public JobDescriptionResources() {
		components = null;
	}
}
