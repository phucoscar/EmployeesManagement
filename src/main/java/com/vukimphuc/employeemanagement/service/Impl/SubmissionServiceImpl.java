package com.vukimphuc.employeemanagement.service.Impl;

import com.vukimphuc.employeemanagement.entity.Submission;
import com.vukimphuc.employeemanagement.repository.SubmissionRepository;
import com.vukimphuc.employeemanagement.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionServiceImpl implements SubmissionService {
    @Autowired
    private SubmissionRepository submissionRepository;

    @Override
    public void saveOrUpdate(Submission submission) {
        submissionRepository.save(submission);
    }

    @Override
    public Submission findByUserIDAndWorkID(Long userID, Long workID) {
        return submissionRepository.findFirstByUserIDAndWorkID(userID, workID).get(0);
    }
}
