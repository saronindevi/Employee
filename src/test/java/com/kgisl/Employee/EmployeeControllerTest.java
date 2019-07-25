package com.kgisl.Employee;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.kgisl.Employee.controller.EmployeeBuilder;
import com.kgisl.Employee.controller.EmployeeController;
import com.kgisl.Employee.model.Employee;
import com.kgisl.Employee.service.EmployeeService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * EmployeeControllerTest
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

    @Mock
    EmployeeService employeeService;
    @InjectMocks
    EmployeeController employeeController;
    List<Employee> expected;
    Employee emp1= new EmployeeBuilder().empid(1L).empname("name1").build();
    
    Employee emp2= new EmployeeBuilder().empid(2L).empname("name2").build();
    @Test
    public void getallemployeedetailsTest(){
        expected=Arrays.asList(emp1,emp2);
        when(employeeService.getemployeedetails()).thenReturn(expected);
        List<Employee> actual=employeeController.getallemployeedetails();
        assertEquals(expected, actual);
    }
    
    
}