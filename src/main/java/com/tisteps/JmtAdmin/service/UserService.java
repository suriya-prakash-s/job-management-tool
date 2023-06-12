package com.tisteps.JmtAdmin.service;

import com.tisteps.JmtAdmin.DTO.JobAppnDTO;
import com.tisteps.JmtAdmin.DTO.JobDTO;
import com.tisteps.JmtAdmin.DTO.UserDTO;
import com.tisteps.JmtAdmin.entity.JobApplication;
import com.tisteps.JmtAdmin.entity.User;

import java.util.List;

public interface UserService {
    UserDTO registerUser(User user);
    JobDTO searchJob(long id);
    List<JobDTO> searchJob(String job_role);
    JobAppnDTO applyJob(JobApplication jobApplication);
}
