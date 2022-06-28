package com.vukimphuc.employeemanagement.service;

import com.vukimphuc.employeemanagement.entity.Submission;

public interface SubmissionService {
    void saveOrUpdate(Submission submission);

    Submission findByUserIDAndWorkID(Long userID, Long workID);
}
