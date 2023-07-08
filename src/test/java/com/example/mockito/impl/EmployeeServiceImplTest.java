package com.example.mockito.impl;

import com.example.mockito.exceptions.EmployeeAlreadyAddedException;
import com.example.mockito.exceptions.EmployeeNotFoundException;
import com.example.mockito.exceptions.EmployeeStorageIsFullException;
import com.example.mockito.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static com.example.mockito.TestData.*;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    public final EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();



    @Test
    void addNewEmployeeAndCheckSize() {
        assertEquals(0, employeeServiceImpl.getAll().size());
        Employee expectedResult = new Employee(FULL_NAME_1, DEPARTMENT_ID_1, SALARY_1);
        Employee actualResult = employeeServiceImpl.add(FULL_NAME_1, DEPARTMENT_ID_1, SALARY_1);
        assertEquals(expectedResult, actualResult);
        assertEquals(1, employeeServiceImpl.getAll().size());
    }

    @Test
    void throwEmployeeExists() {
        Employee actualResult = employeeServiceImpl.add(FULL_NAME_1, DEPARTMENT_ID_1, SALARY_1);
        assertTrue(employeeServiceImpl.getAll().contains(actualResult));
        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeServiceImpl.add(FULL_NAME_1, DEPARTMENT_ID_1, SALARY_1));
    }

    @Test
    void throwEmployeeFullListException() {
        for (int i = 0; i < 10; i++) {
            employeeServiceImpl.add(FULL_NAME_1 + i, DEPARTMENT_ID_1, SALARY_1);
        }
        assertThrows(EmployeeStorageIsFullException.class, () -> employeeServiceImpl.add(FULL_NAME_1 + 11,
                DEPARTMENT_ID_1, SALARY_1));
    }
    @Test
    void throwEmployeeNotFoundException() {
        assertEquals(0, employeeServiceImpl.getAll().size());
        assertThrows(EmployeeNotFoundException.class, () -> employeeServiceImpl.find(FULL_NAME_1));
    }


    @Test
    void findEmployee() {
        Employee expected = employeeServiceImpl.add(FULL_NAME_1, DEPARTMENT_ID_1, SALARY_1);
        Employee actual = employeeServiceImpl.find(FULL_NAME_1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void removeEmployeeWhenTheyExist() {
        employeeServiceImpl.add(FULL_NAME_1, DEPARTMENT_ID_1, SALARY_1);
        assertEquals(1, employeeServiceImpl.getAll().size());
        employeeServiceImpl.remove(FULL_NAME_1);
        assertFalse(employeeServiceImpl.getEmployees().containsValue(EXPECTED_EMPLOYEE_1));
        assertEquals(0, employeeServiceImpl.getAll().size());
    }

    @Test
    public void returnListOfEmployees() {
        Employee employee1 = employeeServiceImpl.add(FULL_NAME_1, DEPARTMENT_ID_1, SALARY_1);
        Employee employee2 = employeeServiceImpl.add(FULL_NAME_2, DEPARTMENT_ID_1, SALARY_2);
        Collection<Employee> expected = List.of(employee2, employee1);
        Collection<Employee> actual = employeeServiceImpl.getAll();
        assertIterableEquals(expected, actual);
    }
}