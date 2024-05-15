package org.example.jpastreamerexample.repository;

import com.speedment.jpastreamer.application.JPAStreamer;
import com.speedment.jpastreamer.streamconfiguration.StreamConfiguration;
import lombok.RequiredArgsConstructor;
import org.example.jpastreamerexample.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeStreameRepository {

    @Autowired
    private final JPAStreamer jpaStreamer;

    public List<Employee> findAll() {
        return jpaStreamer.stream(Employee.class).toList();
    }

    public Optional<Employee> findByName(String name) {
        return jpaStreamer.stream(Employee.class)
                .filter(e -> e.getName().equals(name))
                .findFirst();
    }

    public List<Employee> findByDepartment(String department) {
        return jpaStreamer.stream(
                StreamConfiguration
                        .of(Employee.class)
                        .joining(Employee$.department)
                        .joining(Employee$.organization)
        ).filter(e -> e.getDepartment().getName().equals(department))
                .sorted()
                .toList();
    }

}
