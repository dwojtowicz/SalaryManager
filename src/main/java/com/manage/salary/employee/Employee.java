package com.manage.salary.employee;


import com.manage.salary.employee.detail.EmployeeDetail;
import com.manage.salary.salary.Salary;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "position")
    private String position;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_detail_id")
    private EmployeeDetail employeeDetail;

    @OneToMany(mappedBy = "employee",
    cascade = CascadeType.ALL)
    private List<Salary> salary;



}
