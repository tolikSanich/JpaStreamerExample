package org.example.jpastreamerexample.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Data
@RequiredArgsConstructor
@Entity
//@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String position;
    private int salary;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Organization organization;


}

