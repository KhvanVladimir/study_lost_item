package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.UserDetail;
import com.example.demo.mappers.UtilMapper;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	@Autowired
	UtilMapper utilMapper;
	
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

	public List<UserDTO> findAll() {
		List<UserDetail> usersDetail = userRepository.findAll();
		return usersDetail.stream().map(x -> utilMapper.toUserDTO(x)).toList();
	}

	public UserDTO findById(Long id) {
		UserDTO result = null;
		Optional<UserDetail> userDetail = userRepository.findById(id);
		if (!userDetail.isEmpty()) {
			result = utilMapper.toUserDTO(userDetail.get());
		}
		return result;
	}

	public Optional<UserDetail> findUserDetailById(Long id) {
		return userRepository.findById(id);
	}

	public UserDTO save(UserDTO user) {
		UserDetail result = userRepository.saveAndFlush(utilMapper.toUserDetail(user));
		return utilMapper.toUserDTO(result);
	}

	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	public UserDTO changeUserDetail(UserDetail userDetail, UserDTO changedUser) {
		UserDTO result = utilMapper.compareAndEdit(userDetail, changedUser);
		return save(result);
	}
	
	
	
	
	
	
}
