package com.cts.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.authorization.exception.AuthorizationException;
import com.cts.authorization.model.User;
import com.cts.authorization.service.userService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping(value="/api/v1")

public class UserController {
	@Autowired
	userService userService;
	@PostMapping(value="addUser")
	public ResponseEntity<Boolean> addUser(@RequestBody User user) throws AuthorizationException{
		try {
		userService.addUser(user);
		}
		catch(Exception e){
			throw new AuthorizationException("Bad Credentials");
		}
		return ResponseEntity.ok(true);
	}
}
