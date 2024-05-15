package org.example.jpastreamerexample.service;

import com.speedment.jpastreamer.application.JPAStreamer;
import org.example.jpastreamerexample.model.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;


    @Test
    void findAll() {
        Set<Department> all = departmentService.findAll();
        System.out.println(all);
    }

}