package com.duck.go2ductor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.parameters.P;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalTime;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Entity
@Table(name = "review")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long id_medical_history;
    private String review;
    private Integer star;
    private Timestamp date;


}
