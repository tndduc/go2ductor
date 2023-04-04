package com.duck.go2ductor.controller;

import com.duck.go2ductor.entity.Appointment;
import com.duck.go2ductor.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
