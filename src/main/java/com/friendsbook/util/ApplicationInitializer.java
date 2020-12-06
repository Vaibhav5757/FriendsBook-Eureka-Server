package com.friendsbook.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.friendsbook.functional.UserServiceClient;

@Component
public class ApplicationInitializer implements CommandLineRunner{
	
	@Value("${external-service-url.user-service}")
	private String userServiceUrl;
	
	@Value("${external-service-url.front-end}")
	private String frontEndSvcUrl;
	
	@Autowired
	private UserServiceClient userClient;
	
	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(ApplicationInitializer.class);

	@Override
	public void run(String... args) throws Exception {
		logger.info("Eureka Server Initialized");
		this.userClient.wakeUp();
	}

}
