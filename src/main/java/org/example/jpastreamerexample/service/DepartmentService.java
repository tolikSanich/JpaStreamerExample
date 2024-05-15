package org.example.jpastreamerexample.service;

import lombok.RequiredArgsConstructor;
import org.example.jpastreamerexample.model.Department;
import org.example.jpastreamerexample.repository.DepartmentRepository;
import org.example.jpastreamerexample.repository.DepartmentStreamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentStreamRepository departmentRepository;
    private final DepartmentStreamRepository departmentStreamRepository;

    public Set<Department> findAll() {
        return departmentStreamRepository.findAll();
    }
}
