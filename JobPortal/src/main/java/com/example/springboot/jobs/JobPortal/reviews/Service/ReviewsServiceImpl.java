package com.example.springboot.jobs.JobPortal.reviews.Service;

import com.example.springboot.jobs.JobPortal.Company.Entity.Company;
import com.example.springboot.jobs.JobPortal.Company.Service.CompanyServices;
import com.example.springboot.jobs.JobPortal.reviews.Entity.Review;
import com.example.springboot.jobs.JobPortal.reviews.Reposistory.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsServiceImpl implements ReviewServices{

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private CompanyServices companyServices;

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyID, Review review) {
        Company company = companyServices.getCompanyById(companyID);
        if(company != null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long companyID, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyID);
        return  reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReview(Long id, Long reviewId, Review review) {
        if(companyServices.getCompanyById(id) != null){
            review.setCompany(companyServices.getCompanyById(id));
            review.setId(reviewId);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    public boolean deleteReview(Long id, Long reviewID){
        if(companyServices.getCompanyById(id) != null && reviewRepository.existsById(reviewID)){
            Review review = reviewRepository.findById(reviewID).orElse(null);
            Company company = review.getCompany();
            company.getReview().remove(review);
            companyServices.updateCompany(company, id);
            reviewRepository.deleteById(reviewID);
            return true;
        }
        return false;
    }
}
