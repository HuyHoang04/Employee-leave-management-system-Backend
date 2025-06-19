package com.example.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Employee;
import com.example.demo.Service.IEmployeeService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IEmployeeService employeeService;

    @PostMapping("/login/{email}")
    public ResponseEntity<?> login(@PathVariable String email) {
        Employee employee = employeeService.getById(email);
        if (employee == null) {
            return ResponseEntity.status(404).body("Employee not found");
        }
        return ResponseEntity.ok(employee);
    }
}