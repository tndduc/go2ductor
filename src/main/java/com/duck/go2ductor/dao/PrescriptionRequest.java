package com.duck.go2ductor.dao;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

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
    private Integer amount;
    private BigDecimal price;
}
