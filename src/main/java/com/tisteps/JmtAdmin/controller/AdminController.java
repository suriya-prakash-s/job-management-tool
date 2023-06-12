package com.tisteps.JmtAdmin.controller;

import com.tisteps.JmtAdmin.DTO.DtoResponse;
import com.tisteps.JmtAdmin.DTO.JobDTO;
import com.tisteps.JmtAdmin.entity.Jobs;
import com.tisteps.JmtAdmin.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/api")
public class AdminController {

    //DI the service layer object
    @Autowired
    private JobsService service;

    //method to create job
    @PostMapping("/create-job")
    public ResponseEntity<Object> createJob(@RequestBody Jobs job) {
        JobDTO jobWithAllDetails = service.createJobWithAllDetails(job);
        ResponseEntity<Object> saved = DtoResponse.responseBuilder("Saved", HttpStatus.OK, jobWithAllDetails);
        return saved;
    }

    //method to update job
    @PutMapping("/update-job")
    public ResponseEntity<Object> updatejob(@RequestBody Jobs job) {
        JobDTO jobWithAllDetails = service.updateJobDetails(job.getId(), job);
        ResponseEntity<Object> saved = DtoResponse.responseBuilder("Saved", HttpStatus.OK, jobWithAllDetails);
        return saved;
    }
}
