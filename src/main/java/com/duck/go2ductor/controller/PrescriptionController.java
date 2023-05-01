package com.duck.go2ductor.controller;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.dao.PrescriptionRequest;
import com.duck.go2ductor.entity.Prescription;
import com.duck.go2ductor.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/25/2023
 */
@RestController
@RequestMapping("/api/prescription")
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping("/get")
    public List<Prescription> getAll(){
        return prescriptionService.getAll();
    }
    @GetMapping("/get-by-medical_history-id")
    private List<Prescription> getById(@RequestParam Long idMedical){
        return prescriptionService.getByMedicalHistory(idMedical);
    }
    @PutMapping("/update")
    public ApiResponse update(PrescriptionRequest prescriptionRequest){
        return prescriptionService.editPrescription(prescriptionRequest);
    }
    @PostMapping("/add")
    public ResponseEntity<Prescription> add(PrescriptionRequest prescriptionRequest){
        return prescriptionService.addPrescription(prescriptionRequest);
    }
    @DeleteMapping("/delete")
    public ApiResponse delete(Long prescriptionId){
        return prescriptionService.deletePrescription(prescriptionId);
    }
}
