package com.duck.go2ductor.repository;

import com.duck.go2ductor.entity.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory,Long> {
    <S extends MedicalHistory> S save(S medicalHistory);

}
