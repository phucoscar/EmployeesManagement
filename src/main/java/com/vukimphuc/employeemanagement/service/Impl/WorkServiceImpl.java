package com.vukimphuc.employeemanagement.service.Impl;

import com.vukimphuc.employeemanagement.entity.Work;
import com.vukimphuc.employeemanagement.repository.WorkRepository;
import com.vukimphuc.employeemanagement.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {
    @Autowired
    private WorkRepository workRepository;


    @Override
    public void saveOrUpdate(Work work) {
        workRepository.save(work);
    }

    @Override
    public List<Work> getAllById(Long id) {
        return workRepository.findAllByUserId(id);
    }

    @Override
    public void updateStatus(Work work) {
        work.setDone(1);
        workRepository.save(work);
    }

    @Override
    public Work findById(Long id) {
        return workRepository.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        workRepository.deleteById(id);
    }
}
