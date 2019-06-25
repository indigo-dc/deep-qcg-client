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

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;

public class QcgDecoder implements Decoder {

	@Override
	public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
		if (response.status() == 404 || response.status() == 204)
	        return Util.emptyValueOf(type);	
	    if (response.body() == null)
	        return null;	
	    if (byte[].class.equals(type)) 
	        return Util.toByteArray(response.body().asInputStream());
	    if (String.class.equals(type)) 
	        return Util.toString(response.body().asReader());
	    
		ObjectMapper mapper = new ObjectMapper();
	    JavaType t = mapper.getTypeFactory().constructType(type);
		return mapper.readValue(Util.toString(response.body().asReader()), t);
	}

}


