package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(EmployeeDTO employeePayrollDTO);

    Employee updateEmployeeById(int id, EmployeeDTO employeeDTO);

    boolean deleteEmployeeById(int id);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(int id);


}