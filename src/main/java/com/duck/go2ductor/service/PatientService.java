package com.duck.go2ductor.service;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.entity.Patient;
import com.duck.go2ductor.dao.SignUpRequest;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
public interface PatientService {
    Patient addPatient(Patient patient);
    ApiResponse deletePatient(String username);
    ApiResponse updatePatient(String username,Patient patient);
}
