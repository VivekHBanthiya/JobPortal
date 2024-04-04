package com.example.springboot.jobs.JobPortal.jobs.service;

import com.example.springboot.jobs.JobPortal.jobs.Entity.Jobs;

import java.util.List;

public interface JobService {

    List<Jobs> findAll();

    Jobs findById(Long id);

    void addJob(Jobs jobs);

    boolean updateById(Long id, Jobs updatedJob);

    boolean deleteById(Long id);
}
