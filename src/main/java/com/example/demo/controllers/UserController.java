package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.UserDetail;
import com.example.demo.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserServiceImpl userService;
	
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable(name="id", required = true) Long id) {
    	UserDTO res = userService.findById(id);
        if(res == null) {
        	throw new RuntimeException("User not found with id " + id);
        }
        return res;
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable(name="id", required = true) Long id, @RequestBody UserDTO userDetails) {
    	Optional<UserDetail> user = userService.findUserDetailById(id);   
    	if(user.isEmpty()) {
        	throw new RuntimeException("User not found with id " + id);
    	}
    	return userService.changeUserDetail(user.get(), userDetails);
         
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name="id", required = true) Long id) {
        userService.deleteById(id);
    }
	
}
