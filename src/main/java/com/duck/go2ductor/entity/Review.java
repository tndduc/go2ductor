package com.duck.go2ductor.entity;

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
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long id_medical_history;
    private String review;
    private Integer star;
    private Timestamp date;

    public Review() {
    }

    public Review(Long id, Long id_medical_history, String review, Integer star, Timestamp date) {
        this.id = id;
        this.id_medical_history = id_medical_history;
        this.review = review;
        this.star = star;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_medical_history() {
        return id_medical_history;
    }

    public void setId_medical_history(Long id_medical_history) {
        this.id_medical_history = id_medical_history;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
