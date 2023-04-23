package com.duck.go2ductor.controller;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.dao.MedicalHistoryRequest;
import com.duck.go2ductor.entity.MedicalHistory;
import com.duck.go2ductor.service.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ApiResponse createMedicalHistory(@RequestBody MedicalHistoryRequest  medicalHistoryRequest) {
        return medicalHistoryService.addHistory(medicalHistoryRequest);
    }
    @PostMapping("/edit")
    public ResponseEntity<MedicalHistory> editHistory(@RequestBody MedicalHistory medicalHistory){
        return  medicalHistoryService.editHistory(medicalHistory);
    }
    @GetMapping("/get")
    public List<MedicalHistory> getHistory(){
        return medicalHistoryService.listHistoryPhysician();
    }

}
