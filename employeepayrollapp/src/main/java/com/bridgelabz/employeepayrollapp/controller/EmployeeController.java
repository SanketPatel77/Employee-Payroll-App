package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.mapper.EmployeeMapper;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Test endpoint is working!");
    }

    // api to add employee
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDTO employeeDTO){
        return ResponseEntity.ok(employeeService.addEmployee(employeeDTO));
    }

    // api to get all employee
    @GetMapping("/getallemployee")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employeeList = employeeService.getAllEmployee();
        return ResponseEntity.ok(employeeList);
    }

    // api to update employee by id
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployeeByID(@PathVariable("id") int id,@RequestBody EmployeeDTO employeeDTO ){
        Employee updateEmployee = employeeService.updateEmployeeById(id,employeeDTO);

        if(updateEmployee != null){
            EmployeeDTO updatedDTO = EmployeeMapper.INSTANCE.toDto(updateEmployee);
            return ResponseEntity.ok(updatedDTO);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    // to delete employee by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id){
        if(employeeService.deleteEmployeeById(id)){
            return ResponseEntity.ok("Deleted Successfully");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    // to fetch employee by id
    @PostMapping("/getemployee/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable int id){
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(EmployeeMapper.INSTANCE.toDto(employee));
    }
}