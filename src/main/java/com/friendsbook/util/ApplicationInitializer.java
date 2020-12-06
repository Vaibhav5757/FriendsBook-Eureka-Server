package com.friendsbook.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApplicationInitializer implements CommandLineRunner{
	
	@Autowired
	private RestTemplate http;
	
	@Value("${external-service-url.user-service}")
	private String userServiceUrl;
	
	@Value("${external-service-url.front-end}")
	private String frontEndSvcUrl;
	
	private Logger logger = LoggerFactory.getLogger(ApplicationInitializer.class);
	

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("Application Started - Now running application initialization logic");
		
		try {
			
			logger.info(userServiceUrl);
			logger.info(frontEndSvcUrl);
			
			logger.info("Trying to wake up User Service");
			// wake up user Service
			this.http.exchange(userServiceUrl + "/wake-up", HttpMethod.GET, null, String.class);
			
			logger.info("Trying to wake up Front End Service");
			// wake up front end Service
			this.http.exchange(frontEndSvcUrl+ "/wake-up", HttpMethod.GET, null, String.class);
		}catch(Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
