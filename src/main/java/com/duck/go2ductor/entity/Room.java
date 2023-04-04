package com.duck.go2ductor.entity;

import javax.persistence.*;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String position;
    private String working_hours;
    private String service;

}
