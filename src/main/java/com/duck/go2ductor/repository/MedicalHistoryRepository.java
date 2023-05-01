package com.duck.go2ductor.repository;

import com.duck.go2ductor.entity.Appointment;
import com.duck.go2ductor.entity.MedicalHistory;
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
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory,Long> {
    @Query("SELECT mh FROM MedicalHistory mh JOIN mh.appointment a WHERE a.start_dt_time >= :startDate AND a.end_dt_time <= :endDate AND a.physician.id = :physicianId")
    List<MedicalHistory> findAllByPhysicianAndAppointmentDate(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, @Param("physicianId") Long physicianId);
    @Query("SELECT mh FROM MedicalHistory mh JOIN mh.appointment a WHERE a.start_dt_time >= :startDate AND a.end_dt_time <= :endDate AND a.patient.id = :patientId")
    List<MedicalHistory> findAllByPatientAndAppointmentDate(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, @Param("patientId") Long patientId);
}
