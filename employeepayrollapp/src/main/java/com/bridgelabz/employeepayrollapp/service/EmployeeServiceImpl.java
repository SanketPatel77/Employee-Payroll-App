package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.mapper.EmployeeMapper;
import com.bridgelabz.employeepayrollapp.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employeeList = new ArrayList<>();


    @Override
    public Employee addEmployee(EmployeeDTO employeeDTO) {
       Employee employee = EmployeeMapper.INSTANCE.toEntity(employeeDTO);
       employee.setId(employeeList.size()+1);
       employeeList.add(employee);
        log.info("Employee added :{}", employee.toString());
       return employee;
    }

    @Override
    public Employee updateEmployeeById(int id,EmployeeDTO employeeDTO) {
        for(Employee emp : employeeList){
            if(emp.getId() == id){
                emp.setName(employeeDTO.getName());
                emp.setSalary(employeeDTO.getSalary());
                log.info("Employee data updated successfully");
                return emp;
            }
        }
        log.info("Unable to update");
        return null;
    }

    private void remove(int i) {
        employeeList.remove(i);
    }
    @Override
    public boolean deleteEmployeeById(int id) {
        for(int i = 0; i < employeeList.size(); i++){
            if(employeeList.get(i).getId() == id){
                remove(i);
                log.info("Successfully deleted employee");
                return true;
            }
        }
        log.info("Unable to delete");
       return false;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(int id) {
        for(Employee emp : employeeList){
            if(emp.getId() == id){
                return emp;
            }
        }
        return null;
    }
}