package com.duck.go2ductor.service;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.entity.Prescription;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/14/2023
 */
public interface PrescriptionService {
    ApiResponse addPrescription(Prescription prescription);
    ApiResponse editPrescription(Prescription prescription);

    ApiResponse deletePrescription(Prescription prescription);
}
