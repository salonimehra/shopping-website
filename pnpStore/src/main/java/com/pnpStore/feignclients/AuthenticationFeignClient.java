package com.pnpStore.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pnpStore.model.JwtResponse;



@FeignClient(name = "authorization-service", url = "http://localhost:8084")
public interface AuthenticationFeignClient {

	@GetMapping(path = "/api/auth/validate")
	JwtResponse verifyToken(@RequestHeader(name = "Authorization", required = true) String token);

}
