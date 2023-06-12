package com.tisteps.JmtAdmin.utility;

import com.tisteps.JmtAdmin.DTO.JobAppnDTO;
import com.tisteps.JmtAdmin.entity.JobApplication;

public class JobAppnDtoMapper {
    public static JobAppnDTO jobAppnDtoMapper(JobApplication jobApplication) {
        return new JobAppnDTO(
                jobApplication.getId()
        );
    }
}
