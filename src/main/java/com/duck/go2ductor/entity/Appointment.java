package com.duck.go2ductor.entity;

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

}
