package com.example.springboot.jobs.JobPortal.jobs.Controller;

import com.example.springboot.jobs.JobPortal.jobs.Entity.Jobs;
import com.example.springboot.jobs.JobPortal.jobs.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Jobs")
public class JobsController
{
    @Autowired
    private JobService jobService;

    //We are using ResponseEntity to have a consistent design instead of using direct class.
    @GetMapping("/all-Jobs")
    public ResponseEntity<List<Jobs>> findAll()
    {
        return new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);
    }

    //In find by id we can't tell user by string why he can't find id if he search wrong id.
    // thats we use ReponseEntity that help us to  custom give Http response to user

    @GetMapping("/{id}")
    public ResponseEntity<Jobs> findById(@PathVariable Long id)
    {
        Jobs jobs = jobService.findById(id);
        if(jobs != null){
            return new ResponseEntity<>(jobs, HttpStatus.OK); // if user found id it will share the data of id with OK http response
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // if not found we will show 404 bad request response
    }

    @PostMapping("/new-Job")
    public ResponseEntity<String> AddJobs(@RequestBody Jobs newJob){
        jobService.addJob(newJob);
        return new ResponseEntity<>("New job added Successfully",HttpStatus.OK);
    }

    @PutMapping("/{id}")
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)   // same work as PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody Jobs updatedJob){
        boolean jobUpdate = jobService.updateById(id, updatedJob);
        if(jobUpdate){
            return new ResponseEntity<>("Id: " +id+ " Updated Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Id: " +id+ " Not Found",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        boolean jobDeleted = jobService.deleteById(id);
        if(jobDeleted){
            return new ResponseEntity<>("Id: " + id + " Deleted Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Id: " + id + " Not found " ,HttpStatus.NOT_FOUND);
    }
}
