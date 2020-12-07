package com.mastery.java.task.rest;


import com.mastery.java.task.dto.EmployeeDto;
import com.mastery.java.task.rest.mappers.EmployeeMapper;
import com.mastery.java.task.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/employee", produces = {"application/json"})
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
@Api(tags = "Employee", description = "Employee Management System")
@ApiResponses(value = {
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal Server Error ")
})
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;
    private final Logger logger = Logger.getLogger(EmployeeController.class);

    @ApiResponse(code = 200, message = "Success ")
    @ApiOperation(value = "View a list of available employees")
    @GetMapping
    public List<EmployeeDto> getAllEmployee() {
        logger.debug("get all employees");
        return employeeMapper.toDto(employeeService.findAll());
    }

    @ApiOperation(value = "Get a employee by Id")
    @ApiResponse(code = 200, message = "Success ")
    @GetMapping("{id}")
    public EmployeeDto getEmployeeById(
            @PathVariable("id") Long id) {
        logger.debug("get employee by id");
        return employeeMapper.toDto(employeeService.findById(id));
    }

    @ApiOperation(value = "Delete a employee by Id")
    @ApiResponse(code = 204, message = "No content ")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteById(
            @Valid @PathVariable("id") Long id) {
        logger.debug("delete employee by id");
        employeeService.deleteById(id);
    }

    @ApiOperation(value = "Add a employee")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created "),
            @ApiResponse(code = 400, message = "Bad request "),
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public EmployeeDto createEmployee(
            @RequestBody @Valid EmployeeDto employeeDto) {

        logger.debug("create new employee");
        return employeeMapper.toDto(
                employeeService.save(
                        employeeMapper.toModel(employeeDto)
                )
        );
    }

    @ApiOperation(value = "Update a Feature by Id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success "),
            @ApiResponse(code = 400, message = "Bad request ")
    })
    @PutMapping("{id}")
    public EmployeeDto updateEmployee(
            @PathVariable("id") Long id,
            @Valid @RequestBody EmployeeDto employeeDto) {

        logger.debug("update an employee by id");
        return employeeMapper.toDto(
                employeeService.save(
                        employeeMapper.update(employeeService.findById(id), employeeDto)
                )
        );
    }
}