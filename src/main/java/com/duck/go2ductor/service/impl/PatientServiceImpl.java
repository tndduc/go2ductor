package com.duck.go2ductor.service.impl;

import com.duck.go2ductor.dao.*;
import com.duck.go2ductor.entity.Patient;
import com.duck.go2ductor.repository.PatientRepository;
import com.duck.go2ductor.service.PatientService;
import com.duck.go2ductor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Service
public class PatientServiceImpl implements UserService, PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient getUserProfile(String username) {
        return patientRepository.findByUsername(username);
    }

    @Override
    public UserIdentityAvailability checkUsernameAvailability(String username) {
        return null;
    }

    @Override
    public UserIdentityAvailability checkIDCardAvailability(String id_card) {
        return null;
    }


    @Override
    public ApiResponse deleteUser(String username) {
        return null;
    }


    @Override
    public Patient addPatient(Patient patient) {
        return null;
    }



    @Override
    public ApiResponse updatePatient(String username, Patient patient) {
        return null;
    }


}
