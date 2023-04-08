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
public class PatientDAO extends UserProfile{
    private String note;
    private String health_insurance;
}
