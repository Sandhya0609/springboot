package com.sandhya.librarymanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name="employee_id")
    private Integer empId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="hire_date")
    private Date hireDate;

    @Column(name="job_id")
    private Integer jobId;

    @Column(name="email")
    private String email;

    @Column(name="salary")
    private Double salary;




}
