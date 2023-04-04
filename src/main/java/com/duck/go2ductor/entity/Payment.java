package com.duck.go2ductor.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalTime;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long id_medical_history;
    private String service;
    private BigDecimal price;
    private String method;
    private LocalTime date;

    public Payment() {
    }

    public Payment(Long id, Long id_medical_history, String service, BigDecimal price, String method, LocalTime date) {
        this.id = id;
        this.id_medical_history = id_medical_history;
        this.service = service;
        this.price = price;
        this.method = method;
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

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public LocalTime getDate() {
        return date;
    }

    public void setDate(LocalTime date) {
        this.date = date;
    }
}
