package com.example.mockito;

import com.example.mockito.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestData {
    public static final String FULL_NAME_1 = "Иванов Иван Иванович";
    public static final String FULL_NAME_2 = "Петров Петр Петрович";
    public static final String FULL_NAME_3 = "Сидоров Сидор Сидорович";
    public static final int SALARY_1 = 30000;
    public static final int SALARY_2 = 40000;
    public static final int SALARY_3 = 50000;
    public static final int DEPARTMENT_ID_1 = 1;
    public static final int DEPARTMENT_ID_2 = 2;
    public static final int WRONG_DEPARTMENT_ID = 2;

    public static final Employee EXPECTED_EMPLOYEE_1 = new Employee(FULL_NAME_1, DEPARTMENT_ID_1, SALARY_1);
    public static final Employee EXPECTED_EMPLOYEE_2 = new Employee(FULL_NAME_2, DEPARTMENT_ID_1, SALARY_2);
    public static final Employee EXPECTED_EMPLOYEE_3 = new Employee(FULL_NAME_3, WRONG_DEPARTMENT_ID , SALARY_3);
    public static final Employee DIFFERENT_DEPARTMENT_EMPLOYEE = new Employee(FULL_NAME_2, WRONG_DEPARTMENT_ID, SALARY_1);

    public static final List<Employee> EMPLOYEES = List.of(EXPECTED_EMPLOYEE_1, EXPECTED_EMPLOYEE_2, EXPECTED_EMPLOYEE_3);

    public static final Map<String, Employee> EMPLOYEE_MAP_MOCK_TEST = new HashMap<>(Map.of(
            "num1", new Employee("Иванов Иван Иванович", 1, 30000),
            "num2", new Employee("Петров Петр Петрович", 1, 40000),
            "num3", new Employee("Сидоров Сидор Сидорович", 2, 50000)
    ));

}
