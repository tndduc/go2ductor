package com.duck.go2ductor.controller;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.dao.ReviewDAO;
import com.duck.go2ductor.entity.Review;
import com.duck.go2ductor.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/29/2023
 */
@RestController
@RequestMapping("/api/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @GetMapping("/get-by-id")
    public List<Review> getByID(@RequestParam Long medicalHistoryId){
        return reviewService.getReview(medicalHistoryId);
    }
    @GetMapping("/get-by-physician")
    public List<Review> getByID(@RequestParam String usernamePhysician){
        return reviewService.getListReviewPhysician(usernamePhysician);
    }
    @PostMapping("/add")
    public ApiResponse add(@RequestBody ReviewDAO review){

        return reviewService.addReview(review);
    }
    @PutMapping("/update")
    public ApiResponse update(@RequestBody ReviewDAO review){
        return reviewService.updateReview(review);
    }
    @DeleteMapping("/delete")
    public ApiResponse delete(@RequestBody Long id){
        return  reviewService.deleteReview(id);
    }
}
