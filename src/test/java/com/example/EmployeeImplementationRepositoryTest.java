package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeImplementationRepositoryTest {
    EmployeeImplementationRepository employeeRepo = new EmployeeImplementationRepository();


    @Test
    void findAllEmptyTest() {
        assertEquals(0, employeeRepo.findAll().size());
    }

    @Test
    void findAllSavedListTest() {
        employeeRepo.save(new Employee("1", 5000));
        employeeRepo.save(new Employee("2", 6000));
        assertEquals(2, employeeRepo.findAll().size());
    }

    @Test
    void verifyAllSavedEmployeesTest() {
        employeeRepo.save(new Employee("2", 6000));
        employeeRepo.save(new Employee("3", 3000));
        var empList = employeeRepo.findAll();
        assertEquals("2", empList.get(0).getId());
        assertEquals(6000, empList.get(0).getSalary());
        assertEquals("3", empList.get(1).getId());
        assertEquals(3000, empList.get(1).getSalary());
    }

    @Test
    void parsingListInConstructorTest() {
        Employee a = new Employee("1", 5000);
        Employee b = new Employee("2", 6000);
        Employee c = new Employee("3", 3000);
        EmployeeImplementationRepository employeeRepo = new EmployeeImplementationRepository(List.of(a,b,c));
        assertEquals(3, employeeRepo.findAll().size());
        assertTrue(employeeRepo.findAll().contains(a));
        assertTrue(employeeRepo.findAll().contains(b));
        assertTrue(employeeRepo.findAll().contains(c));
    }

    @Test
    void sameIdOverwritesTest() {
        employeeRepo.save(new Employee("1", 5000));
        employeeRepo.save(new Employee("1", 6000));
        assertEquals(1, employeeRepo.findAll().size());
        assertEquals("1", employeeRepo.findAll().get(0).getId());
        assertEquals(6000, employeeRepo.findAll().get(0).getSalary());
    }

}