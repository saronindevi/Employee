package com.kgisl.Employee.controller;

import com.kgisl.Employee.model.Employee;

/**
 * employeeBuilder
 */
public class EmployeeBuilder {
    Employee employee = new Employee();

    public EmployeeBuilder empid(Long id) {
        employee.setEmpid(id);
        return this;

    }

    public EmployeeBuilder empname(String name) {
        employee.setEmpname(name);
        return this;
    }

    public Employee Build() {
        return this.employee;
    }

    public Employee build() {
        return null;
    }

}