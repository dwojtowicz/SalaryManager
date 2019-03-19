package com.manage.salary.salary;

import com.manage.salary.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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


    public Salary calculateNet(Salary salary, Employee employee) {
        Double tax;
        salary.setEmployee(employee);
        if (employee.getPosition().toLowerCase().equals("manager")) {
            tax = 0.12;
        } else tax = 0.10;
        salary.setTax(tax);
        Double taxedMoney = salary.getGrossMonth() * salary.getTax();
        salary.setNetMonth(salary.getGrossMonth() - taxedMoney);
        if (employee.getPosition().toLowerCase().equals("manager")) {
            salary.setTax(12D);
        } else salary.setTax(10D);

        return salary;
    }


    public Double netTotal(Employee employee){


        List<Salary> salaries = employee.getSalary();
        double sum = salaries.stream().mapToDouble(Salary::getNetMonth).sum();

        return sum;
    }

    @Override
    @Transactional
    public void deleteSalary(Long salaryId) {

        salaryRepository.deleteById(salaryId);
    }

}
