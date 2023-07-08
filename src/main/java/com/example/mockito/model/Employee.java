package com.example.mockito.model;

import java.util.Objects;

public class Employee {
    private final String fullName;
    private int departmentId;
    private int salary;

    public Employee(String fullName, int departmentId, int salary) {
        this.fullName = fullName;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return departmentId == employee.departmentId && salary == employee.salary && fullName.equals(employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, departmentId, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", departmentId=" + departmentId +
                ", salary=" + salary +
                '}';
    }
}
