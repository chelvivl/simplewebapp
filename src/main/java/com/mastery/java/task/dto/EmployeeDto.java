package com.mastery.java.task.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Builder
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

    public EmployeeDto() {
    }

    public EmployeeDto(Long id,
                       @NotNull @Size(min = 1, max = 128) String firstName,
                       @NotNull @Size(min = 1, max = 128) String lastName,
                       @NotNull Gender gender, @NotNull Long departmentId,
                       @NotNull @Size(min = 1, max = 128) String jobTitle,
                       @NotNull LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.departmentId = departmentId;
        this.jobTitle = jobTitle;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}