package com.manage.salary.salary;

import com.manage.salary.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {

    private SalaryRepository salaryRepository;

    @Autowired
    public SalaryServiceImpl(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    @Override
    @Transactional
    public List<Salary> getSalaries() {
        return salaryRepository.findAll();
    }


    @Override
    @Transactional
    public void save(Salary theSalary) {
        salaryRepository.save(theSalary);
    }


    public Salary calculateNet(Salary theSalary, Employee theEmployee) {
        int tax;
        theSalary.setEmployee(theEmployee);
        if (theEmployee.getPosition().toLowerCase().equals("manager")) {
            tax = 12;
        } else tax = 10;
        theSalary.setTax(tax);
        Double taxedMoney = theSalary.getGrossMonth() / theSalary.getTax();
        theSalary.setNetMonth(theSalary.getGrossMonth() - taxedMoney);

        return theSalary;
    }
}
