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

import java.io.IOException;
import java.lang.reflect.Type;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.codec.StringDecoder;
import it.infn.ba.deep.qcg.client.model.Job;
import it.infn.ba.deep.qcg.client.model.JobDescription;

public class QcgDecoder implements Decoder {

	@Override
	public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
		if (response.status() == 404 || response.status() == 204)
	        return Util.emptyValueOf(type);	
	    if (response.body() == null)
	        return null;		
		if (type == Job.class) {
			ObjectMapper mapper = new ObjectMapper();
			Job job = mapper.readValue(Util.toString(response.body().asReader()), Job.class);
			return job;
		}
		else if (type == JobDescription.class) {
			ObjectMapper mapper = new ObjectMapper();
			JobDescription description = mapper.readValue(Util.toString(response.body().asReader()), JobDescription.class);
			return description;
		} else {
			if (byte[].class.equals(type)) {
		        return Util.toByteArray(response.body().asInputStream());
   	        }
			return (new StringDecoder()).decode(response, type);
		}
	}

}


