package com.vukimphuc.employeemanagement.repository;

import com.vukimphuc.employeemanagement.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {
    @Query(value = "select * from work where user_id = ?1 order by done", nativeQuery = true)
    List<Work> findAllByUserId(Long id);

    Work getAllById(Long id);

}
