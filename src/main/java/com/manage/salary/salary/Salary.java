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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getGrossMonth() {
        return grossMonth;
    }

    public void setGrossMonth(Float grossMonth) {
        this.grossMonth = grossMonth;
    }

    public Float getNetMonth() {
        return netMonth;
    }

    public void setNetMonth(Float netMonth) {
        this.netMonth = netMonth;
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

