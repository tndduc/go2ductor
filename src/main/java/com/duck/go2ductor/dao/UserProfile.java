package com.duck.go2ductor.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class UserProfile {
    private Long id;
    private String user_name;
    private String first_name;
    private String last_name;
    private String id_card;
    private String image;
    private String phone;
    private String sex;
    private LocalDate dob;
}
