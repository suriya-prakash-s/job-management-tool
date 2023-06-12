package com.tisteps.JmtAdmin.service;

import com.tisteps.JmtAdmin.DTO.JobDTO;
import com.tisteps.JmtAdmin.entity.Jobs;


public interface JobsService {
    JobDTO createJobWithAllDetails(Jobs job);
    JobDTO updateJobDetails(long id, Jobs job);
}
