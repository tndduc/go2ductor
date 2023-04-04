package com.duck.go2ductor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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



}
