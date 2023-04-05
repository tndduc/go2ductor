package com.duck.go2ductor.service;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.entity.Appointment;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
public interface AppointmentService {
    List<Appointment> getAllAppointment(Timestamp dateStart, Timestamp dateEnd);
    Appointment getAppointmentPhysician(String physicianUserName,Timestamp dateStart,Timestamp dateEnd);
    Appointment getAppointmentPatient(String patientUserName,Timestamp dateStart,Timestamp dateEnd);

    ResponseEntity<Appointment> addAppointment(Appointment appointment);
    Appointment editAppointment(Appointment appointment,Long idAppointment,String physicianUserName);
    ApiResponse cancelAppointmentByPatient(Long idAppointment,Long patientUserName);
    ApiResponse cancelAppointmentByPhysician(Long idAppointment,Long physicianUserName);
    ApiResponse checkAppointmentAvailable(Appointment appointment);
    ApiResponse deleteAppointment(Long idAppointment);
}
