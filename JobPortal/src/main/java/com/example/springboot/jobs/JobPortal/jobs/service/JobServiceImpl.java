package com.example.springboot.jobs.JobPortal.jobs.service;

import com.example.springboot.jobs.JobPortal.jobs.Entity.Jobs;
import com.example.springboot.jobs.JobPortal.jobs.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.*;
@Service
public class JobServiceImpl implements JobService{
//    private List<Jobs> job  = new ArrayList<>(); //we created this arraylist before using repo to save in arraylist
    @Autowired
    JobRepository jobRepository;
    Long nextId = 1L; // to set id as auto increment

    @Override
    public List<Jobs> findAll() {
//        return job; //arraylist
        return jobRepository.findAll(); //using JPA repository
    }

    @Override
    public Jobs findById(Long id) {
//        for(Jobs jobs: job){ //here we were traversing in arraylist to find job by id and then id match we return it
//            if(jobs.getId() == id){
//                return jobs;
//            }
//        }
//        return null;
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public void addJob(Jobs jobs) {
//       jobs.setId(nextId++);//here we are settingid and post inc will increment id each time
//        job.add(jobs); //adding job in arraylist using arraylist method .add
        jobRepository.save(jobs);
    }

    @Override
    public boolean updateById(Long id, Jobs updatedJob) {
        Optional<Jobs> optionalJobs = jobRepository.findById(id);
            if(optionalJobs.isPresent()){
//                Jobs jobs = optionalJobs.get();
                jobRepository.save(updatedJob);
                return true;
            }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
//        Iterator<Jobs> iterator = job.iterator();
//        while (iterator.hasNext()){
//            Jobs jobs = iterator.next();
//            if(jobs.getId() == id){
//                iterator.remove();
//                return true;
//            }
//        }
//        return false;
        try {
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
