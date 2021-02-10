package com.webonise.user_authentication.models;

public class AuthenticationRequest {
	private String username;
	private String password;
	
	protected AuthenticationRequest() {
		
	}
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
