package com.duck.go2ductor.service.impl;

import com.duck.go2ductor.dao.*;
import com.duck.go2ductor.entity.Physician;
import com.duck.go2ductor.service.PhysicianService;
import com.duck.go2ductor.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Service
public class PhysicianServiceImpl implements UserService, PhysicianService {
    @Override
    public UserProfile getUserProfile(String username) {
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
    public UserSummary getCurrentUser(String username) {
        return null;
    }

    @Override
    public ApiResponse deleteUser(String username) {
        return null;
    }


    @Override
    public Physician addPhysician(Physician physician) {
        return null;
    }

    @Override
    public ApiResponse deletePhysician(String username) {
        return null;
    }

    @Override
    public ApiResponse updatePhysician(String username, Physician patient) {
        return null;
    }
}
