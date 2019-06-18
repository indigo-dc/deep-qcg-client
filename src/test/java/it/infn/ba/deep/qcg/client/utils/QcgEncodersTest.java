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
