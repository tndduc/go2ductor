package com.duck.go2ductor.service.impl;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.entity.Appointment;
import com.duck.go2ductor.repository.AppointmentRepository;
import com.duck.go2ductor.repository.PatientRepository;
import com.duck.go2ductor.repository.PhysicianRepository;
import com.duck.go2ductor.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PhysicianRepository physicianRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Appointment getAllAppointment(LocalDate dateStart, LocalDate dateEnd) {
        return null;
    }

    @Override
    public Appointment getAppointmentPhysician(String physicianUserName, LocalDate dateStart, LocalDate dateEnd) {
        return null;
    }

    @Override
    public Appointment getAppointmentPatient(String patientUserName, LocalDate dateStart, LocalDate dateEnd) {
        return null;
    }

    @Override
    public ResponseEntity<Appointment> addAppointment(Appointment appointment) {
        Appointment appointmentNew = appointmentRepository.save(appointment);
        return new ResponseEntity<>(appointmentNew, HttpStatus.CREATED);
    }

    @Override
    public Appointment editAppointment(Appointment appointment, Long idAppointment, String physicianUserName) {
        return null;
    }

    @Override
    public ApiResponse cancelAppointmentByPatient(Long idAppointment, Long patientUserName) {
        return null;
    }

    @Override
    public ApiResponse cancelAppointmentByPhysician(Long idAppointment, Long physicianUserName) {
        return null;
    }

    @Override
    public ApiResponse checkAppointmentAvailable(Appointment appointment) {
        return null;
    }

    @Override
    public ApiResponse deleteAppointment(Long idAppointment) {
        return null;
    }
}
