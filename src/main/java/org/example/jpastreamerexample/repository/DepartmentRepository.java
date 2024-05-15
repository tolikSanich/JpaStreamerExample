package org.example.jpastreamerexample.repository;

import org.example.jpastreamerexample.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}