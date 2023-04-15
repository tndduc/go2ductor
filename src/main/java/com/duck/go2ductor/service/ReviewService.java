package com.duck.go2ductor.service;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.entity.Review;

import java.util.List;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/14/2023
 */
public interface ReviewService {
    ApiResponse addReview(Review review);
    ApiResponse updateReview(Review review);
    ApiResponse deleteReview(Review review);

    List<Review> getListReviewPhysician(String username);

}
