package com.cts.authorization.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserLoginCredential implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String userName;
	private String password;
	
	public UserLoginCredential()
	{
		
	}

	public UserLoginCredential(String userName, String password) {
		this.setUserName(userName);
		this.setPassword(password);
	}
}