package it.infn.ba.deep.qcg.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import it.infn.ba.deep.qcg.client.utils.QcgException;

public class QcgClientTest {
	
	private Properties properties;	
	@SuppressWarnings("unused")
	private Qcg qcg;
	
	@Before
	public void setup() throws IOException {
		properties = new Properties();
		InputStream in = getClass().getResourceAsStream("application.properties");
	    properties.load(in);
	    in.close();
	}
	  

	@Test
	public void testCreateClientWithTokenAuth() throws QcgException {
	    qcg = QcgClient.getInstanceWithTokenAuth(
	    		properties.getProperty("tokenAuthJobTest.endpoint"),
		        properties.getProperty("tokenAuthJobTest.token")
		      );
	}	  
	
	@Test
	public void testCreateClientWithBasicAuth() throws QcgException {
		qcg = QcgClient.getInstanceWithBasicAuth(
				properties.getProperty("basicAuthJobTest.endpoint"),
		        properties.getProperty("basicAuthJobTest.username"), 
		        properties.getProperty("basicAuthJobTest.password")
		      );		
	}
}
