package com.kgisl.Employee.service;

import java.util.List;

import com.kgisl.Employee.model.Employee;
import com.kgisl.Employee.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EmployeeServiceImp
 */
@Service
public class EmployeeServiceImp implements EmployeeService {
@Autowired
private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getemployeedetails() {
        System.out.println(""+employeeRepository.findAll());
        return  employeeRepository.findAll();
    }

    
}