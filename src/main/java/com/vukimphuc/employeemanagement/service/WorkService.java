package com.vukimphuc.employeemanagement.service;

import com.vukimphuc.employeemanagement.entity.Work;

import java.util.List;

public interface WorkService {
    void saveOrUpdate(Work work);

    List<Work> getAllById(Long id);

    void updateStatus(Work work);

    Work findById(Long id);

    void deleteById(Long id);
}
