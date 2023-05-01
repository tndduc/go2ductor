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
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public List<Timestamp> dateFormat(String startDtTimeStr, String endDtTimeStr)throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDtTime = dateFormat.parse(startDtTimeStr);
        Date endDtTime = dateFormat.parse(endDtTimeStr);
        Timestamp startTimestamp = new Timestamp(startDtTime.getTime());
        Timestamp endTimestamp = new Timestamp(endDtTime.getTime());
        List<Timestamp> statEnd = new ArrayList<>();
        statEnd.add(startTimestamp);
        statEnd.add(endTimestamp);
        return statEnd;
    }

    @Override
    @Transactional
    public ApiResponse addHistory(MedicalHistoryRequest medicalHistoryRequest) {
        MedicalHistory medicalHistory = new MedicalHistory();
        Long idAppointment = medicalHistoryRequest.getAppointmentId();
        Appointment appointment  = appointmentRepository.findById(idAppointment).orElseThrow(
                () -> new EntityNotFoundException("Could not find appointment with id: " + idAppointment)
        );
        medicalHistory.setAppointment(appointment);
        if (medicalHistoryRequest.getDateReExamination()!=null){
            Appointment appointment_re  = appointmentRepository.findById(medicalHistoryRequest.getDateReExamination()).orElseThrow();
            if (appointment_re != null){
                medicalHistory.setAppointment_re(appointment_re);
            }else {
                medicalHistory.setAppointment_re(null);
            }
        }else {
            medicalHistory.setAppointment_re(null);
        }
        medicalHistory.setNote(medicalHistoryRequest.getNote());
        medicalHistory.setStatus(medicalHistoryRequest.getStatus());
        Set<Prescription> prescriptions = new HashSet<>();
        if (medicalHistoryRequest.getPrescriptions() != null) {
            for (PrescriptionRequest prescriptionRequest : medicalHistoryRequest.getPrescriptions()) {
                Prescription prescription = new Prescription();
                prescription.setDosage(prescriptionRequest.getDosage());
                Medicine medicine = medicineRepository.findById(prescriptionRequest.getId_medicine()).orElseThrow(
                        () -> new EntityNotFoundException("Could not find medicine with id: " + prescriptionRequest.getId_medicine())
                );
                log.info("find Medicine with  id: {}",medicine.getId());
                prescription.setMedicine(medicine);
                prescriptions.add(prescription);
            }
        }
        try {
            MedicalHistory result = medicalHistoryRepository.save(medicalHistory);
            MedicalHistory resultNew = medicalHistoryRepository.findById(result.getId()).orElseThrow(
                    () -> new EntityNotFoundException("Could not find MedicalHistory with id: " + result.getId())
            );
            if (medicalHistoryRequest.getPrescriptions() != null && resultNew!= null) {
                for (Prescription prescription : prescriptions) {
                    prescription.setMedical_history(resultNew);
                    prescriptionRepository.save(prescription);
                }
            }
            log.info("Saved {} Prescription(s) with MedicalHistory id: {}",
                    prescriptions.size(), result.getId());
            return new ApiResponse(Boolean.TRUE, "Successfully add history medical");
        } catch (Exception e) {
            log.error("Error saving MedicalHistory and/or Prescription(s): {}", e.getMessage());
            return new ApiResponse(Boolean.FALSE, "Failed to add history medical");
        }
    }


    @Override
    @Transactional
    public ApiResponse editHistory(MedicalHistoryRequest medicalHistoryRequest) {
            MedicalHistory medicalHistory = medicalHistoryRepository.findById(medicalHistoryRequest.getId()).orElseThrow();
            Appointment appointment  = appointmentRepository.findById(medicalHistoryRequest.getAppointmentId()).orElseThrow();
            medicalHistory.setAppointment(appointment);
            if (medicalHistoryRequest.getDateReExamination()!=null){
                Appointment appointment_re  = appointmentRepository.findById(medicalHistoryRequest.getDateReExamination()).orElseThrow();
                if (appointment_re != null){
                    medicalHistory.setAppointment_re(appointment_re);
                }else {
                    medicalHistory.setAppointment_re(null);
                }
            }else {
                medicalHistory.setAppointment_re(null);
            }
            medicalHistory.setNote(medicalHistoryRequest.getNote());
            medicalHistory.setStatus(medicalHistoryRequest.getStatus());
            MedicalHistory result = medicalHistoryRepository.save(medicalHistory);
            if (result == null) {
                return new ApiResponse(Boolean.FALSE, "Failed to add history medical");
            }
            return new ApiResponse(Boolean.TRUE, "Successfully add history medical");
    }

    @Override
    public List<MedicalHistory> listHistoryPhysician(String startDtTimeStr, String endDtTimeStr,String physicianUserName) throws ParseException {
        List<Timestamp> timestampList = new ArrayList<>(dateFormat(startDtTimeStr,endDtTimeStr));
        Timestamp dateStart = timestampList.get(0);
        Timestamp dateEnd = timestampList.get(1);
        Physician physician = physicianRepository.findByUsername(physicianUserName);
        Long id_physician = physician.getId();
        return medicalHistoryRepository.findAllByPhysicianAndAppointmentDate(dateStart,dateEnd,id_physician);
    }
    @Override
    public List<MedicalHistory> listHistoryPatient(String startDtTimeStr, String endDtTimeStr,String patientUserName) throws ParseException {
        List<Timestamp> timestampList = new ArrayList<>(dateFormat(startDtTimeStr,endDtTimeStr));
        Timestamp dateStart = timestampList.get(0);
        Timestamp dateEnd = timestampList.get(1);
        Patient patient = patientRepository.findByUsername(patientUserName);
        Long id_patient = patient.getId();
        return medicalHistoryRepository.findAllByPatientAndAppointmentDate(dateStart,dateEnd,id_patient);
    }

    @Override
    public ApiResponse deleteHistory(Long medicalHistoryID) {
        MedicalHistory medicalHistory = medicalHistoryRepository.findById(medicalHistoryID).orElseThrow();
        Long id =medicalHistory.getId();

        medicalHistoryRepository.delete(medicalHistory);
        boolean isDeleted = !appointmentRepository.existsById(medicalHistory.getId());
        if (isDeleted) {
            return new ApiResponse(Boolean.TRUE, "Successfully delete appointment with id :"+medicalHistory.getId());

        }
        return new ApiResponse(Boolean.FALSE, "Failed to delete appointment with id :"+medicalHistory.getId());
    }
}


