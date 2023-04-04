package com.duck.go2ductor.service;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.dao.UserIdentityAvailability;
import com.duck.go2ductor.dao.UserProfile;
import com.duck.go2ductor.dao.UserSummary;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
public interface UserService {
    UserProfile getUserProfile(String username);
    UserIdentityAvailability checkUsernameAvailability(String username);
    UserIdentityAvailability checkIDCardAvailability(String id_card);
    UserSummary getCurrentUser(String username);
    ApiResponse deleteUser(String username);
}
