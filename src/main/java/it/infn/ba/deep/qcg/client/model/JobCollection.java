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
public class JobCollection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1665966146837668770L;

	/**
	 * number of entries in results
	 */
	private int count;
	
	/**
	 * URI pointer to next page
	 */
	private String next;
	
	/**
	 * URI pointer to previous page
	 */
	private String previous;
	
	/**
	 * List of Job objects
	 */
	private List<Job> results;
	
	/**
	 * 
	 */
	public JobCollection() {
		results = null;
	}
}
