package com.manage.salary.dao;

import com.manage.salary.entity.Employee;

import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> getEmployees() {

        String hql = "FROM Employee ORDER BY firstName";

        Query query = entityManager.createQuery(hql);

        return (List<Employee>) query.getResultList();
    }

    @Override
    public void saveEmployee(Employee theEmployee) {
        entityManager.persist(theEmployee);
    }





}
