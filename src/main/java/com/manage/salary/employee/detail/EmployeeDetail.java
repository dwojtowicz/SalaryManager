package com.manage.salary.employee.detail;


import com.manage.salary.employee.Employee;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employee_detail")
@Data
public class EmployeeDetail {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 1, message = "is required")
    @Column(name = "city")
    private String city;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Column(name = "street")
    private String street;

    @OneToOne(mappedBy = "employeeDetail",
    fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    Employee employee;


}
