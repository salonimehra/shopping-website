package com.cart.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="Authorizatiion-Microservice",url="localhost:8084/auth/api/v1/")
public interface AuthenticationFeignClient {

	@PostMapping(value = "/authorize")
	public boolean authorizeTheRequest(@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) ;
}
