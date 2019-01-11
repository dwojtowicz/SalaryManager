package com.manage.salary.employee.detail;


import com.manage.salary.employee.Employee;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employee_detail")
@Data
public class EmployeeDetail {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "street")
    private String street;

    @OneToOne(mappedBy = "employeeDetail",
    fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    Employee employee;

}
