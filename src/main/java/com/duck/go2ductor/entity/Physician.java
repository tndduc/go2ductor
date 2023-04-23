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
@Table(name = "physician")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Physician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String first_name;
    private String last_name;
    private String id_card;
    private String image;
    private String phone;
    private String sex;
    private LocalDate dob;
    private String note;
    private String education;
    private String specialization;
    private String experience;
    @JsonIgnore
    @OneToMany(mappedBy="physician",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Appointment> appointments;



}
