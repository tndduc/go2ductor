package com.duck.go2ductor.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;


/**
 * @author DucTN
 * @project duck
 * @on 4/3/2023
 */
@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long id_physician;
    private Long id_patient;
    private Timestamp start_dt_time;
    private Time end_dt_time;
    private Long id_room;

    public Appointment() {
    }

    public Appointment(Long id, Long id_physician, Long id_patient, Timestamp start_dt_time, Time end_dt_time, Long id_room) {
        this.id = id;
        this.id_physician = id_physician;
        this.id_patient = id_patient;
        this.start_dt_time = start_dt_time;
        this.end_dt_time = end_dt_time;
        this.id_room = id_room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_physician() {
        return id_physician;
    }

    public void setId_physician(Long id_physician) {
        this.id_physician = id_physician;
    }

    public Long getId_patient() {
        return id_patient;
    }

    public void setId_patient(Long id_patient) {
        this.id_patient = id_patient;
    }

    public Timestamp getStart_dt_time() {
        return start_dt_time;
    }

    public void setStart_dt_time(Timestamp start_dt_time) {
        this.start_dt_time = start_dt_time;
    }

    public Time getEnd_dt_time() {
        return end_dt_time;
    }

    public void setEnd_dt_time(Time end_dt_time) {
        this.end_dt_time = end_dt_time;
    }

    public Long getId_room() {
        return id_room;
    }

    public void setId_room(Long id_room) {
        this.id_room = id_room;
    }
}
