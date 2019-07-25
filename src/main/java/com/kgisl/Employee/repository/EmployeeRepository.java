package com.kgisl.Employee.repository;

import com.kgisl.Employee.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * EmployeeRepository
 */
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    
}