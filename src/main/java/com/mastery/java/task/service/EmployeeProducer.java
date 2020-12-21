package com.mastery.java.task.service;

import com.mastery.java.task.dao.model.Employee;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmployeeProducer {

    private final JmsTemplate jmsTemplate;

    private final Logger logger = Logger.getLogger(EmployeeProducer.class);

    @Value("${employee.destination}")
    private String destination;

    public EmployeeProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void addEmployeeAsync(Employee employee) {
        logger.debug("addEmployeeAsync(" + employee + ")");

        jmsTemplate.convertAndSend(destination, employee);
    }
}
