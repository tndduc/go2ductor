package com.duck.go2ductor.dao;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RegisterRequest {
	@NotBlank
	@Size(min = 4, max = 40)
	private String firstName;

	@NotBlank
	@Size(min = 4, max = 40)
	private String lastName;

	@NotBlank
	@Size(min = 3, max = 15)
	private String username;


	@NotBlank
	@Size(min = 6, max = 20)
	private String password;
	@NotBlank
	private String UserType;
}
