package com.friendsbook.functional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "${external-user-service}", name = "User-Service")
public interface UserServiceClient {

	@GetMapping("/wake-up")
	public String wakeUp();
}
