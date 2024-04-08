package com.example.springboot.jobs.JobPortal.reviews.Reposistory;

import com.example.springboot.jobs.JobPortal.reviews.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    //findByCompanyId doesn't exist so here we are tell JPA to create a function on runtime. JPA will
    // break down this by checking name like findBy + CompanyID and create a functionality for it
    List<Review> findByCompanyId(Long companyId);

    //JPA will run this query on run time
    //reviewRepository.finByCompanyID(1L)
    // SE;ECT * FROM review WHERE company_id = 1;
}
