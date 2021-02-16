package com.jdbcdaofullstk.jdbcdaofullstk.dao;

import com.jdbcdaofullstk.jdbcdaofullstk.model.Department;
import com.jdbcdaofullstk.jdbcdaofullstk.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao implements DepartmentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String insertDepartment(Department department) {
        String sql="insert into department values(?,?)";
        jdbcTemplate.update(sql,new Object[]{department.getId(),
                        department.getName()});
        return "Department added successfully";
    }
}
