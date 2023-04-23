package com.duck.go2ductor.service.impl;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.dao.MedicalHistoryRequest;
import com.duck.go2ductor.dao.PrescriptionRequest;
import com.duck.go2ductor.entity.*;
import com.duck.go2ductor.repository.*;
import com.duck.go2ductor.service.MedicalHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.*;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/15/2023
 */
@Service
@Slf4j
public class MedicalHistoryServiceImpl implements MedicalHistoryService {
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PhysicianRepository physicianRepository;
    @Autowired
    private PrescriptionRepository prescriptionRepository;
    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    @Transactional
    public ApiResponse addHistory(MedicalHistoryRequest medicalHistoryRequest) {
        MedicalHistory medicalHistory = new MedicalHistory();
        Appointment appointment  = appointmentRepository.findById(medicalHistoryRequest.getAppointmentId()).orElseThrow();
        medicalHistory.setAppointment(appointment);
        medicalHistory.setDate_re_examination(medicalHistoryRequest.getDateReExamination());
        medicalHistory.setNote(medicalHistoryRequest.getNote());
        medicalHistory.setStatus(medicalHistoryRequest.getStatus());
        Set<Prescription> prescriptions = new HashSet<>();
        if (medicalHistoryRequest.getPrescriptions() != null) {
            for (PrescriptionRequest prescriptionRequest : medicalHistoryRequest.getPrescriptions()) {
                Prescription prescription = new Prescription();
                prescription.setDosage(prescriptionRequest.getDosage());
                prescription.setMedicine(prescription.getMedicine());
                prescriptions.add(prescription);
            }
        }
        //////////////////////////
        MedicalHistory result = medicalHistoryRepository.save(medicalHistory);
        prescriptions.forEach(prescription -> prescription.setMedical_history(result));
        prescriptionRepository.saveAllAndFlush(prescriptions);
        if (result == null) {
            return new ApiResponse(Boolean.FALSE, "Failed to add history medical");
        }
        return new ApiResponse(Boolean.TRUE, "Successfully add history medical");
    }


    @Override
    public ResponseEntity<MedicalHistory> editHistory(MedicalHistory medicalHistory) {
        try {
            MedicalHistory medicalHistory1 = medicalHistoryRepository.save(medicalHistory);
            return ResponseEntity.ok(medicalHistory1);
        } catch (DataAccessException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public List<MedicalHistory> listHistoryPhysician() {
        return medicalHistoryRepository.findAll();
    }

}
