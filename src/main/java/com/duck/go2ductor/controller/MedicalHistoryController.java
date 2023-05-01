package com.duck.go2ductor.controller;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.dao.MedicalHistoryRequest;
import com.duck.go2ductor.entity.MedicalHistory;
import com.duck.go2ductor.repository.MedicalHistoryRepository;
import com.duck.go2ductor.service.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;


    @PostMapping("/add")
    public ApiResponse createMedicalHistory(@RequestBody MedicalHistoryRequest  medicalHistoryRequest) {
        return medicalHistoryService.addHistory(medicalHistoryRequest);
    }
    @PutMapping("/edit")
    public ApiResponse editHistory(@RequestBody MedicalHistoryRequest medicalHistory){
        return  medicalHistoryService.editHistory(medicalHistory);
    }
    @GetMapping("/get_by_physician")
    public List<MedicalHistory> getByPhysician(String startDtTimeStr, String endDtTimeStr,String physicianUserName) throws ParseException {
        return medicalHistoryService.listHistoryPhysician(startDtTimeStr, endDtTimeStr, physicianUserName);
    }
    @GetMapping("/get_by_patient")
    public List<MedicalHistory> getByPatient(String startDtTimeStr, String endDtTimeStr,String patientUserName) throws ParseException {
        return medicalHistoryService.listHistoryPatient(startDtTimeStr, endDtTimeStr, patientUserName);
    }
    @GetMapping("/get")
    public List<MedicalHistory> get(){
        return medicalHistoryRepository.findAll();
    }
    @DeleteMapping("/delete")
    private ApiResponse deleteMedicalHistory(Long MedicalHistoryID){
        return medicalHistoryService.deleteHistory(MedicalHistoryID);
    }
}
