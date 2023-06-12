package com.tisteps.JmtAdmin.controller;

import com.tisteps.JmtAdmin.DTO.*;
import com.tisteps.JmtAdmin.entity.JobApplication;
import com.tisteps.JmtAdmin.entity.User;
import com.tisteps.JmtAdmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/api")
public class UserController {

    //DI the service layer object
    @Autowired
    private UserService userService;

    //method to register user info
    @PostMapping("/register-user")
    public ResponseEntity<Object> registerNewUser(@RequestBody User user) {
        UserDTO userDTO = userService.registerUser(user);
        ResponseEntity<Object> createdUser = DtoResponse.responseBuilder("Created", HttpStatus.OK, userDTO);
        return createdUser;
    }
    //method to search job by id
    @GetMapping("/search-job-by-id/{id}")
    public ResponseEntity<Object> searchJobById(@PathVariable("id") long id) {
        JobDTO jobDTO = userService.searchJob(id);
        ResponseEntity<Object> found_job = DtoResponse.responseBuilder("Found", HttpStatus.OK, jobDTO);
        return found_job;
    }
    //method to serach job by role
    @GetMapping("/search-job-by-role")
    public ResponseEntity<Object> searchJobByName(@RequestParam("jobRole") String jobRole) {
        List<JobDTO> jobDTOS = userService.searchJob(jobRole);
        ResponseEntity<Object> found_jobs = DtoResponse.responseBuilder("Found", HttpStatus.OK, jobDTOS);
        return found_jobs;
    }
    //method to apply for jobs
    @PostMapping("/apply-job")
    public ResponseEntity<Object> applyForJob(@RequestBody JobApplication jobApplication) {
        JobAppnDTO jobAppnDTO = userService.applyJob(jobApplication);
        ResponseEntity<Object> jobAppliedDto = DtoResponse.responseBuilder("Applied", HttpStatus.OK, jobAppnDTO);
        return jobAppliedDto;
    }
}
