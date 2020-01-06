package com.example.demoCRUD_1.dao;

import com.example.demoCRUD_1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
