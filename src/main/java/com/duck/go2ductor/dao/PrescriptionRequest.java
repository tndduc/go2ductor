package com.duck.go2ductor.dao;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/15/2023
 */
@Data
public class PrescriptionRequest {
    private Long id;
    @NotNull
    private Long id_medicine;
    @NotNull
    private String dosage;

    private Long id_medicalHistory;
}
