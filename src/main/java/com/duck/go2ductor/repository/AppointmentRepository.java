package com.duck.go2ductor.repository;

import com.duck.go2ductor.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Repository

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    @Query(value ="SELECT * FROM appointment  WHERE start_dt_time >= :startDate AND end_dt_time <= :endDate", nativeQuery = true)
    List<Appointment> fillAllByStartEnd(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);
    @Query(value ="SELECT * FROM appointment  WHERE start_dt_time >= :startDate AND end_dt_time <= :endDate AND id_physician = :physicianUserName", nativeQuery = true)
    List<Appointment> fillAllByPhysicianStartEnd(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, @Param("physicianUserName") Long physicianUserName);
    @Query(value ="SELECT * FROM appointment  WHERE start_dt_time >= :startDate AND end_dt_time <= :endDate id_patient =:patientUserName", nativeQuery = true)
    List<Appointment> fillAllByPatentStartEnd(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, @Param("patientUserName") Long patientUserName);

    @Modifying
    @Transactional
    @Query(value ="UPDATE appointment u SET u.status = :status WHERE u.id = :id" ,nativeQuery = true)
    int cancelAppointment(@Param("id")Long id,@Param("status") String status);
}
