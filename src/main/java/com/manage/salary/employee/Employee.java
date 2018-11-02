package com.manage.salary.employee;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "position")
    private String position;

    @Column(name = "gross_month", nullable = false)
    private Float grossMonth;

    @Column(name = "net_month", nullable = false)
    private Float netMonth;

    @Column(name = "salary_total", nullable = false)
    private Float salaryTotal;

    @Column(name = "tax", nullable = false)
    private Integer tax;



}
