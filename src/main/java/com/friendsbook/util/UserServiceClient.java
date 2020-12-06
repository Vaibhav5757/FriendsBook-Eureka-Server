package com.friendsbook.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "https://friendsbook-user-service.herokuapp.com/", name = "User-Service")
public interface UserServiceClient {

	@GetMapping("/wake-up")
	public String wakeUp();
}
