package com.cportal.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class EditUser {
	
	@NotEmpty @Email
	private String personEmail;
	
	@Size(min=2, max=30) @NotEmpty
	private String personName;
	
	@Size(min=2, max=30) @NotEmpty
	private String personPassword;
	
	@Email
	private String personManager;
	
	private String personRole;
	
	@NotEmpty
	private String personDesignation;
	public String getPersonEmail() {
		return personEmail;
	}
	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonPassword() {
		return personPassword;
	}
	public void setPersonPassword(String personPassword) {
		this.personPassword = personPassword;
	}
	public String getPersonManager() {
		return personManager;
	}
	public void setPersonManager(String personManager) {
		this.personManager = personManager;
	}
	public String getPersonRole() {
		return personRole;
	}
	public void setPersonRole(String personRole) {
		this.personRole = personRole;
	}
	public String getPersonDesignation() {
		return personDesignation;
	}
	public void setPersonDesignation(String personDesignation) {
		this.personDesignation = personDesignation;
	}

}
