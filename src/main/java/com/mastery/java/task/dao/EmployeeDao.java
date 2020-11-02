package com.mastery.java.task.dao;


import com.mastery.java.task.dao.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends CommonJpaDao<Employee> {
}