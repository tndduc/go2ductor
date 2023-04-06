package com.duck.go2ductor.controller;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.entity.Appointment;
import com.duck.go2ductor.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
    @Autowired
    private  AppointmentService appointmentService;
    //http://localhost:8080/api/appointment/add
    @PostMapping("/add")
    public ResponseEntity<Appointment> addCategory(@Valid @RequestBody Appointment appointment) {
        return appointmentService.addAppointment(appointment);
    }
    @GetMapping("/get-all")
    public List<Appointment> getAll(@RequestParam(name = "start_dt_time") String startDtTimeStr,
                                        @RequestParam(name = "end_dt_time") String endDtTimeStr) throws ParseException {
        return appointmentService.getAllAppointment(startDtTimeStr, endDtTimeStr);
    }
    @GetMapping("/get-by-physician")
    public List<Appointment> getByPhysician(@RequestParam(name = "start_dt_time") String startDtTimeStr,
                                        @RequestParam(name = "end_dt_time") String endDtTimeStr,
                                            @RequestParam(name = "physicianUserName") String physicianUserName) throws ParseException {

        return appointmentService.getAppointmentPhysician(startDtTimeStr, endDtTimeStr,physicianUserName);
    }
    @GetMapping("/get-by-patient")
    public List<Appointment> getByPatient(@RequestParam(name = "start_dt_time") String startDtTimeStr,
                                            @RequestParam(name = "end_dt_time") String endDtTimeStr,
                                            @RequestParam(name = "patientUserName") String patientUserName) throws ParseException {

        return appointmentService.getAppointmentPhysician(startDtTimeStr, endDtTimeStr,patientUserName);
    }
    @PostMapping("/edit")
    public ResponseEntity<Appointment> edit(@Valid @RequestBody Appointment appointment){
        return appointmentService.editAppointment(appointment);
    }
    @PostMapping("/cancel-physician")
    public ApiResponse cancelByPhysician(@Valid @RequestBody Appointment appointment){
        return appointmentService.cancelAppointmentByPhysician(appointment);
    }
    @PostMapping("/cancel-patient")
    public ApiResponse cancelByPatient(@Valid @RequestBody Appointment appointment){
        return appointmentService.cancelAppointmentByPatient(appointment);
    }
}
