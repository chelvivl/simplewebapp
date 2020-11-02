package com.mastery.java.task.rest;


import com.mastery.java.task.dao.model.Employee;
import com.mastery.java.task.dto.EmployeeDto;
import com.mastery.java.task.rest.mappers.EmployeeMapper;
import com.mastery.java.task.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(tags = "Employee", description = "Employee Management System")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
})
public class EmployeeController {

    @NonNull
    private final EmployeeService employeeService;

    @NonNull
    private final EmployeeMapper employeeMapper;

    @ApiResponse(code = 200, message = "Success",
            response = EmployeeDto.class, responseContainer = "List")
    @ApiOperation(value = "View a list of available employees")
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee() {

        return ResponseEntity.ok(
                employeeMapper.toDto(employeeService.findAll()
                )
        );
    }

    @ApiOperation(value = "Get a employee by Id")
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(
            @Valid @PathVariable("id") Employee employee) {

        return ResponseEntity.ok(
                employeeMapper.toDto(employee)
        );
    }

    @ApiOperation(value = "Delete a employee by Id")
    @DeleteMapping("{id}")
    public ResponseEntity<EmployeeDto> deleteById(
            @Valid @PathVariable("id") Employee employee) {

        employeeService.delete(employee);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Add a employee")
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

    @ApiOperation(value = "Update a Feature by Id")
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