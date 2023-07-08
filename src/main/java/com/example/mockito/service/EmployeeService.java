package com.example.mockito.service;

import com.example.mockito.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String fullName, int department, int salary);

    String remove(String fullName);

    Employee find(String fullName);

    Collection<Employee> getAll();
}
