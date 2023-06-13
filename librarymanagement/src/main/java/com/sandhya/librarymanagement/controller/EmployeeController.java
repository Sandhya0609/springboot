package com.sandhya.librarymanagement.controller;

import com.sandhya.librarymanagement.model.Employee;
import com.sandhya.librarymanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/allEmp")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();

    }
    @GetMapping("/emp/{empId}")
    public Optional<Employee> getEmp(@PathVariable Integer empId) {
        return employeeService.getEmp(empId);
    }
    @PostMapping("/addNewEmp")
    public Employee addNewEmployee(@RequestBody Employee employee){
        return employeeService.addNewEmployee(employee);
    }
    @DeleteMapping("/delete/{empId}")
    public boolean deleteEmployee(@PathVariable Integer empId){
        employeeService.deleteEmployee(empId);
        return true;
    }



}
