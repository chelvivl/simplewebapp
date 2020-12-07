package com.mastery.java.task.service;

import com.mastery.java.task.dao.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(Long id);

    void deleteById(Long id);

    Employee save(Employee employee);
}