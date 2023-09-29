package com.duck.go2ductor.service;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.dao.AppointmentRequest;
import com.duck.go2ductor.entity.Appointment;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
public interface AppointmentService {
    List<Appointment> getAllAppointment(String startDtTimeStr, String endDtTimeStr) throws ParseException;
    List<Appointment> getAppointmentPhysician(String startDtTimeStr, String endDtTimeStr,String id_physician)throws ParseException;
    List<Appointment> getAppointmentPatient(String startDtTimeStr, String endDtTimeStr,String id_patient)throws ParseException;

    ResponseEntity<Appointment> addAppointment(AppointmentRequest appointmentRequest);
    ApiResponse booking(AppointmentRequest appointmentRequest);

    ResponseEntity<Appointment> editAppointment(AppointmentRequest appointmentRequest);
    ApiResponse cancelAppointmentByPatient(AppointmentRequest appointmentRequest);
    ApiResponse cancelAppointmentByPhysician(AppointmentRequest appointmentRequest);

    ApiResponse deleteAppointment(Long appointmentID);
}
