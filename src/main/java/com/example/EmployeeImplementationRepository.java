package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeImplementationRepository implements EmployeeRepository{

    List<Employee> employeeList = new ArrayList<>();

    public EmployeeImplementationRepository(){
    }

    public EmployeeImplementationRepository (List<Employee> employeeList) {
        this.employeeList = employeeList;
    }


    @Override
    public List<Employee> findAll() {
        return employeeList;
    }

    @Override
    public Employee save(Employee employee) {
        employeeList.stream()
                .filter(emp -> emp.getId().equals(employee.getId()))
                .findFirst().ifPresent(employeeToDelete -> employeeList.remove(employeeToDelete));
        employeeList.add(employee);
        int index = employeeList.indexOf(employee);
        return employeeList.get(index);
    }

}
