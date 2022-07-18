package com.example.spring_jdbc.controller;

import com.example.spring_jdbc.dao.EmployeeDAO;
import com.example.spring_jdbc.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping("/employees")
    private List<Employee> getEmployees(){
        return employeeDAO.getAll();
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    private Employee getEmployee(@PathVariable int id){
        return employeeDAO.getEmployeeById(id);
    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    private int addEmployee(@RequestBody Employee employee){
        return employeeDAO.save(employee);
    }

    @RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.PUT)
    private int updateEmployee(@RequestBody  Employee employee, @PathVariable int id){
        return employeeDAO.update(employee, id);
    }

    @RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.DELETE)
    private int deleteEmployee(@PathVariable int id){
        return employeeDAO.delete(id);
    }
}
