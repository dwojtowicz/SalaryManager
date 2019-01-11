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
        Double tax;
        theSalary.setEmployee(theEmployee);
        if (theEmployee.getPosition().toLowerCase().equals("manager")) {
            tax = 0.12;
        } else tax = 0.10;
        theSalary.setTax(tax);
        Double taxedMoney = theSalary.getGrossMonth() * theSalary.getTax();
        theSalary.setNetMonth(theSalary.getGrossMonth() - taxedMoney);
        if (theEmployee.getPosition().toLowerCase().equals("manager")) {
            theSalary.setTax(12D);
        } else theSalary.setTax(10D);

        return theSalary;
    }

    @Override
    @Transactional
    public void deleteSalary(Long salaryId) {

        salaryRepository.deleteById(salaryId);

    }
}
