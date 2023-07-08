package com.example.mockito.controller;

import com.example.mockito.exceptions.EmployeeAlreadyAddedException;
import com.example.mockito.exceptions.EmployeeNotFoundException;
import com.example.mockito.exceptions.EmployeeStorageIsFullException;
import com.example.mockito.model.Employee;
import com.example.mockito.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String fullName,
                        @RequestParam int department,
                        @RequestParam int salary) {
        try {
            return employeeService.add(fullName, department, salary);
        } catch (EmployeeAlreadyAddedException | EmployeeStorageIsFullException e) {
            throw new RuntimeException();
        }
    }
    @GetMapping("/remove")
    public String remove(@RequestParam String fullName) {
        try {
            return employeeService.remove(fullName);
        } catch (EmployeeNotFoundException e) {
            throw new RuntimeException();
        }
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String fullName) {
        try {
            return employeeService.find(fullName);
        } catch (EmployeeNotFoundException e) {
            throw new RuntimeException();
        }
    }

    @GetMapping("/all")
    public String getAll() {
        return employeeService.getAll().toString();
    }

}
