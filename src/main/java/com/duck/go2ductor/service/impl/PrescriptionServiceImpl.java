package com.duck.go2ductor.service.impl;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.dao.PrescriptionRequest;
import com.duck.go2ductor.entity.Appointment;
import com.duck.go2ductor.entity.MedicalHistory;
import com.duck.go2ductor.entity.Medicine;
import com.duck.go2ductor.entity.Prescription;
import com.duck.go2ductor.repository.MedicalHistoryRepository;
import com.duck.go2ductor.repository.MedicineRepository;
import com.duck.go2ductor.repository.PhysicianRepository;
import com.duck.go2ductor.repository.PrescriptionRepository;
import com.duck.go2ductor.service.PrescriptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/25/2023
 */
@Service
@Transactional
@Slf4j
public class    PrescriptionServiceImpl implements PrescriptionService {
    @Autowired
    PrescriptionRepository prescriptionRepository;
    @Autowired
    MedicalHistoryRepository medicalHistoryRepository;
    @Autowired
    MedicineRepository medicineRepository;

    @Override
    public ResponseEntity<Prescription> addPrescription(PrescriptionRequest prescriptionRequest) {
        Prescription prescription = new Prescription();
        MedicalHistory medicalHistory = medicalHistoryRepository.findById(prescriptionRequest.getId_medicalHistory()).orElse(null);
        Medicine medicine = medicineRepository.findById(prescriptionRequest.getId_medicine()).orElse(null);
        prescription.setMedicine(medicine);
        prescription.setPrice(medicine.getPrice());
        prescription.setAmount(prescriptionRequest.getAmount());
        prescription.setMedical_history(medicalHistory);
        prescription.setDosage(prescriptionRequest.getDosage());
        Prescription prescriptionNew = prescriptionRepository.save(prescription);
        return new ResponseEntity<>(prescriptionNew, HttpStatus.CREATED);
    }

    @Override
    public ApiResponse editPrescription(PrescriptionRequest prescriptionRequest) {
        Prescription prescription = new Prescription();
        MedicalHistory medicalHistory = medicalHistoryRepository.findById(prescriptionRequest.getId_medicalHistory()).orElse(null);
        Medicine medicine = medicineRepository.findById(prescriptionRequest.getId_medicine()).orElse(null);
        prescription.setId(prescriptionRequest.getId());
        prescription.setMedicine(medicine);
        prescription.setPrice(medicine.getPrice());
        prescription.setAmount(prescriptionRequest.getAmount());
        prescription.setMedical_history(medicalHistory);
        prescription.setDosage(prescriptionRequest.getDosage());
        Prescription prescriptionNew = prescriptionRepository.save(prescription);
        if (prescriptionNew.getId()!= prescriptionRequest.getId()) {
            ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, "Failed to update prescription status with id :"+prescriptionNew.getId());
            return apiResponse;
        }
        return new ApiResponse(Boolean.TRUE, "Successfully updated for prescription with id :"+prescriptionNew.getId());

    }

    @Override
    public List<Prescription> getByMedicalHistory(Long idMedicalHistory) {
        return prescriptionRepository.findByIdMedicalHistory(idMedicalHistory);
    }

    @Override
    public ApiResponse deletePrescription(Long prescriptionId) {
        prescriptionRepository.deleteById(prescriptionId);
        Optional<Prescription> prescription = prescriptionRepository.findById(prescriptionId);
        if (prescription.isPresent()) {
            ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, "Failed to delete prescription status with id :"+prescriptionId);
            return apiResponse;
        }
        return new ApiResponse(Boolean.TRUE, "Successfully delete for prescription with id :"+prescriptionId);
    }

    @Override
    public List<Prescription> getAll() {
        return prescriptionRepository.findAll();
    }

}
