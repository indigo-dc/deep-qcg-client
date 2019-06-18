package it.infn.ba.deep.qcg.client.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.FeignException;
import feign.Response;
import it.infn.ba.deep.qcg.client.model.Job;

public class QcgDecodersTest {
	 @Before
	  public void setup() throws IOException {

	  }
	  
	  @Test
	  public void testJobDecoder() {
		Job jobsrc = QcgTestUtils.buildJob("999");  
    	ObjectMapper mapper = new ObjectMapper();
    	mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		byte[] serialized = null;
		try {
			serialized = mapper.writeValueAsBytes(jobsrc);
		} catch (JsonProcessingException e) {
		}
		if (serialized != null) {
			Map<String,Collection<String>> headers = new HashMap<String,Collection<String>>();
			Response response = Response.create(200, "", headers, serialized);
		
			QcgDecoder decoder = new QcgDecoder();
			Job jobdst = null;
			try {
				jobdst = (Job) decoder.decode(response, Job.class);
			} catch (FeignException | IOException e) {
			}
			assertThat(jobsrc).isEqualTo(jobdst);
		} else {
			fail("Cannot serialize Job");			
		}
	  }
}
