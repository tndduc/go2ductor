package com.duck.go2ductor.dao;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {
	@NotBlank
	private String UserType;
	@NotBlank
	private String username;

	@NotBlank
	private String password;
}