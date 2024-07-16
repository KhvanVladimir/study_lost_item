package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserDetail;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetail user = userRepository.findByUsername(username);
		if(user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(
	            user.getUsername(), 
	            user.getPassword(), 
	            user.isEnabled(), 
	            user.isAccountNonExpired(),
	            user.isCredentialsNonExpired(),
	            user.isAccountNonLocked(),
	            user.getAuthorities());
	}
	
	
	
}
