package org.example.jpastreamerexample.dto;

import org.example.jpastreamerexample.model.Employee;

public record EmployeeWithDetailsDTO(
        Integer id,
        String name,
        String position,
        int salary,
        String organizationName,
        String departmentName
) {
    public EmployeeWithDetailsDTO(Employee emp) {
        this(emp.getId(), emp.getName(), emp.getPosition(), emp.getSalary(),
                emp.getOrganization().getName(),
                emp.getDepartment().getName());
    }
}
