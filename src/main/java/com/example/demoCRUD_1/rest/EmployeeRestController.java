package com.example.demoCRUD_1.rest;


import com.example.demoCRUD_1.dao.EmployeeDAO;
import com.example.demoCRUD_1.entity.Employee;
import com.example.demoCRUD_1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    //add mapping for Get /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return employee;
    }

    // POST mapping to add/update employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        // also just in case they pass ID in JSON .. det ID to 0
        // this is ti force a save of new item ... instead of update
        employee.setId(0);

        employeeService.save(employee);

        return employee;
    }

    // add mapping for PUT /employee - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);

        return employee;
    }

    // del /employee/{employeeId} - del employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        // throw exception if null
        if (employee == null) {
            throw new RuntimeException("Employee id not found -" + employeeId);

        }
        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }

}
