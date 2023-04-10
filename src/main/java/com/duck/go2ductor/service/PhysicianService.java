package com.duck.go2ductor.service;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.dao.LoginRequest;
import com.duck.go2ductor.dao.PhysicianDAO;
import com.duck.go2ductor.dao.UserIdentityAvailability;
import com.duck.go2ductor.entity.Physician;

import java.util.Optional;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
public interface PhysicianService {
    Physician getUserProfile(String username);
    PhysicianDAO getUserDAOProfile(String username);
    ApiResponse addPhysician(Physician physician);
    ApiResponse updatePhysician(Physician physician);

    UserIdentityAvailability checkAuthentication(LoginRequest loginRequest);


}
