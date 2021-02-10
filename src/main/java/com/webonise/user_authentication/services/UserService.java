package com.webonise.user_authentication.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.webonise.user_authentication.Repository.UserRepository;
import com.webonise.user_authentication.models.UserModel;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userFound = userRepository.findByUsername(username);
		if(userFound==null) {
			return null;
		}
		String username1 = userFound.getUsername();
		String password1 = userFound.getPassword();
		return new User(username1,password1,new ArrayList<>());
		
	}
	
}
