package com.example.springboot.jobs.JobPortal.jobs.Repository;

import com.example.springboot.jobs.JobPortal.jobs.Entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Jobs, Long> {

}
