package com.duck.go2ductor.repository;

import com.duck.go2ductor.entity.MedicalHistory;
import com.duck.go2ductor.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {
    @Query("SELECT p FROM Prescription p WHERE p.medical_history.id = :id_medical_history")
    List<Prescription> findByIdMedicalHistory(@Param("id_medical_history") Long id_medical_history);
}
