package com.tisteps.JmtAdmin.service;

import com.tisteps.JmtAdmin.DTO.JobDTO;
import com.tisteps.JmtAdmin.entity.Jobs;
import com.tisteps.JmtAdmin.exception.JobNotFoundException;
import com.tisteps.JmtAdmin.respository.JobsRepository;
import com.tisteps.JmtAdmin.utility.JobsDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobsServiceImpl implements JobsService{
    //DI the repository layer obj
    @Autowired
    private JobsRepository repository;

    //service method to create job
    @Override
    public JobDTO createJobWithAllDetails(Jobs job) {
        Jobs saved_job = repository.save(job);
        JobDTO jobDTO = JobsDtoMapper.JobsDtoBuilder(saved_job);
        return jobDTO;
    }
    //service method to update job details
    @Override
    public JobDTO updateJobDetails(long id, Jobs job) {
        Optional<Jobs> OptionalJobById = repository.findById(id);
        if(OptionalJobById.isPresent()) {
            Jobs existingJob = OptionalJobById.get();
            existingJob.setJobRole(job.getJobRole());
            existingJob.setJobDescription(job.getJobDescription());
            Jobs saved_job = repository.save(existingJob);
            JobDTO jobDTO = JobsDtoMapper.JobsDtoBuilder(saved_job);
            return jobDTO;
        }
        else throw new JobNotFoundException("Not found");
    }
}
