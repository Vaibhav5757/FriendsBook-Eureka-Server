package com.friendsbook.util;

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

	@Override
	public void run(String... args) throws Exception {
		// wake up user Service
		this.http.exchange(userServiceUrl, HttpMethod.GET, null, Object.class);
		
		// wake up front end Service
		this.http.exchange(frontEndSvcUrl, HttpMethod.GET, null, Object.class);
	}

}
