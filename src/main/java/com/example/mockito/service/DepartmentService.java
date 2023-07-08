package com.example.mockito.service;

import com.example.mockito.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee maxSalary(int departmentId);

    Employee minSalary(int departmentId);

    Collection<Employee> allByDepartment(int departmentId);

    Map<Integer, List<Employee>> all();

    int salarySumByDepartment(int departmentId);
}
