package com.duck.go2ductor.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSummary {
	private Long id;
	private String username;
	private String firstName;
	private String lastName;
}
