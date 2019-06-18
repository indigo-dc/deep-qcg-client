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

/**
 * list of resource requirements components
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class JobDescriptionResourcesComponent  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8772302844886490502L;

	/**
	 * total number of cores
	 */
	private Integer total_cores;

	/**
	 * total number of nodes
	 */
	private Integer total_nodes;
	
	/**
	 * number of cores per single node
	 */
	private Integer cores_per_node;
		
	/**
	 * node attributes
	 */
	
	private List<String> node_attrs;
	
	/**
	 * available memory per single node
	 */
	private Integer memory_per_node;
		
	/**
	 * available memory per single core
	 */
	private Integer memory_per_core;
		
	/**
	 * consumeable resources definition
	 */
	private String consumable;
		
	/**
	 * schedule system parameters
	 */
	
	private List<String> _native;
	
	public JobDescriptionResourcesComponent() {
		node_attrs = null;
		_native = null;
	}
}
