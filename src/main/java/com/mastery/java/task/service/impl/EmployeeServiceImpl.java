package com.mastery.java.task.service.impl;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dao.model.Employee;
import com.mastery.java.task.service.AbstractCrudServiceImpl;
import com.mastery.java.task.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl
        extends AbstractCrudServiceImpl<Employee>
        implements EmployeeService {

    public EmployeeServiceImpl(EmployeeDao repository) {
        super(repository);
    }
}