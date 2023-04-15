package com.duck.go2ductor.dao;

import lombok.Data;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/15/2023
 */
@Data
public class PrescriptionRequest {
    private Long id_medicine;
    private String dosage;
}
