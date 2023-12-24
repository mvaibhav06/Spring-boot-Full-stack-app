package com.project.ems.service;

import com.project.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int theId);

    Employee saveEmployee(Employee employee);

    void deleteEmployeeById(int id);
}
