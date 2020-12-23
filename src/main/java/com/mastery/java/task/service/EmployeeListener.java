package com.mastery.java.task.service;

import com.mastery.java.task.dao.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class EmployeeListener {

    private final EmployeeService employeeService;

    private final Logger logger = LoggerFactory.getLogger(EmployeeProducer.class);

    public EmployeeListener(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @JmsListener(destination = "#{'${employee.destination}'}")
    public void onMessage(Employee employee) {
        logger.debug("onMessage({})", employee);

        employeeService.save(employee);
    }
}
