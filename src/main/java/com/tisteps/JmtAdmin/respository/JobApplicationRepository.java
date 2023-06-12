package com.tisteps.JmtAdmin.respository;

import com.tisteps.JmtAdmin.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

/*
* job appn repository interface extends JPArepository*/
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
}
