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

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
public class Job implements Serializable {

  private static final long serialVersionUID = 4299892262923776798L;

  /**
   * job identifier
   */
  private String id;
  
  /**
   * job's attributes
   */
  private Map<String,String> attributes; 
  
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
   * short's user's description
   */
  private String note;
  
  /**
   * 
   */
  private JobDescription description;
  
  /**
   * currenlty ongoing operation start 
   * string($date-time)
   */
  private String operation_start;
  
  /**
   * Uri
   */
  private String resource;
  
  /**
   * scheduling queue/partiontion job is submited
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
   * schedulilng system identifier
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
   * total number of used CPUs
   */
  private Integer cpus;
  
  /**
   * application exit code
   */
  private Integer exit_code;
  
  /**
   * error messages
   */
  private String errors;
  
  /**
   * number of times job was submitted to scheduling system
   */
  private Integer resubmit;
  
  /**
   * working directory path
   */
  private String work_dir;
  
  /**
   * does the working directory has been created for the job
   */
  private Boolean created_work_dir;
  
  /**
   * time job was last seen in scheduling system
   * string($date-time)
   */
  private String last_seen;
  
  
  public Job() {
	  attributes = null;
	  description = null;
	  cpus = null;
	  exit_code = null;
	  resubmit = null;
	  created_work_dir = null;
  }
   
}