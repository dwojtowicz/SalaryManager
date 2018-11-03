package com.manage.salary.employee.detail;


import com.manage.salary.employee.Employee;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "employee_detail")
@Data
public class EmployeeDetail {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    String street;

    @OneToOne(mappedBy = "employeeDetail",
    cascade = CascadeType.ALL)
    private Employee employee;
}
