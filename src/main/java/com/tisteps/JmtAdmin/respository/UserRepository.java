package com.tisteps.JmtAdmin.respository;

import com.tisteps.JmtAdmin.entity.Jobs;
import com.tisteps.JmtAdmin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/*
 * user repository interface extends JPArepository*/
public interface UserRepository extends JpaRepository<User, Long> {

}
