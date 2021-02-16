package com.jdbcdaofullstk.jdbcdaofullstk.controller;

import com.jdbcdaofullstk.jdbcdaofullstk.dao.EmployeeDao;
import com.jdbcdaofullstk.jdbcdaofullstk.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @PostMapping("/save")
    public String saveEmployee(@RequestBody Employee employee){
        return employeeDao.saveEmployee(employee);
    }

    @GetMapping("/getallemployees")
    public List<Employee> getEmployeeList(){
        return employeeDao.getAllEmployees();
    }

    @GetMapping("/getemployee/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        return employeeDao.getEmployeeById(id);
    }

    @DeleteMapping("/deleteemployee/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        return employeeDao.deleteEmployee(id);
    }
}
