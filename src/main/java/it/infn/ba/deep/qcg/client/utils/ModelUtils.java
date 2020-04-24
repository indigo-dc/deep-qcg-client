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

package it.infn.ba.deep.qcg.client.utils;

import static java.lang.String.format;

import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import it.infn.ba.deep.qcg.client.model.Job;
import it.infn.ba.deep.qcg.client.model.JobDescription;

public class ModelUtils {
	
  public static final Gson GSON =
      new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

  public static String toString(Object o) {
    return GSON.toJson(o);
  }
    
  public static boolean isNullOrEmpty(String str) {
  	if(str != null && !str.isEmpty())
  		return false;
  	return true;
  }    
  
  public static boolean isNullOrEmpty(String str, boolean allowNulls) {
	  if(str == null && allowNulls)
		  return false;
	  if(str != null && !str.isEmpty())
	  		return false;
	  return true;
  }    
	    
  public static String nat(JsonNode value) {
	  String result = value.asText();
	  if (result.equals("null"))
		  return null;
	  return result;
  }

  public static Integer nai(JsonNode value) {
	  String result = value.asText();
	  if (result.equals("null"))
		  return null;
	  return value.asInt();
  }
  
  public static Double nad(JsonNode value) {
	  String result = value.asText();
	  if (result.equals("null"))
		  return null;
	  return value.asDouble();
  }
  
  public static Boolean nab(JsonNode value) {
	  String result = value.asText();
	  if (result.equals("null"))
		  return null;
	  return value.asBoolean();
  }
  
  @SuppressWarnings("unchecked")
  public static void updateJob(Job src, Job dst) throws QcgException {
	  
	  if (src == null)
		  throw new QcgException("updateJob: src is null");
	  
	  if (dst == null)
		  throw new QcgException("updateJob: dst is null");
	  
	  dst.setId(src.getId());
	  
      if (src.getAttributes() != null)
    	  dst.setAttributes((HashMap<String,String>)((HashMap<String, String>)src.getAttributes()).clone());
      else
    	  dst.setAttributes(null);
	  
	  dst.setUser(src.getUser());
	  dst.setState(src.getState());
	  dst.setOperation(src.getOperation());
	  dst.setNote(src.getNote());
	  
	  //CLONE BY SERIALIZATION/DESERIALIZATION
	  if (src.getDescription() != null) {
		  String serialized = null;
		  try {
			  ObjectMapper mapper = new ObjectMapper();
			  mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			  serialized = mapper.writeValueAsString(src.getDescription());
			  JobDescription description = mapper.readValue(serialized, JobDescription.class);
			  dst.setDescription(description);
		} catch (IOException e) {
			throw new QcgException(
					format("Error %s serializing %s.", e.getMessage(), src.getDescription().getClass()));
		}		  
	  } else {
		  dst.setDescription(null);
	  }
	  
	  dst.setOperation_start(src.getOperation_start());
	  dst.setResource(src.getResource());
	  dst.setQueue(src.getQueue());
	  dst.setLocal_user(src.getLocal_user());
	  dst.setLocal_group(src.getLocal_group());
	  dst.setLocal_id(src.getLocal_id());
	  dst.setSubmit_time(src.getSubmit_time());
	  dst.setStart_time(src.getStart_time());
	  dst.setFinish_time(src.getFinish_time());
	  dst.setUpdated_time(src.getUpdated_time());
	  dst.setEta(src.getEta());
	  dst.setNodes(src.getNodes());
	  dst.setCpus(src.getCpus());
	  dst.setErrors(src.getErrors());
	  dst.setExit_code(src.getExit_code());
	  dst.setResubmit(src.getResubmit());
	  dst.setWork_dir(src.getWork_dir());
	  dst.setCreated_work_dir(src.getCreated_work_dir());
	  dst.setLast_seen(src.getLast_seen());
  }
}
