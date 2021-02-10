package com.webonise.user_authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webonise.user_authentication.Repository.UserRepository;
import com.webonise.user_authentication.models.AuthenticationRequest;
import com.webonise.user_authentication.models.AuthenticationResponse;
import com.webonise.user_authentication.models.UserModel;

@RestController
public class AuthenticationController{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/auth")
	private ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest){
		String username=authenticationRequest.getUsername();
		String password=authenticationRequest.getPassword();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}catch(BadCredentialsException e) {
			return new ResponseEntity("Username or Password Incorrect.",HttpStatus.FORBIDDEN);
		}
		return ResponseEntity.ok(new AuthenticationResponse("Successfully logged in. Welcome "+username));
		
	}
	
	
	@PostMapping("/register")
	private ResponseEntity<?> registerUser(@RequestBody AuthenticationRequest authenticationRequest){
		String username =  authenticationRequest.getUsername();
		String password = authenticationRequest.getPassword();
		UserModel userModel = new UserModel();
		userModel.setUsername(username);
		userModel.setPassword(password);
		
		try {
			userRepository.save(userModel);
		}catch(Exception e) {
			return new ResponseEntity("Username already exists.",HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(new AuthenticationResponse("Registration successful for " + username));
	}

}
