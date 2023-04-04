package com.duck.go2ductor.repository;

import com.duck.go2ductor.entity.Physician;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
public interface PhysicianRepository extends JpaRepository<Physician,Long> {
}
