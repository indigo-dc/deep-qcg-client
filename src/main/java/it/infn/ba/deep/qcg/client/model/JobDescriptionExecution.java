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
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * @author michele
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Builder
@AllArgsConstructor
public class JobDescriptionExecution implements Serializable {

	/**
	 * execution specification
	 */
	private static final long serialVersionUID = -2081318454898798450L;

	/**
	 * path to the exectuable file
	 */
	private String executable;

	/**
	 * list of arguments for the executable
	 */

	private List<String> args;

	/**
	 * file name to place standard output stream
	 */
	private String stdout;
		
	/**
	 * file name to place standard error stream
	 */
	private String stderr;
		
	/**
	 * file name to place standard output and error streams
	 */
	private String std_outerr;
		
	/**
	 * file name with the standard input stream
	 */
	private String stdin;

	/**
	 * dictionary with the environment variables to set
	 */

	private Map<String,String> environment;

	/**
	 * path to the working directory for the job
	 */
	private String directory;

	/**
	 * policy of creating and removing working directories
	 */

	private JobWorkingDirectoryPolicy directory_policy;
		
	public JobDescriptionExecution() {
		args = null;
		environment = null;
		directory_policy = null;
	}
	
}
