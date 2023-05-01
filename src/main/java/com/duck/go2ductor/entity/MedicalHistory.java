package com.duck.go2ductor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Entity
@Table(name = "medical_history")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicalHistory  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name="appointment_id", nullable=false,referencedColumnName="id")
    private Appointment appointment;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="date_re_examination", nullable=true,referencedColumnName="id")
    private Appointment appointment_re;
    private String note;
    private String status;
    @JsonIgnore
    @OneToMany(mappedBy="medical_history",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Prescription> prescriptions;
    @JsonIgnore
    @OneToOne(mappedBy = "medical_history", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, optional = false)
    private Payment payment;
    @JsonIgnore
    @OneToMany(mappedBy="medical_history",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Review> reviews;
}
