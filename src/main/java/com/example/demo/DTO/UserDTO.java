package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	Long id;
	String username;
	String password;
	String role;
	String phone;
	String email;
	String age;
	String gender;
	
}
