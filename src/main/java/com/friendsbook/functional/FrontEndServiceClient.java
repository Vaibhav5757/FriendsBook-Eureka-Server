package com.friendsbook.functional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "${external-front-end-service.ribbon.listOfServers}", name = "Front-End-Service")
public interface FrontEndServiceClient {

	@GetMapping("/wake-up/")
	public String wakeUp();
}
