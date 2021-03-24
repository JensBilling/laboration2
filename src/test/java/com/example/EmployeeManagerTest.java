package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeManagerTest {

    @Test
    void payEmployeesTest() {
        EmployeeRepository employeeRepository = new TestEmployeeRepository();
        BankService bankService = new TestBankService();

        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

        var actual = employeeManager.payEmployees();

        assertEquals(3, actual);

    }

    @Test
    void payEmployeesTestWithMockito() {
        EmployeeRepository employeeRepository = mock(TestEmployeeRepository.class);
        when(employeeRepository.findAll()).thenReturn(List.of(
                new Employee("1", 5000),
                new Employee("2", 6000),
                new Employee("3", 3000)));

        BankService bankService = mock(TestBankService.class);

        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

        var actual = employeeManager.payEmployees();

        assertEquals(3, actual);

    }


    @Test
    void employeePaidCatchesException() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        when(employeeRepository.findAll()).thenReturn(List.of(
                new Employee("1", 5000),
                new Employee("2", 6000),
                new Employee("3", 3000)));

        BankService bankService = mock(BankService.class);
        doThrow(new RuntimeException()).when(bankService).pay("1", 5000);
        EmployeeManager emp = new EmployeeManager(employeeRepository, bankService);
        assertEquals(2, emp.payEmployees());
    }

}