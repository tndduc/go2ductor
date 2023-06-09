package com.duck.go2ductor.service;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.dao.PatientDAO;
import com.duck.go2ductor.entity.Patient;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
public interface PatientService {
    Patient getUserProfile(String username);
    PatientDAO getUserDAOProfile(String username);
    ApiResponse addPatient(Patient patient);
    ApiResponse updatePatient(Patient patient);
}
