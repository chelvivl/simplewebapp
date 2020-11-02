package com.mastery.java.task.dao.model;

import com.mastery.java.task.dto.Gender;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employee")
public class Employee extends AbstractEntity {

    @Column(nullable = false)
    @Size(min = 1, max = 128)
    private String firstName;

    @Column(nullable = false)
    @Size(min = 1, max = 128)
    private String lastName;

    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private Long departmentId;

    @Column(nullable = false)
    @Size(min = 1, max = 128)
    private String jobTitle;

    @Column(nullable = false)
    private LocalDate dateOfBirth;
}