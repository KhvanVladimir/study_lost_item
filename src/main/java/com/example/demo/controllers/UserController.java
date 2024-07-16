package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserDetail;
import com.example.demo.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserServiceImpl userService;
	
    @GetMapping
    public List<UserDetail> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDetail getUserById(@PathVariable(name="id", required = true) Long id) {
        return userService.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    @PostMapping
    public UserDetail createUser(@RequestBody UserDetail user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public UserDetail updateUser(@PathVariable(name="id", required = true) Long id, @RequestBody UserDetail userDetails) {
    	UserDetail user = userService.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    	user.setAge(userDetails.getAge() != null ? userDetails.getAge() : user.getAge());
    	user.setEmail(userDetails.getEmail() != null ? userDetails.getEmail() : user.getEmail());
    	user.setGender(userDetails.getGender() != null ? userDetails.getGender() : user.getGender()); // haha
    	user.setPassword(userDetails.getPassword() != null ? userDetails.getPassword() : user.getPassword());
    	user.setPhone(userDetails.getPhone() != null ? userDetails.getPhone() : user.getPhone());
    	user.setUsername(userDetails.getUsername() != null ? userDetails.getUsername() : user.getUsername());
    	
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name="id", required = true) Long id) {
        userService.deleteById(id);
    }
	
}
