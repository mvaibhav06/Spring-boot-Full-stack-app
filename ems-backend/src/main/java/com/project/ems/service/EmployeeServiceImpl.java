package com.project.ems.service;

import com.project.ems.dao.EmployeeDAOImpl;
import com.project.ems.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAOImpl dao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAOImpl employeeDAO){
        dao = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return dao.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return dao.getEmployeeById(theId);
    }

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
        return dao.saveEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int id) {
        dao.deleteById(id);
    }
}
