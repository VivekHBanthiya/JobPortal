package com.example.springboot.jobs.JobPortal.reviews.Controller;


import com.example.springboot.jobs.JobPortal.reviews.Entity.Review;
import com.example.springboot.jobs.JobPortal.reviews.Service.ReviewServices;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{id}")
@NoArgsConstructor
public class ReviewController {
    @Autowired
    private ReviewServices reviewServices;

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long id){
        return new ResponseEntity<>(reviewServices.getAllReviews(id), HttpStatus.OK);
    }
    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long id,
                          @RequestBody Review review) {
        boolean isReviewSaved = reviewServices.addReview(id, review);
        if (isReviewSaved) {
            return new ResponseEntity<>("Review Added Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review Not Added", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long id,
                                            @PathVariable Long reviewId){
        return new ResponseEntity<>(reviewServices.getReview(id, reviewId), HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long id,
                                               @PathVariable Long reviewId,
                                               @RequestBody Review review) {
        boolean updated = reviewServices.updateReview(id, reviewId, review);
        if (updated) {
           return new ResponseEntity<>("Successfully updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("check url", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id,
                                               @PathVariable Long reviewId){
        boolean deleted = reviewServices.deleteReview(id, reviewId);
        if(deleted){
            return new ResponseEntity<>(reviewId + " delete Successfully ", HttpStatus.OK);
        }
        return new ResponseEntity<>(reviewId + " not found ", HttpStatus.NOT_FOUND);

    }
}
