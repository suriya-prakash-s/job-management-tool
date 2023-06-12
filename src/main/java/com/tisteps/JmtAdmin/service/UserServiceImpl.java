package com.tisteps.JmtAdmin.service;

import com.tisteps.JmtAdmin.DTO.JobAppnDTO;
import com.tisteps.JmtAdmin.DTO.JobDTO;
import com.tisteps.JmtAdmin.DTO.UserDTO;
import com.tisteps.JmtAdmin.entity.JobApplication;
import com.tisteps.JmtAdmin.entity.Jobs;
import com.tisteps.JmtAdmin.entity.User;
import com.tisteps.JmtAdmin.exception.JobNotFoundException;
import com.tisteps.JmtAdmin.respository.JobApplicationRepository;
import com.tisteps.JmtAdmin.respository.JobsRepository;
import com.tisteps.JmtAdmin.respository.UserRepository;
import com.tisteps.JmtAdmin.utility.JobAppnDtoMapper;
import com.tisteps.JmtAdmin.utility.JobsDtoMapper;
import com.tisteps.JmtAdmin.utility.UserDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    //DI the repository layers object
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobsRepository jobsRepository;

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    //method to register user
    @Override
    public UserDTO registerUser(User user) {
        User saved_user = userRepository.save(user);
        UserDTO userDTO = UserDtoMapper.userDtoMapper(saved_user);
        return userDTO;
    }
    //method to search job with id
    @Override
    public JobDTO searchJob(long id) {
        Optional<Jobs> optionalJobById = jobsRepository.findById(id);
        if (optionalJobById.isPresent()) {
            Jobs job = optionalJobById.get();
            JobDTO jobDTO = JobsDtoMapper.JobsDtoBuilder(job);
            return jobDTO;
        }
        else throw new JobNotFoundException("Not found");
    }
    //method to search job with role name
    @Override
    public List<JobDTO> searchJob(String job_role) {
        List<Jobs> jobs = jobsRepository.findByJobRole(job_role);
        if (!jobs.isEmpty()) {
            List<JobDTO> jobDtos = jobs.stream().map(job -> JobsDtoMapper.JobsDtoBuilder(job)).collect(Collectors.toList());
            return jobDtos;
        }
        else throw new JobNotFoundException("Not Found");
    }
    //method to apply for a job
    @Override
    public JobAppnDTO applyJob(JobApplication jobApplication) {
        if(
                jobsRepository.findById(jobApplication.getJob_id()).isPresent() &&
                        userRepository.findById(jobApplication.getUser_id()).isPresent()) {
            JobApplication save_appn = jobApplicationRepository.save(jobApplication);
            JobAppnDTO jobAppnDTO = JobAppnDtoMapper.jobAppnDtoMapper(save_appn);
            return jobAppnDTO;
        }
        else throw new JobNotFoundException("Either job or user is not present");

    }
}
