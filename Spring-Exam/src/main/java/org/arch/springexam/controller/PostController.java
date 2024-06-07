package org.arch.springexam.controller;


import org.arch.springexam.entity.Employee;
import org.arch.springexam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class PostController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/dev")
    public List<Employee> findAllDev() {
        return employeeService.findAllByRole("DEV");
    }

    @GetMapping("/test")
    public List<Employee> findAllTest() {
        return employeeService.findAllByRole("TEST");
    }

    @GetMapping("/devops")
    public List<Employee> findAllDevOps() {
        return employeeService.findAllByRole("DEVOPS");
    }
}