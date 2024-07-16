package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserDetail;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService{

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

	public List<UserDetail> findAll() {
		return userRepository.findAll();
	}

	public Optional<UserDetail> findById(Long id) {
		return userRepository.findById(id);
	}

	public UserDetail save(UserDetail user) {
		return userRepository.saveAndFlush(user);
	}

	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
	
	
	
	
	
	
}
