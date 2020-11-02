package com.mastery.java.task.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto extends AbstractDto {

    private Long id;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Gender gender;
    @NotNull
    private Long departmentId;
    @NotNull
    private String jobTitle;
    @NotNull
    private LocalDate dateOfBirth;
}