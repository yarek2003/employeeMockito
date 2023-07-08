package com.example.mockito.impl;

import com.example.mockito.exceptions.EmployeeAlreadyAddedException;
import com.example.mockito.exceptions.EmployeeNotFoundException;
import com.example.mockito.exceptions.EmployeeStorageIsFullException;
import com.example.mockito.model.Employee;
import com.example.mockito.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public static final int MAX_SIZE = 10;
    private final Map<String, Employee> employees = new HashMap<>();
    @Override
    public Employee add(String fullName, int department, int salary) {
        if (employees.size() >= MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Нет свободных мест");
        }
        if (employees.containsKey(fullName)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже есть");
        }
        Employee newEmployee = new Employee(fullName, department, salary);
        employees.put(fullName, newEmployee);
        return newEmployee;
    }
    @Override
    public String remove(String fullName) {
        employees.remove(fullName);
        return fullName;
    }

    @Override
    public Employee find(String fullName) {
        var found = employees.get(fullName);
        if (found == null) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return found;
    }
    public Map<String, Employee> getEmployees() {
        return employees;
    }
    @Override
    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employees.values());
    }


}
