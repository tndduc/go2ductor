package com.duck.go2ductor.service.impl;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.dao.MedicalHistoryRequest;
import com.duck.go2ductor.dao.PrescriptionRequest;
import com.duck.go2ductor.entity.MedicalHistory;
import com.duck.go2ductor.entity.Prescription;
import com.duck.go2ductor.repository.MedicalHistoryRepository;
import com.duck.go2ductor.repository.PrescriptionRepository;
import com.duck.go2ductor.service.MedicalHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/15/2023
 */
@Service
@Slf4j
public class MedicalHistoryServiceImpl implements MedicalHistoryService {
    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    @Transactional
    public ApiResponse addHistory(MedicalHistoryRequest medicalHistoryRequest) {
        MedicalHistory medicalHistory = new MedicalHistory();
        medicalHistory.setAppointment_id(medicalHistoryRequest.getAppointmentId());
        medicalHistory.setId_patient(medicalHistoryRequest.getPatientId());
        medicalHistory.setId_physician(medicalHistoryRequest.getPhysicianId());
        medicalHistory.setDate_re_examination(medicalHistoryRequest.getDateReExamination());
        medicalHistory.setNote(medicalHistoryRequest.getNote());
        medicalHistory.setStatus(medicalHistoryRequest.getStatus());

        MedicalHistory savedMedicalHistory = medicalHistoryRepository.save(medicalHistory);
        if (savedMedicalHistory == null) {
            return new ApiResponse(Boolean.FALSE, "Failed to add history medical");
        }else {
            Long id_medical_history = savedMedicalHistory.getId();
            Set<Prescription> prescriptions = new HashSet<>();
            if (medicalHistoryRequest.getPrescriptions() != null) {
                for (PrescriptionRequest prescriptionRequest : medicalHistoryRequest.getPrescriptions()) {
                    Prescription prescription = new Prescription();
                    prescription.setId_medical_history(id_medical_history);
                    prescription.setId_medicine(prescriptionRequest.getId_medicine());
                    prescription.setDosage(prescriptionRequest.getDosage());
                    prescriptions.add(prescription);
                }
                for (Prescription prescription : prescriptions){
                    prescriptionRepository.save(prescription);
                }
            }

        }
        return new ApiResponse(Boolean.TRUE, "Successfully add history medical");
    }


    @Override
    public ApiResponse editHistory(MedicalHistory medicalHistory) {
        return null;
    }

    @Override
    public List<MedicalHistory> listHistoryPhysician(String username, Timestamp timeStart, Timestamp timesEnd) {
        return null;
    }

}
