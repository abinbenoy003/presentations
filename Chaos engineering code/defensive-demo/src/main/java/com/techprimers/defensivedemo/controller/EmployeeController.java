package com.techprimers.defensivedemo.controller;

import com.techprimers.defensivedemo.model.Employee;
import com.techprimers.defensivedemo.service.EmployeeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") Integer employeeId) {
        return service.get(employeeId);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable("id") Integer employeeId, @RequestBody Employee employee) {
        return service.update(employeeId, employee);
    }

    @GetMapping("/all")
    public List<Employee> getAll() {
        return service.getAll();
    }

    @PostMapping("/")
    public Employee createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = service.create(employee);
        return createdEmployee;
    }
}
