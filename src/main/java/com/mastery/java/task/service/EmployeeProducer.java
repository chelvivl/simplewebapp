package com.mastery.java.task.service;

import com.mastery.java.task.dao.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmployeeProducer {

    private final JmsTemplate jmsTemplate;

    private final Logger logger = LoggerFactory.getLogger(EmployeeProducer.class);

    @Value("${employee.destination}")
    private String destination;

    public EmployeeProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void addEmployeeAsync(Employee employee) {
        logger.debug("addEmployeeAsync({})", employee);

        jmsTemplate.convertAndSend(destination, employee);
    }
}
