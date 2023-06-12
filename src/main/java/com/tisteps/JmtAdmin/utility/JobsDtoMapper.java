package com.tisteps.JmtAdmin.utility;

import com.tisteps.JmtAdmin.DTO.JobDTO;
import com.tisteps.JmtAdmin.entity.Jobs;

public class JobsDtoMapper {
    public static JobDTO JobsDtoBuilder(Jobs job) {
        return new JobDTO(
                job.getId(),
                job.getJobRole(),
                job.getJobDescription()
        );
    }
}
