package com.duck.go2ductor.service;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.entity.Physician;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
public interface PhysicianService {
    Physician addPhysician(Physician physician);
    ApiResponse deletePhysician(String username);
    ApiResponse updatePhysician(String username, com.duck.go2ductor.entity.Physician patient);
}
