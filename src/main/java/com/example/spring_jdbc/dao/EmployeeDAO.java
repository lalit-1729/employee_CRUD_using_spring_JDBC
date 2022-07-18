package com.example.spring_jdbc.dao;

import com.example.spring_jdbc.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    int save(Employee employee);
    int update(Employee employee, int id);
    int delete(int id);

    List<Employee> getAll();
    Employee getEmployeeById(int id);
}
