package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

import java.util.List;

public interface EmployeeService {
    EmployeePayrollData addEmployee(EmployeePayrollDTO employeePayrollDTO);

    EmployeePayrollData updateEmployeeById(int id);

    void deleteEmployeeById(int id);

    List<EmployeePayrollData> getAllEmployee();

    EmployeePayrollData getEmployeeById(int id);


}
