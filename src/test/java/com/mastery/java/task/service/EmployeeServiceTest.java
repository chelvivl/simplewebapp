package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dao.model.Employee;
import com.mastery.java.task.dto.Gender;
import com.mastery.java.task.service.impl.EmployeeServiceImpl;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class EmployeeServiceTest {

    @Mock
    private EmployeeDao employeeDao;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void shouldSavedSuccessfully() {
        MockitoAnnotations.initMocks(this);
        final Employee employee =
                new Employee(
                        "Wendy",
                        "Adams",
                        Gender.MALE,
                        5L,
                        "Customer Service Representative",
                        LocalDate.of(1997, 12, 4)
                );
        given(employeeDao.save(employee)).willAnswer(
                invocationOnMock -> invocationOnMock.getArgument(0));
        Employee savedEmployee = employeeService.save(employee);
        assertThat(savedEmployee, is(IsNull.notNullValue()));
        verify(employeeDao).save(any(Employee.class));
    }

    @Test
    void shouldReturnFindAll() {
        MockitoAnnotations.initMocks(this);
        List<Employee> data = new ArrayList<>();
        data.add(new Employee(
                        "Travis",
                        "Robinson",
                        Gender.MALE,
                        7L,
                        "Sales Manager",
                        LocalDate.of(2002, 8, 15)
                )
        );
        data.add(new Employee(
                        "Jack",
                        "Wood",
                        Gender.MALE,
                        4L,
                        "Marketing Manager",
                        LocalDate.of(1999, 8, 15)
                )
        );
        data.add(new Employee(
                        "Anastasia",
                        "Taylor",
                        Gender.FEMALE,
                        1L,
                        "Executive Assistant",
                        LocalDate.of(1997, 8, 12)
                )
        );
        given(employeeDao.findAll()).willReturn(data);
        List<Employee> expected = (List<Employee>) employeeService.findAll();
        assertEquals(expected, data);
    }

    @Test
    void findById() {
        MockitoAnnotations.initMocks(this);
        final Long id = 1L;
        final Employee employee =
                new Employee(
                        "Anastasia",
                        "Taylor",
                        Gender.FEMALE,
                        1L,
                        "Executive Assistant",
                        LocalDate.of(1997, 8, 12)
                );
        given(employeeDao.findById(id)).willReturn(Optional.of(employee));
        final Employee expected = employeeService.findById(id);
        assertThat(expected, is(IsNull.notNullValue()));
    }
}
