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
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * @author Michele Perniola
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Builder
@AllArgsConstructor
public class JobDescription implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -5213288427407469718L;
	
	/**
	 * short description
	 */
	private String note;
	
	/**
	 * schema name to use
	 */
	private String schema;

	/**
	 * execution specification
	 */
	private JobDescriptionExecution execution;
	
	/**
	 * resource requirements
	 */
	private JobDescriptionResources resources;
	
	/**
	 * monitoring - currently not supported
	 */
	private JobDescriptionMonitoring monitoring;

	/**
	 * dictionary with job attributes
	 */
	private Map<String,String> attributes; 

	
	public JobDescription() {
		execution = null;
		resources = null;
		monitoring = null;
		attributes = null;
	}
	
}
