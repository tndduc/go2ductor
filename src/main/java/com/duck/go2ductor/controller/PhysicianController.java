package com.duck.go2ductor.controller;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.dao.PhysicianDAO;
import com.duck.go2ductor.entity.Appointment;
import com.duck.go2ductor.entity.Physician;
import com.duck.go2ductor.service.AppointmentService;
import com.duck.go2ductor.service.PhysicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@RestController
@RequestMapping("/api/physician")
public class PhysicianController {
    @Autowired
    private PhysicianService physicianService;
    //http://localhost:8080/api/physician/get-profile
    @GetMapping("/get-profile")
    public PhysicianDAO getProfile(@RequestParam(name = "username") String username ){
        return physicianService.getUserDAOProfile(username);
    }
    @PostMapping("/update")
    public ApiResponse updateProfile(@Valid @RequestBody Physician physician){
        return physicianService.updatePhysician(physician);
    }


}
