package com.manage.salary.salary;


import com.manage.salary.employee.Employee;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "salary")
@Data
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Salary required")
    @Column(name = "gross_month", nullable = false)
    private Double grossMonth;

    @Column(name = "net_month", nullable = false)
    private Double netMonth;

    @Column(name = "tax", nullable = false)
    private Double tax;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    private Employee employee;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getGrossMonth() {
        return grossMonth;
    }

    public void setGrossMonth(Double grossMonth) {
        this.grossMonth = grossMonth;
    }

    public Double getNetMonth() {
        return netMonth;
    }

    public void setNetMonth(Double netMonth) {
        this.netMonth = netMonth;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

