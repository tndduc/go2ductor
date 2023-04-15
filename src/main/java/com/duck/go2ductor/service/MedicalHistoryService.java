package com.duck.go2ductor.service;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.dao.MedicalHistoryRequest;
import com.duck.go2ductor.entity.MedicalHistory;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/14/2023
 */
public interface MedicalHistoryService {
    ApiResponse addHistory(MedicalHistoryRequest medicalHistoryRequest);
    ApiResponse editHistory(MedicalHistory medicalHistory);
    List<MedicalHistory> listHistoryPhysician(String username, Timestamp timeStart, Timestamp timesEnd);




}
