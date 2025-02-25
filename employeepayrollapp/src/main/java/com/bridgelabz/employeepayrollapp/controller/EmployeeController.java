package com.bridgelabz.employeepayrollapp.controller;

import jakarta.persistence.GeneratedValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employeeparyrollservice")
public class EmployeeController {
    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("connection Successfull");
    }
}
