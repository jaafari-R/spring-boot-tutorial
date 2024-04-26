package com.example.employeescrud.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        return employeeService.findById(employeeId);
    }

    @PostMapping("/")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    // @ResponseStatus() // 204
    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        employeeService.delete(employeeId);
    }
}
