package com.friendsbook.functional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaServer
@ComponentScan(basePackages = {"com.friendsbook"})
public class FriendsBookEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FriendsBookEurekaServerApplication.class, args);
	}

}
