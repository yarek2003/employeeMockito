package com.example.mockito.controller;

import com.example.mockito.model.Employee;
import com.example.mockito.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("/{id}/salary/max")
    public Employee maxSalary(@PathVariable int id) {
        return departmentService.maxSalary(id);
    }
    @GetMapping("{id}/salary/min")
    public Employee minSalary(@PathVariable int id) {
        return departmentService.minSalary(id);
    }
    @GetMapping("/{id}/salary/sum")
    public int salarySumByDepartment(@PathVariable int id){
        return departmentService.salarySumByDepartment(id);
    }
    @GetMapping( "/{id}/employees")
    public Collection<Employee> allByDepartment(@PathVariable int id) {
        return departmentService.allByDepartment(id);
    }
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> all() {
        return departmentService.all();
    }
}
