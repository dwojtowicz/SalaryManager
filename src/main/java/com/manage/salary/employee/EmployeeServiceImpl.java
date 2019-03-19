package com.manage.salary.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


  private EmployeeRepository employeeRepository;



    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        return employeeRepository.findAll(orderByLastName());
    }

    @Override
    @Transactional
    public void saveOrUpdateEmployee(Employee theEmployee) {

        if (theEmployee.getId() != null){
            Employee emp = employeeRepository.getOne(theEmployee.getId());
            emp.setFirstName(theEmployee.getFirstName());
            emp.setLastName(theEmployee.getLastName());
            emp.setPosition(theEmployee.getPosition());
            employeeRepository.save(emp);
        } else
        employeeRepository.save(theEmployee);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(Long employeeId){
       return employeeRepository.findById(employeeId).orElse(null);
    }

    @Override
    @Transactional
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }


    private Sort orderByLastName(){
        return new Sort(Sort.Direction.ASC, "lastName");
    }




}

