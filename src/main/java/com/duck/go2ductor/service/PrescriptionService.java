package com.duck.go2ductor.service;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.dao.PrescriptionRequest;
import com.duck.go2ductor.entity.Prescription;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/14/2023
 */
public interface PrescriptionService {
    ResponseEntity<Prescription> addPrescription(PrescriptionRequest prescription);
    ApiResponse editPrescription(PrescriptionRequest prescription);
    List<Prescription> getByMedicalHistory(Long idMedicalHistory);
    ApiResponse deletePrescription(Long prescriptionId);
    List<Prescription> getAll();
}
