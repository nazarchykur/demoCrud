package com.example.demoCRUD_1.dao;

import com.example.demoCRUD_1.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);


}


