package com.webonise.user_authentication.models;

public class AuthenticationResponse {
	private String response;
	
	public AuthenticationResponse(String response) {
		this.response = response;
	}

	protected AuthenticationResponse() {

	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}


	
}
