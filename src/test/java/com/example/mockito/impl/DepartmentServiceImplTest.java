package com.example.mockito.impl;

import com.example.mockito.exceptions.EmployeeNotFoundException;
import com.example.mockito.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    EmployeeServiceImpl employeeService;
    @InjectMocks
    DepartmentServiceImpl departmentService;

    @BeforeEach
    void setup (){
        Map<String, Employee> employees = new HashMap<>();
        Employee employee1 = new Employee("Иванов Иван Иванович", 1, 30000);
        Employee employee2 = new Employee("Петров Петр Петрович", 1, 40000);
        Employee employee3 = new Employee("Сидоров Сидор Сидорович", 2, 50000);
        employees.put("1", employee1);
        employees.put("2", employee2);
        employees.put("3", employee3);
        when(employeeService.getAll()).thenReturn(Collections.unmodifiableCollection(employees.values()));
    }
    @Test
    public void shouldTestMaxSalaryThrow() {
        Map<String, Employee> employees = new HashMap<>();
        when(employeeService.getAll()).thenReturn(Collections.unmodifiableCollection(employees.values()));
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.maxSalary(1));
    }

    @Test
    public void shouldTestMaxSalaryWhenEmployeeExists() {
        Employee employee2 = new Employee("Петров Петр Петрович", 1, 40000);
        assertEquals(employee2, departmentService.maxSalary(1));
    }


    @Test
    public void shouldTestMinSalaryThrow() {
        Map<String, Employee> employees = new HashMap<>();
        when(employeeService.getAll()).thenReturn(Collections.unmodifiableCollection(employees.values()));
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.minSalary(1));
    }

    @Test
    public void shouldTestMinSalaryWhenEmployeeExists() {
        Employee employee1 = new Employee("Иванов Иван Иванович", 1, 30000);
        assertEquals(employee1, departmentService.minSalary(1));
    }


    @Test
    public void shouldReturnEmployeesByDepartment() {
        Employee employee1 = new Employee("Иванов Иван Иванович", 1, 30000);
        Employee employee2 = new Employee("Петров Петр Петрович", 1, 40000);
        Collection<Employee> expectedResult = new ArrayList<>();
        expectedResult.add(employee1);
        expectedResult.add(employee2);
        assertEquals(expectedResult, departmentService.allByDepartment(1));
    }

    @Test
    public void shouldReturnAllEmployees() {
        Map<Integer, List<Employee>> expectedResult = new HashMap<>();
        Employee employee1 = new Employee("Иванов Иван Иванович", 1, 30000);
        Employee employee2 = new Employee("Петров Петр Петрович", 1, 40000);
        Employee employee3 = new Employee("Сидоров Сидор Сидорович", 2, 50000);

        List<Employee> employeesFromDepartment1 = new ArrayList<>();
        employeesFromDepartment1.add(employee1);
        employeesFromDepartment1.add(employee2);

        List<Employee> employeesFromDepartment2 = new ArrayList<>();
        employeesFromDepartment2.add(employee3);

        expectedResult.put(1, employeesFromDepartment1);
        expectedResult.put(2, employeesFromDepartment2);

        Map<String, Employee> actual = new HashMap<>();
        actual.put("1", employee1);
        actual.put("2", employee2);
        actual.put("3", employee3);
        assertEquals(expectedResult, departmentService.all());
    }


    @Test
    public void salarySumByDepartment() {
        int expectedResults = 70000;
        Map<String, Employee> actual = new HashMap<>();
        Employee employee1 = new Employee("Иванов Иван Иванович", 1, 30000);
        Employee employee2 = new Employee("Петров Петр Петрович", 1, 40000);
        Employee employee3 = new Employee("Сидоров Сидор Сидорович", 2, 50000);
        actual.put("Num2", employee2);
        actual.put("Num1", employee1);
        actual.put("Num3", employee3);
        assertEquals(expectedResults, departmentService.salarySumByDepartment(1));
    }
}
