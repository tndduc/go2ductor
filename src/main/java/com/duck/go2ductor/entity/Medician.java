package com.duck.go2ductor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Entity
@Table(name = "medician")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Medician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String manufacturer;
    private String dosage_form;
    private String strength;
    private String composition;
    private String indications;
    private String contraindications;
    private String side_effects;
    private String storage_instructions;
    private BigDecimal price;
    private String image;


}
