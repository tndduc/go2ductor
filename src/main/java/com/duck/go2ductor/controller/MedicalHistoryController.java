package com.duck.go2ductor.controller;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.dao.MedicalHistoryRequest;
import com.duck.go2ductor.service.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/15/2023
 */
@RestController
@RequestMapping("/api/medical")
public class MedicalHistoryController {
   @Autowired
   private MedicalHistoryService medicalHistoryService;

    @PostMapping("/add")
    public ApiResponse createMedicalHistory(@RequestBody MedicalHistoryRequest medicalHistoryRequest) {
        return medicalHistoryService.addHistory(medicalHistoryRequest);
    }
}
