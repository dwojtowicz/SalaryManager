package com.manage.salary.salary;


import com.manage.salary.employee.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "salary")
@Data
@NoArgsConstructor
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Min(value = 500, message = "must be greater or equal 500")
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



}

