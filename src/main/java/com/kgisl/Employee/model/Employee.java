package com.kgisl.Employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Employee
 */
@Entity
public class Employee {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long empid;
private String empname;

    /**
     * @return the id
     */
    /**
     * @return the empid
     */
    public Long getEmpid() {
        return empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    /**
     * @param empid the empid to set
     */
public void setEmpid(Long empid) {
    this.empid = empid;
} 
}