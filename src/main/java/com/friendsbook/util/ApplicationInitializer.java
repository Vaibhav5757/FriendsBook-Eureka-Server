package com.friendsbook.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.friendsbook.functional.UserServiceClient;

@Component
public class ApplicationInitializer implements CommandLineRunner{
	
	
	@Autowired
	private UserServiceClient userClient;
	
	private Logger logger = LoggerFactory.getLogger(ApplicationInitializer.class);

	@Override
	public void run(String... args) throws Exception {
		logger.info("Eureka Server Initialized");
		try {
			String resp =  this.userClient.wakeUp();
			if(resp != null)
				logger.info("User Service woke up");
		}catch (Exception err) {
			logger.error(err.getMessage());
		}
	}

}
