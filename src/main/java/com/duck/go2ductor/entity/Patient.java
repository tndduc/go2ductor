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
@Table(name = "patient")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String user_name;
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


}
