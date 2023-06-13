package com.sandhya.librarymanagement.service;

import com.sandhya.librarymanagement.model.Employee;
import com.sandhya.librarymanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private  EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    public Optional<Employee> getEmp(Integer bookId) {
        return employeeRepository.findById(bookId);

    }

    public  Employee addNewEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    public  boolean deleteEmployee(Integer empId) {
        employeeRepository.deleteById(empId);
        return true;

    }
}
