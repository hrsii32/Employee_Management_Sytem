package com.example.employee_managing.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_managing.exception.UserNotFoundException;
import com.example.employee_managing.model.Employee;
import com.example.employee_managing.repo.EmployeeRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id).
                orElseThrow(() -> new UserNotFoundException("User By Id" + id + " was not found"));
    }

    public void deleteEmployeeById(Long id) {
        employeeRepo.deleteById(id);
    }

}
