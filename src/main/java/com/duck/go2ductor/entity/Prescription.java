package com.duck.go2ductor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Entity
@Table(name = "prescription")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Prescription  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="id_medical_history", nullable=false,referencedColumnName="id")
    private MedicalHistory medical_history;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="physician", nullable=false,referencedColumnName="id")
    private Medicine medicine;
    private String dosage;
}
