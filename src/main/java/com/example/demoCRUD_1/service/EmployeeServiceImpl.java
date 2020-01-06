package com.example.demoCRUD_1.service;

import com.example.demoCRUD_1.dao.EmployeeRepository;
import com.example.demoCRUD_1.entity.Employee;
import com.example.demoCRUD_1.rest.EmployeeRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {

        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;

        if (result.isPresent()) {
            employee = result.get();
        } else {
            // we didn`t find the employee
            throw new RuntimeException("Didn`t find the employee id - " + id);
        }

        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
