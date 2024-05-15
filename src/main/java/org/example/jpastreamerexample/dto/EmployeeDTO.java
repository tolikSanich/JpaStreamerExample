package org.example.jpastreamerexample.dto;

import org.example.jpastreamerexample.model.Employee;

public record  EmployeeDTO (
        Integer id,
        String name,
        String position,
        int salary
) {
    public EmployeeDTO(Employee emp) {
        this(emp.getId(), emp.getName(), emp.getPosition(), emp.getSalary());
    }
}