package com.duck.go2ductor.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Entity
@Table(name = "medical_history")
public class MedicalHistory {
    @Id
    private Long id;
    private Long appointment_id;
    private Long id_patient;
    private Long id_physician;
    private Long date_re_examination;
    private String note;

    public MedicalHistory() {
    }

    public MedicalHistory(Long id, Long appointment_id, Long id_patient, Long id_physician, Long date_re_examination, String note) {
        this.id = id;
        this.appointment_id = appointment_id;
        this.id_patient = id_patient;
        this.id_physician = id_physician;
        this.date_re_examination = date_re_examination;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(Long appointment_id) {
        this.appointment_id = appointment_id;
    }

    public Long getId_patient() {
        return id_patient;
    }

    public void setId_patient(Long id_patient) {
        this.id_patient = id_patient;
    }

    public Long getId_physician() {
        return id_physician;
    }

    public void setId_physician(Long id_physician) {
        this.id_physician = id_physician;
    }

    public Long getDate_re_examination() {
        return date_re_examination;
    }

    public void setDate_re_examination(Long date_re_examination) {
        this.date_re_examination = date_re_examination;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
