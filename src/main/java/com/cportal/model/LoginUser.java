package com.cportal.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginUser {
	
	@NotEmpty @Size(min=2, max=30)
	private String username;
	
	@NotEmpty @Size(min=2, max=30)
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
