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
    public void saveEmployee(Employee theEmployee) {
        employeeRepository.save(theEmployee);

    }

    @Override
    @Transactional
    public Employee getEmployeeById(Long theId){
       return employeeRepository.findById(theId).get();
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
