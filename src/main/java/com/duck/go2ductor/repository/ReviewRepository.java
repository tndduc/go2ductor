package com.duck.go2ductor.repository;

import com.duck.go2ductor.entity.Prescription;
import com.duck.go2ductor.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    @Query("SELECT r FROM Review r JOIN r.medical_history mh JOIN mh.appointment a JOIN a.physician p WHERE p.username = :username")
    List<Review> findByPhysicianUsername(@Param("username") String username);
    @Query("SELECT r FROM Review r WHERE r.medical_history.id = :id")
    List<Review> findByMedicalHistoryId(@Param("id") Long id);
}
