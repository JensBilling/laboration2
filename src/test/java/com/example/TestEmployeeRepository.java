package com.example;

import java.util.List;

public class TestEmployeeRepository implements EmployeeRepository {
    @Override
    public List<Employee> findAll() {
        return List.of(new Employee("1", 5000),
                new Employee("2", 6000),
                new Employee("3", 3000));
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }

}
