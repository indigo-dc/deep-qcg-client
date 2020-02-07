/*
 * Copyright © 2019-2020 I.N.F.N.
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
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@ToString
@Builder
@NoArgsConstructor
public class IndexJobEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2761041945216098003L;

	/**
	   * event identifier
	   */
	  private String event_id;
	  
	  /**
	   * Created time
	   * $date-time
	   */
	  private String created;

	  /**
	   * Job Id
	   */
	  private String id;
	  	  
	  /**
	   * user's full name
	   */
	  private String user;
	  
	  /**
	   * current job status
	   */
	  private String state;
	  
	  /**
	   * currently ongoing operation
	   */
	  private String operation;
	  
	  /**
	   * operation begin
	   * $date-time
	   */
	  private String operation_begin;
	  
	  /**
	   * scheduling queue/partition job is submitted
	   */
	  private String queue;
	  
	  /**
	   * account job was submitted from
	   */
	  private String local_user;
	  
	  /**
	   * primary group job was submitted from
	   */
	  private String local_group;
	  
	  /**
	   * scheduling system identifier
	   */
	  private String local_id;
	  
	  /**
	   * time of job submission
	   * string($date-time)
	   */
	  private String submit_time;
	  
	  /**
	   * time of job execution start
	   * string($date-time)
	   */
	  private String start_time;
	  
	  /**
	   * time of job termination
	   * string($date-time)
	   */
	  private String finish_time;
	  
	  /**
	   * time of last state update
	   * string($date-time)
	   */
	  private String updated_time;
	  
	  /**
	   * ETA of job termination
	   * string($date-time)
	   */
	  private String eta;
	  
	  /**
	   * name of nodes job is executing on
	   */
	  private String nodes;
	  
	  /**
	   * application exit code
	   */
	  private Integer exit_code;
	  
	  /**
	   * error messages
	   */
	  private String errors;
	  
	  /**
	   * working directory path
	   */
	  private String work_dir;
	  
}
