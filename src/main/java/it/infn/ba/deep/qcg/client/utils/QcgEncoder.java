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

package it.infn.ba.deep.qcg.client.utils;

import java.lang.reflect.Type;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static java.lang.String.format;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import it.infn.ba.deep.qcg.client.model.Job;
import it.infn.ba.deep.qcg.client.model.JobDescription;

public class QcgEncoder implements Encoder {

	@Override
	public void encode(Object object, Type bodyType, RequestTemplate template) {
		if (bodyType == String.class) {
		    template.body(object.toString());
		} else if (bodyType == byte[].class) {
		    template.body((byte[]) object, null);
		} else if ( bodyType == JobDescription.class ||				
					bodyType == Job.class) {
			String serialized = null;
		    try {
		    	ObjectMapper mapper = new ObjectMapper();
		    	mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
				serialized = mapper.writeValueAsString(object);
				template.body(serialized);
			} catch (JsonProcessingException e) {
				throw new EncodeException(
						format("Error %s serializing %s.", e.getMessage(), object.getClass()));
			}	    		    
		} else if (object != null) {
		    throw new EncodeException(
		        format("%s is not a type supported by this encoder.", object.getClass()));
		}
	}

}
