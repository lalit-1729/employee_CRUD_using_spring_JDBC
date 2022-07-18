package com.example.spring_jdbc.dao;

import com.example.spring_jdbc.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    JdbcTemplate jdbcTemplate; // JDBCTemplate helps us to connect of database and make to query the database

    @Override
    public int save(Employee employee) {
        return jdbcTemplate.update("INSERT INTO employee_table (name, email, department)  VALUES (?, ?, ?)",
                employee.getName(), employee.getEmail(), employee.getDepartment());
    }

    @Override
    public int update(Employee employee, int id) {
        return jdbcTemplate.update("UPDATE employee_table SET name=?, email = ?, department = ? where id = ?", employee.getName(), employee.getEmail(), employee.getDepartment(), id);
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE  from employee_table where id = ?", id);
    }

    @Override
    public List<Employee> getAll() {
       return  jdbcTemplate.query("SELECT * FROM employee_table", new BeanPropertyRowMapper<>(Employee.class));
    }

    @Override
    public Employee getEmployeeById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM employee_table WHERE id=?", new BeanPropertyRowMapper<>(Employee.class), id);
    }
}
