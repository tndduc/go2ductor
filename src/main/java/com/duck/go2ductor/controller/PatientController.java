package com.duck.go2ductor.controller;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.dao.FileUploadResponse;
import com.duck.go2ductor.dao.PatientDAO;
import com.duck.go2ductor.entity.Patient;
import com.duck.go2ductor.entity.Physician;
import com.duck.go2ductor.file.FileUploadUtil;
import com.duck.go2ductor.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/10/2023
 */
@RestController
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/get-profile")
    public PatientDAO getProfile(@RequestParam(name = "username") String username ){
        return patientService.getUserDAOProfile(username);
    }
    @PostMapping("/update")
    public ApiResponse updateProfile(@Valid @RequestBody Patient patient){
        return patientService.updatePatient(patient);
    }

}
