package com.duck.go2ductor.service.impl;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.dao.ReviewDAO;
import com.duck.go2ductor.entity.MedicalHistory;
import com.duck.go2ductor.entity.Review;
import com.duck.go2ductor.repository.MedicalHistoryRepository;
import com.duck.go2ductor.repository.ReviewRepository;
import com.duck.go2ductor.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/28/2023
 */
@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MedicalHistoryRepository  medicalHistoryRepository;
    @Override
    public ApiResponse addReview(ReviewDAO review) {
        Review reviewNew = new Review();
        reviewNew.setDate(review.getDate());
        reviewNew.setStar(review.getStar());
        reviewNew.setReview(review.getReview());
        MedicalHistory medicalHistory1 = medicalHistoryRepository.findById(review.getId_medicalHistory()).orElseThrow();
        reviewNew.setMedical_history(medicalHistory1);
        try{
            Review savedReview = reviewRepository.save(reviewNew);
            return new ApiResponse(true,"Add review successfully", HttpStatus.CREATED);
        }catch (Exception e){
            return new ApiResponse(false,"Add review failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ApiResponse updateReview(ReviewDAO review) {
        Review reviewNew = new Review();
        reviewNew.setId(review.getId());
        reviewNew.setDate(review.getDate());
        reviewNew.setStar(review.getStar());
        reviewNew.setReview(review.getReview());
        MedicalHistory medicalHistory1 = medicalHistoryRepository.findById(review.getId_medicalHistory()).orElseThrow();
        reviewNew.setMedical_history(medicalHistory1);
        try{
           reviewRepository.save(reviewNew);
            return new ApiResponse(true,"Add review successfully", HttpStatus.CREATED);
        }catch (Exception e){
            return new ApiResponse(false,"Add review failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ApiResponse deleteReview(Long reviewId) {
        try{
            reviewRepository.deleteById(reviewId);
            return new ApiResponse(true,"Add review successfully", HttpStatus.CREATED);
        }catch (Exception e){
            return new ApiResponse(false,"Add review failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<Review> getListReviewPhysician(String username) {
        return reviewRepository.findByPhysicianUsername(username);
    }

    @Override
    public  List<Review> getReview(Long idMedicalHistory) {
        return reviewRepository.findByMedicalHistoryId(idMedicalHistory);
    }
}
