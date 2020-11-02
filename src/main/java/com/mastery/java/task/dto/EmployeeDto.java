package com.mastery.java.task.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Employee resource")
public class EmployeeDto extends AbstractDto {

    @ApiModelProperty(value = "Id", example = "1")
    private Long id;

    @NotNull
    @Size(min = 1, max = 128)
    @ApiModelProperty(value = "First name", example = "Philip")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 128)
    @ApiModelProperty(value = "Last name", example = "Green")
    private String lastName;

    @NotNull
    @ApiModelProperty(value = "Gender", example = "MALE")
    private Gender gender;

    @NotNull
    @ApiModelProperty(value = "department's id", example = "7")
    private Long departmentId;

    @NotNull
    @Size(min = 1, max = 128)
    @ApiModelProperty(value = "Job Title", example = "Software Engineer")
    private String jobTitle;

    @NotNull
    @ApiModelProperty(value = "Date of Birth", example = "2020-04-23")
    private LocalDate dateOfBirth;
}