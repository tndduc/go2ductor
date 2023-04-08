package com.duck.go2ductor.service;

import com.duck.go2ductor.dao.*;

import java.util.Optional;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
public interface UserService {

    UserIdentityAvailability checkUsernameAvailability(String username);
    UserIdentityAvailability checkIDCardAvailability(String id_card);
    ApiResponse deleteUser(String username);
}
