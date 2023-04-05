package com.duck.go2ductor.repository;


import com.duck.go2ductor.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
}
