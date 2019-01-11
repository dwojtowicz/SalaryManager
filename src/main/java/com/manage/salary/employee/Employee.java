package com.manage.salary.employee;


import com.manage.salary.employee.detail.EmployeeDetail;
import com.manage.salary.salary.Salary;
import lombok.Data;
import lombok.NonNull;

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Salary> salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public EmployeeDetail getEmployeeDetail() {
        return employeeDetail;
    }

    public void setEmployeeDetail(EmployeeDetail employeeDetail) {
        this.employeeDetail = employeeDetail;
    }

    public List<Salary> getSalary() {
        return salary;
    }

    public void setSalary(List<Salary> salary) {
        this.salary = salary;
    }
}
