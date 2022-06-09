package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EmployeeDAOJoaImpl implements EmployeeDAO{
   private EntityManager entityManager;

    public EmployeeDAOJoaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Autowired
@Override
    public List<Employee> findAll() {
        Query theQuery =entityManager.createQuery("from Employee");
        List<Employee> employees = theQuery.getResultList();




        return employees;

    }

    @Override
    public Employee findById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class,theId);
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);
        theEmployee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int theId) {
            Query theQuery = entityManager.createQuery("delete from Employee where id =:employeeId");
            theQuery.setParameter("employeeId" ,theId);
            theQuery.executeUpdate();
    }
}
