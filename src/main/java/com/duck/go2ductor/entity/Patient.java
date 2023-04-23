package com.duck.go2ductor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Entity
@Table(name = "patient")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @JsonIgnore
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
    @JsonIgnore
    @OneToMany(mappedBy="patient",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Appointment> appointments;



}
