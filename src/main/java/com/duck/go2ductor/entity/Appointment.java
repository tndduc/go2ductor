package com.duck.go2ductor.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;


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
    private Long id_physician;
    private Long id_patient;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private Timestamp start_dt_time;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private Timestamp end_dt_time;
    private Long id_room;
    private String status;


}
