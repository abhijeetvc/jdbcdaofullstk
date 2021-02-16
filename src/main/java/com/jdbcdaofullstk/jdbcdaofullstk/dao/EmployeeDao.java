package com.jdbcdaofullstk.jdbcdaofullstk.dao;

import com.jdbcdaofullstk.jdbcdaofullstk.model.Employee;
import com.jdbcdaofullstk.jdbcdaofullstk.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

//@Component, @Repository, @Service

@Repository
public class EmployeeDao implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String saveEmployee(Employee employee) {
        String sql="insert into employee values(?,?,?)";
        jdbcTemplate.update(sql,new Object[]{employee.getId(),
                employee.getName(),employee.getCity()});

        return "Employee added successfully...";
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql="select * from employee";
        List<Employee> list=jdbcTemplate.query(sql,new BeanPropertyRowMapper(Employee.class));
        return list;
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        String sql="select * from employee where id=?";
        Employee employee= (Employee) jdbcTemplate.queryForObject(sql,new Object[]{id},
                new int[]{Types.INTEGER},
                new BeanPropertyRowMapper(Employee.class));
        return employee;
    }

    @Override
    public String deleteEmployee(Integer id) {
        String sql="delete from employee where id=?";
        jdbcTemplate.update(sql,new Object[]{id});
        return "Update Employee";
    }
}
