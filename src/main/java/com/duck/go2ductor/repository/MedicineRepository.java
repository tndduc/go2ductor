package com.duck.go2ductor.repository;

import com.duck.go2ductor.entity.Medicine;
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
public interface MedicineRepository extends JpaRepository<Medicine,Long> {
    @Query("SELECT m FROM Medicine m WHERE m.name LIKE %:searchTerm%")
    List<Medicine> findByNameContaining(@Param("searchTerm") String searchTerm);
}
