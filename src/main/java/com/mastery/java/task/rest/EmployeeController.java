package com.mastery.java.task.rest;


import com.mastery.java.task.dao.model.Employee;
import com.mastery.java.task.rest.mappers.EmployeeMapper;
import com.mastery.java.task.dto.EmployeeDto;
import com.mastery.java.task.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/employee", produces = {"application/json"})
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))

public class EmployeeController {

    @NonNull
    private final EmployeeService employeeService;

    @NonNull
    private final EmployeeMapper employeeMapper;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee() {

        return ResponseEntity.ok(
                employeeMapper.toDto(employeeService.findAll()
                )
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(
            @Valid @PathVariable("id") Employee employee) {

        return ResponseEntity.ok(
                employeeMapper.toDto(employee)
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<EmployeeDto> deleteById(
            @Valid @PathVariable("id") Employee employee) {

        employeeService.delete(employee);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(
            @RequestBody @Valid EmployeeDto employeeDto) {

        return ResponseEntity.ok(
                employeeMapper.toDto(
                        employeeService.save(
                                employeeMapper.toModel(employeeDto)
                        )
                )
        );
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateReportDetail(
            @PathVariable("id") Employee current,
            @Valid @RequestBody EmployeeDto employeeDto) {

        return ResponseEntity.ok(
                employeeMapper.toDto(
                        employeeService.save(
                                employeeMapper.update(current, employeeDto)
                        )
                )
        );
    }
}