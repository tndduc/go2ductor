package com.duck.go2ductor.service;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.dao.ReviewDAO;
import com.duck.go2ductor.entity.Review;

import java.util.List;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/14/2023
 */
public interface ReviewService {
    ApiResponse addReview(ReviewDAO review);
    ApiResponse updateReview(ReviewDAO review);
    ApiResponse deleteReview(Long reviewId);
    List<Review> getListReviewPhysician(String username);
    List<Review> getReview(Long idMedicalHistory);

}
