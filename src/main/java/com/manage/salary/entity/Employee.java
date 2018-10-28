package com.manage.salary.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "position")
    private String position;

    @Column(name = "gross_month")
    private float grossMonth;

    @Column(name = "net_month")
    private float netMonth;

    @Column(name = "salary_total")
    private float salaryTotal;

    @Column(name = "tax")
    private int tax;

    @Column(name = "work_hours")
    private int workHours;

    public Employee(){

    }

    public Employee(String firstName, String lastName, String position, float grossMonth, float netMonth, float salaryTotal, int tax, int workHours) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.grossMonth = grossMonth;
        this.netMonth = netMonth;
        this.salaryTotal = salaryTotal;
        this.tax = tax;
        this.workHours = workHours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public float getGrossMonth() {
        return grossMonth;
    }

    public void setGrossMonth(float grossMonth) {
        this.grossMonth = grossMonth;
    }

    public float getNetMonth() {
        return netMonth;
    }

    public void setNetMonth(float netMonth) {
        this.netMonth = netMonth;
    }

    public float getSalaryTotal() {
        return salaryTotal;
    }

    public void setSalaryTotal(float salaryTotal) {
        this.salaryTotal = salaryTotal;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", grossMonth=" + grossMonth +
                ", netMonth=" + netMonth +
                ", salaryTotal=" + salaryTotal +
                ", tax=" + tax +
                ", workHours=" + workHours +
                '}';
    }
}
