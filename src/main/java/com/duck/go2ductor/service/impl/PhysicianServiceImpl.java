package com.duck.go2ductor.service.impl;

import com.duck.go2ductor.dao.*;
import com.duck.go2ductor.entity.Patient;
import com.duck.go2ductor.entity.Physician;
import com.duck.go2ductor.repository.PatientRepository;
import com.duck.go2ductor.repository.PhysicianRepository;
import com.duck.go2ductor.service.PhysicianService;
import com.duck.go2ductor.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Service

@Transactional
@Slf4j
public class PhysicianServiceImpl implements UserService, PhysicianService {
    @Autowired
    private PhysicianRepository physicianRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private Environment env;
    @Override
    public Physician getUserProfile(String username) {
        return physicianRepository.findByUsername(username);
    }

    @Override
    public PhysicianDAO getUserDAOProfile(String username) {
        ModelMapper modelMapper = new ModelMapper();
        Physician physician = physicianRepository.findByUsername(username);
        PhysicianDAO physicianDAO = modelMapper.map(physician,PhysicianDAO.class);
        String ipAddress = env.getProperty("server.address");
        physicianDAO.setImage(ipAddress+":8080/api/images/"+physicianDAO.getImage());
        return physicianDAO;
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
    public ApiResponse addPhysician(Physician physician) {
        Physician physician1 = physicianRepository.findByUsername(physician.getUsername());
        Patient patient = patientRepository.findByUsername(physician.getUsername());
        if (physician1 == null && patient == null){
            physician.setPassword(passwordEncoder.encode(physician.getPassword()));
            physicianRepository.save(physician);
            return new ApiResponse(Boolean.TRUE, "Successfully add physician with user :"+physician.getUsername());
        }
        return new ApiResponse(Boolean.FALSE, "Failed to add physician with user :"+physician.getUsername());

    }

    @Override
    public ApiResponse updatePhysician(Physician physician) {
        Physician physician1 = physicianRepository.findByUsername(physician.getUsername());
        Patient patient = patientRepository.findByUsername(physician.getUsername());
        if (physician1 == null && patient == null){
            physician.setPassword(passwordEncoder.encode(physician.getPassword()));
            physicianRepository.save(physician);
            return new ApiResponse(Boolean.TRUE, "Successfully update physician with user :"+physician.getUsername());
        }
        return new ApiResponse(Boolean.FALSE, "Failed to update physician with user :"+physician.getUsername());

    }

    @Override
    public UserIdentityAvailability checkAuthentication(LoginRequest loginRequest) {
        return null;
    }


}
