package com.manage.salary;


import com.manage.salary.employee.Employee;
import com.manage.salary.employee.EmployeeRepository;
import com.manage.salary.employee.EmployeeService;
import com.manage.salary.employee.EmployeeServiceImpl;
import com.manage.salary.salary.Salary;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeServiceImplTest {


    @Test
    public void setUp(){
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("Jan");
        Assert.assertEquals(employee.getFirstName(), "Jan");
    }
}

