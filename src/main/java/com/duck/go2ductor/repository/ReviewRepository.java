package com.duck.go2ductor.repository;

import com.duck.go2ductor.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
public interface ReviewRepository extends JpaRepository<Review,Long> {
}
