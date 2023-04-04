package com.duck.go2ductor.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    private Long id;
    private String password;
    private String last_name;
    private String first_name;
    private String id_card;
    private String image;
    private String phone;
    private String sex;
    private LocalDate dob;
    private String note;
    private String health_insurance;

    public Patient() {
    }

    public Patient(Long id, String password, String last_name, String first_name, String id_card, String image, String phone, String sex, LocalDate dob, String note, String health_insurance) {
        this.id = id;
        this.password = password;
        this.last_name = last_name;
        this.first_name = first_name;
        this.id_card = id_card;
        this.image = image;
        this.phone = phone;
        this.sex = sex;
        this.dob = dob;
        this.note = note;
        this.health_insurance = health_insurance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getHealth_insurance() {
        return health_insurance;
    }

    public void setHealth_insurance(String health_insurance) {
        this.health_insurance = health_insurance;
    }
}
