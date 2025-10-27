package com.example.employee_managing.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee_managing.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    // Employee deleteEmployeeById(Long id);
    // Employee findEmployeeById(Long id);
    Optional<Employee> findEmployeeById(Long id);

}
