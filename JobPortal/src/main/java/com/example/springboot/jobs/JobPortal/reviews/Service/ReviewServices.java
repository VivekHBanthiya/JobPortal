package com.example.springboot.jobs.JobPortal.reviews.Service;

import com.example.springboot.jobs.JobPortal.reviews.Entity.Review;

import java.util.List;

public interface ReviewServices {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyID, Review review);

    Review getReview(Long companyID, Long reviewId);

    boolean updateReview(Long id, Long reviewId, Review review);

    boolean deleteReview(Long id, Long reviewId);
}
