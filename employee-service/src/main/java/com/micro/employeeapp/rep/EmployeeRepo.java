package com.micro.employeeapp.rep;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro.employeeapp.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
