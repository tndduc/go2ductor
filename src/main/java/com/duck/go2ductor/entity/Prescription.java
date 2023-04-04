package com.duck.go2ductor.entity;

import javax.persistence.*;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Entity
@Table
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long id_medical_history;
    private Long id_medicine;
    private String dosage;

    public Prescription() {
    }

    public Prescription(Long id, Long id_medical_history, Long id_medicine, String dosage) {
        this.id = id;
        this.id_medical_history = id_medical_history;
        this.id_medicine = id_medicine;
        this.dosage = dosage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_medical_history() {
        return id_medical_history;
    }

    public void setId_medical_history(Long id_medical_history) {
        this.id_medical_history = id_medical_history;
    }

    public Long getId_medicine() {
        return id_medicine;
    }

    public void setId_medicine(Long id_medicine) {
        this.id_medicine = id_medicine;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
}
