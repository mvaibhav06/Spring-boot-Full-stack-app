package com.project.ems.rest;

import com.project.ems.dao.EmployeeDAO;
import com.project.ems.dao.EmployeeDAOImpl;
import com.project.ems.entity.Employee;
import com.project.ems.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeServiceImpl service;

    public EmployeeRestController(EmployeeServiceImpl employeeService){
        service = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> get_allEmployees(){
        return service.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        Employee employee = service.findById(employeeId);
        if (employee==null){
            throw new RuntimeException("Employee with Id not found: " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return service.saveEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public Employee deleteEmployeeById(@PathVariable int employeeId){
        Employee employee = service.findById(employeeId);

        if (employee == null){
            throw new RuntimeException("Employee doesn't exist");
        }

        service.deleteEmployeeById(employeeId);
        return employee;
    }
}
