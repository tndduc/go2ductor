package com.duck.go2ductor.service.impl;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.dao.UserIdentityAvailability;
import com.duck.go2ductor.dao.UserProfile;
import com.duck.go2ductor.dao.UserSummary;
import com.duck.go2ductor.service.UserService;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
public class PhysicianServiceImpl implements UserService {
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
}
