package org.example.jpastreamerexample.repository;

import com.speedment.jpastreamer.application.JPAStreamer;
import com.speedment.jpastreamer.streamconfiguration.StreamConfiguration;
import org.example.jpastreamerexample.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.speedment.jpastreamer.field.collector.FieldCollectors.groupingBy;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toMap;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeStreameRepositoryTest {

    @Autowired
    private EmployeeStreameRepository employeeStreameRepository;
    @Autowired
    private JPAStreamer jpaStreamer;

    @Test
    void findAll() {
        List<Employee> all = employeeStreameRepository.findAll();
        System.out.println(all);
    }

    @Test
    void findByName() {
        Optional<Employee> test1 = employeeStreameRepository.findByName("Test1");
        System.out.println(test1.get());
    }

    @Test
    void findByDepartment() {
        List<Employee> test1 = employeeStreameRepository.findByDepartment("Salary");
        System.out.println(test1);
    }

    @Test
    void test() {
        var filmCategories = jpaStreamer.stream(Employee.class)
                .collect(
                        groupingBy(
                                Employee$.position
                ));
        System.out.println(filmCategories);
    }
    @Test
    void test12() {
        Map<Department, List<Employee>> filmCategories = jpaStreamer.stream(StreamConfiguration.of(Department.class).joining(
                        Department$.employees
                ) )
                .collect(
                        toMap(Function.identity(), Department::getEmployees
                        ));
        filmCategories.forEach(
                (k, v) -> System.out.format("%s: %s\n",
                        k.getName(),
                        v
                )
        );
    }

    @Test
    void test123() {
        Optional<Employee> test1 = jpaStreamer.stream(Employee.class)
                .filter(Employee$.name.in("Test2"))
                .findFirst();
        test1.ifPresent(System.out::println);

    }

    @Test
    void testGroupBy() {
        Map<String, List<Employee>> filmCategories = jpaStreamer.stream(Employee.class)
                .collect(
                        Collectors.groupingBy(
                                Employee$.position
                        )
                )
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 3)
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue)
                );
        System.out.println(filmCategories);
    }

    @Test
    void testDistinct() {
        Set<String> ratings = jpaStreamer.stream(Employee.class)
                .map(Employee$.position)
                .collect(Collectors.toSet());
        System.out.println(ratings);
    }

    @Test
    void testUnion() {
        Stream.of(
                        jpaStreamer.stream(Employee.class).filter(Employee$.age.greaterThan(35)),
                        jpaStreamer.stream(
                                StreamConfiguration
                                        .of(Employee.class)
                                        .joining(Employee$.department))
                                .filter(Employee$.position.equal("Developer"))
                )
                .flatMap(Function.identity())
                .distinct()
                .forEachOrdered(System.out::println);
    }

    @Test
    void testManyToOne() {
        Map<Employee, Organization> employeeslanguageMap = jpaStreamer.stream(
                StreamConfiguration.of(Employee.class).joining(Employee$.organization))
//                .filter(e -> e.getPosition().equals("Developer"))
                .filter(Employee$.position.equalIgnoreCase("Developer"))
                .collect(
                        Collectors.toMap(Function.identity(),
                                Employee::getOrganization
                        )
                );
        System.out.println(employeeslanguageMap);
    }
    void testPivotDemo() {

    }
}