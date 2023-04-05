package com.duck.go2ductor.controller;

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
    @GetMapping("/fill-all-by-doctor")
    public List<Appointment> getExample(@RequestParam(name = "start_dt_time") String startDtTimeStr,
                                        @RequestParam(name = "end_dt_time") String endDtTimeStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDtTime = dateFormat.parse(startDtTimeStr);
        Date endDtTime = dateFormat.parse(endDtTimeStr);

        Timestamp startTimestamp = new Timestamp(startDtTime.getTime());
        Timestamp endTimestamp = new Timestamp(endDtTime.getTime());

        return appointmentService.getAllAppointment(startTimestamp, endTimestamp);
    }
}
