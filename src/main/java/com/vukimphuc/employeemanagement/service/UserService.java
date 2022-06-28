package com.vukimphuc.employeemanagement.service;

import com.vukimphuc.employeemanagement.entity.User;

import java.util.List;

public interface UserService {
    void saveOrUpdate(User user);

    List<User> getAll();

    User findById(Long id);

    void deleteById(Long id);
}
