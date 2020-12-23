package com.mastery.java.task.rest;

import com.mastery.java.task.dao.model.Employee;
import com.mastery.java.task.service.EmployeeProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activeMQ/employees")
public class JmsController {

    private final EmployeeProducer employeeProducer;

    private final Logger logger = LoggerFactory.getLogger(JmsController.class);

    public JmsController(EmployeeProducer employeeJmsService) {
        this.employeeProducer = employeeJmsService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee sendEmployee(@RequestBody Employee employee) {
        logger.debug("sendEmployee({})",employee);
        employeeProducer.addEmployeeAsync(employee);
        return employee;
    }
}
