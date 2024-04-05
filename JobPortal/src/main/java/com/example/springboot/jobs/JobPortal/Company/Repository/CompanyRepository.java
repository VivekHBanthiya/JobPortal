package com.example.springboot.jobs.JobPortal.Company.Repository;

import com.example.springboot.jobs.JobPortal.Company.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
