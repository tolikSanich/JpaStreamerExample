package org.example.jpastreamerexample.repository;

import org.example.jpastreamerexample.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}