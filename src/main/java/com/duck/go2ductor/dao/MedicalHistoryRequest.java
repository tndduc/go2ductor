package com.duck.go2ductor.dao;

import com.duck.go2ductor.entity.Prescription;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/15/2023
 */
@Data
public class MedicalHistoryRequest {

    private Long id;
    @NotNull(message = "appointmentId must not be null")
    private Long appointmentId;
    private Long dateReExamination;
    private String note;
    private String status;
    private Set<PrescriptionRequest> prescriptions;
}
