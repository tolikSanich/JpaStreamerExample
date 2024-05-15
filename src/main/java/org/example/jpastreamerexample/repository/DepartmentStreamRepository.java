package org.example.jpastreamerexample.repository;

import com.speedment.jpastreamer.application.JPAStreamer;
import lombok.RequiredArgsConstructor;
import org.example.jpastreamerexample.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class DepartmentStreamRepository {

    @Autowired
    private final JPAStreamer jpaStreamer;


    public Set<Department> findAll() {
        return jpaStreamer.stream(Department.class)
                .collect(Collectors.toSet());
    }
}
