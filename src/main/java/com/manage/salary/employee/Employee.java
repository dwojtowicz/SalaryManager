package com.manage.salary.employee;


import com.manage.salary.employee.detail.EmployeeDetail;
import com.manage.salary.salary.Salary;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "is required")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "is required")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "position")
    private String position;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_detail_id")
    private EmployeeDetail employeeDetail;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Salary> salary;

    private Double totalNet;
}
