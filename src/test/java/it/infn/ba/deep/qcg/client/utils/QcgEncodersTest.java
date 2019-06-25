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

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

//import com.fasterxml.jackson.databind.ObjectMapper;

import feign.RequestTemplate;
//import feign.Util;
import it.infn.ba.deep.qcg.client.model.Job;

public class QcgEncodersTest {
	
	  @Before
	  public void setup() throws IOException {

	  }
	  
	  @Test
	  public void testJobEncoder() {
		Job jsrc = QcgTestUtils.buildJob("999");  
		RequestTemplate template = new RequestTemplate();
		QcgEncoder encoder = new QcgEncoder();
		encoder.encode(jsrc, Job.class, template);
		
		ByteArrayInputStream in = new ByteArrayInputStream(template.body());
		ObjectMapper mapper = new ObjectMapper();
		Job jdst = null;
		try {
			jdst = mapper.readValue(in, Job.class);
		} catch (IOException e) {
		}
		
	    assertThat(jsrc).isEqualTo(jdst);
		
	  }
	  
}
