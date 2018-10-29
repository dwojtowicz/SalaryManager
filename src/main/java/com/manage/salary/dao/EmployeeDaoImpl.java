package com.manage.salary.dao;

import com.manage.salary.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> getEmployees() {

        String hql = "FROM Employee ORDER BY firstName";

        return (List<Employee>) entityManager.createQuery(hql).getResultList();
    }
}
