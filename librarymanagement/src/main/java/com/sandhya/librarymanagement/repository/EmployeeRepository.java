package com.sandhya.librarymanagement.repository;

import com.sandhya.librarymanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Override
    List<Employee> findAll();

    Optional<Employee> findById(Integer empid);

    @Override
    void deleteById(Integer integer);

    @Override
    <S extends Employee> S save(S entity);
}
