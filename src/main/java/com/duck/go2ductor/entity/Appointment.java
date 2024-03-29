package com.duck.go2ductor.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @author DucTN
 * @project duck
 * @on 4/3/2023
 */
@Entity
@Table(name = "appointment")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name="id_physician", nullable=false,referencedColumnName="id")
    private Physician physician;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_patient", nullable=true,referencedColumnName="id")
    private Patient patient;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private Timestamp start_dt_time;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private Timestamp end_dt_time;
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name="id_room", nullable=false,referencedColumnName="id")
    private Room room;
    private String status;
    @JsonIgnore
    @OneToOne(mappedBy = "appointment", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, optional = false)
    private MedicalHistory medicalHistory;

    @JsonIgnore
    @OneToOne(mappedBy = "appointment_re", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, optional = false)
    private MedicalHistory medicalHistory_re;
}
