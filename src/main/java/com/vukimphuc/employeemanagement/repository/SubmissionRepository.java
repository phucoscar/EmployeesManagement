package com.vukimphuc.employeemanagement.repository;

import com.vukimphuc.employeemanagement.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {

    @Query(value = "select * from submission where user_id = ?1 and work_id =?2", nativeQuery = true)
    List<Submission> findFirstByUserIDAndWorkID(Long userId, Long workID);
}
