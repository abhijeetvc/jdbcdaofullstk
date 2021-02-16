package com.jdbcdaofullstk.jdbcdaofullstk.repository;

import com.jdbcdaofullstk.jdbcdaofullstk.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    String saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);

    String deleteEmployee(Integer id);
}
