package com.example.Employee_Management_Rest_Api.Repository;

import com.example.Employee_Management_Rest_Api.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByNameContaining(String name);
    List<Employee> findByDepartment(String department);
    List<Employee> findBySalaryBetween(double min,double max);

}
