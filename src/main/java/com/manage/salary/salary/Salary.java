package com.manage.salary.salary;


import com.manage.salary.employee.Employee;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "salary")
@Data
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "gross_month", nullable = false)
    private Float grossMonth;

    @Column(name = "net_month", nullable = false)
    private Float netMonth;

    @Column(name = "tax", nullable = false)
    private Integer tax;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;


}

