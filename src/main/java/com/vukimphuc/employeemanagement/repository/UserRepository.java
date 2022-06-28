package com.vukimphuc.employeemanagement.repository;

import com.vukimphuc.employeemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from user where id = ?1 limit 1",nativeQuery = true)
    User getById(Long id);

    User findFirstByUserName(String username);
}
