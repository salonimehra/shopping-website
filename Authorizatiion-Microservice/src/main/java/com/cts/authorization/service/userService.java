package com.cts.authorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.authorization.model.User;
import com.cts.authorization.repository.UserDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class userService {
	@Autowired
	UserDao userRepo;
	public boolean addUser(User user) {
		userRepo.save(user);
		return true;
	}
}
