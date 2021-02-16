package com.jdbcdaofullstk.jdbcdaofullstk.controller;

import com.jdbcdaofullstk.jdbcdaofullstk.model.Department;
import com.jdbcdaofullstk.jdbcdaofullstk.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping("/saveDepartment")
    public String addDepartment(@RequestBody Department department){
        return departmentRepository.insertDepartment(department);
    }
}
