package com.duck.go2ductor.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhysicianDAO extends UserProfile{
    private String education;
    private String specialization;
    private String experience;
}
