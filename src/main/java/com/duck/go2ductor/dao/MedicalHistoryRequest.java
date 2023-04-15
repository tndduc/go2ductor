package com.duck.go2ductor.dao;

import com.duck.go2ductor.entity.Prescription;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.util.Set;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/15/2023
 */
@Data
public class MedicalHistoryRequest {
    private Long appointmentId;
    private Long patientId;
    private Long physicianId;
    private Long dateReExamination;
    private String note;
    private String status;
    private Set<PrescriptionRequest> prescriptions;
}
