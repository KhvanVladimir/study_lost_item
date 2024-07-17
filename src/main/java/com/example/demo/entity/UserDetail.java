package com.example.demo.entity;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="users")
public class UserDetail implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3786895188444661441L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Column(name = "username")
	String username;
	
	@Column(name = "password")
	String password;
	
	@Column(name = "role")
	String role;
	
	@Column(name = "phone")
	String phone;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "age")
	String age;
	
	@Column(name = "gender")
	String gender;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
	}
	
	
}
