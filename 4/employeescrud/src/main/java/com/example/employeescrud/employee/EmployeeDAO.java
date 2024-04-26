package com.example.employeescrud.employee;

import java.util.List;

public interface EmployeeDAO {
    
    public List<Employee> findAll();

    public Employee findById(int id);

    public Employee save(Employee employee);

    public void delete(int id);
}
