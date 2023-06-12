package com.tisteps.JmtAdmin.respository;

import com.tisteps.JmtAdmin.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
 * jobs repository interface extends JPArepository*/
public interface JobsRepository extends JpaRepository<Jobs, Long> {
    List<Jobs> findByJobRole(String job_role);
}
