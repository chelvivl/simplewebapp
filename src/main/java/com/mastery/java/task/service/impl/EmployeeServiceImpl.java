package com.mastery.java.task.service.impl;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dao.model.Employee;
import com.mastery.java.task.exception.EmployeeServiceException;
import com.mastery.java.task.exception.NotFoundEmployeeServiceException;
import com.mastery.java.task.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;


    @Override
    public List<Employee> findAll() {
        try {
            List<Employee> employees = StreamSupport
                    .stream(
                            employeeDao.findAll().spliterator(), false)
                    .collect(Collectors.toList());
            if (employees.isEmpty()) {
                throw new NotFoundEmployeeServiceException("Employees not found");
            }
            return employees;
        } catch (DataAccessException ex) {
            throw new EmployeeServiceException("Couldn't get employees", ex);
        }
    }

    @Override
    public Employee findById(Long id) {
        try {
            return employeeDao.findById(id)
                    .orElseThrow(() ->
                            new NotFoundEmployeeServiceException("Employee with id " + id + " not found"));
        } catch (DataAccessException e) {
            throw new EmployeeServiceException("Couldn't get employee by id", e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            employeeDao.deleteById(id);
        } catch (DataAccessException ex) {
            throw new EmployeeServiceException("Couldn't delete employee by id", ex);
        }
    }

    @Override
    public Employee save(Employee employee) {
        try {
            return employeeDao.save(employee);
        } catch (DataAccessException ex) {
            throw new EmployeeServiceException("Error while saving employee", ex);
        }
    }
}