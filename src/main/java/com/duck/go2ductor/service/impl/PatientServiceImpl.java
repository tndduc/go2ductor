package com.duck.go2ductor.service.impl;

import com.duck.go2ductor.dao.*;
import com.duck.go2ductor.entity.Patient;
import com.duck.go2ductor.entity.Physician;
import com.duck.go2ductor.repository.PatientRepository;
import com.duck.go2ductor.repository.PhysicianRepository;
import com.duck.go2ductor.service.PatientService;
import com.duck.go2ductor.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Service
@Slf4j
@Transactional
public class PatientServiceImpl implements UserService, PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PhysicianRepository physicianRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Patient getUserProfile(String username) {
        return patientRepository.findByUsername(username);
    }

    @Override
    public PatientDAO getUserDAOProfile(String username) {
        ModelMapper modelMapper = new ModelMapper();
        Patient patient = patientRepository.findByUsername(username);
        PatientDAO patientDAO = modelMapper.map(patient,PatientDAO.class);
        return null;
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
    public ApiResponse addPatient(Patient patient) {
        Patient patient1 = patientRepository.findByUsername(patient.getUsername());
        Physician physician = physicianRepository.findByUsername(patient.getUsername());
        if (physician == null && patient1 == null){
            patient.setPassword(passwordEncoder.encode(patient.getPassword()));
            patientRepository.save(patient);
            return new ApiResponse(Boolean.TRUE, "Successfully add physician with user :"+patient.getUsername());
        }
        return new ApiResponse(Boolean.FALSE, "Failed to add physician with user :"+patient.getUsername());

    }



    @Override
    public ApiResponse updatePatient( Patient patient) {
        Patient patient1 = patientRepository.findByUsername(patient.getUsername());
        Physician physician = physicianRepository.findByUsername(patient.getUsername());
        if (physician == null && patient1 == null){
            patient.setPassword(passwordEncoder.encode(patient.getPassword()));
            patientRepository.save(patient);
            return new ApiResponse(Boolean.TRUE, "Successfully add physician with user :"+patient.getUsername());
        }
        return new ApiResponse(Boolean.FALSE, "Failed to add physician with user :"+patient.getUsername());

    }


}
