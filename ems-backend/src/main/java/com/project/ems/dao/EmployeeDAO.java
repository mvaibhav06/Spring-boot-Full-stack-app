package com.project.ems.dao;

import com.project.ems.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee getEmployeeById(int theId);

    Employee saveEmployee(Employee employee);

    void deleteById(int id);
}
