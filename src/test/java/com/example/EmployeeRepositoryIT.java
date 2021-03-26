package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class EmployeeRepositoryIT {

    BankService bankService = mock(BankService.class);

    EmployeeImplementationRepository employeeRepo = new EmployeeImplementationRepository(List.of(
            new Employee("1", 5000),
            new Employee("2", 6000),
            new Employee("3", 3000)));
    EmployeeManager employeeManager = new EmployeeManager(employeeRepo, bankService);

    @Test
    void payEmployees() {
        assertEquals(3, employeeManager.payEmployees());
    }

    @Test
    void payEmployeesExceptionTest() {
        doThrow(new RuntimeException()).when(bankService).pay("1", 5000);
        assertEquals(2, employeeManager.payEmployees());
        Employee a = employeeRepo.findAll().get(0);
        Employee b = employeeRepo.findAll().get(1);
        assertFalse(a.isPaid());
        assertTrue(b.isPaid());
    }

    @Test
    public void payReturnsZeroTest() {
        EmployeeManager manager2 = new EmployeeManager(new EmployeeImplementationRepository(), bankService);
        assertEquals(0, manager2.payEmployees());
    }
}
