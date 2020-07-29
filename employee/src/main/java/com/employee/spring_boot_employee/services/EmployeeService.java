package com.employee.spring_boot_employee.services;

import java.util.List;

import com.employee.spring_boot_employee.domain.Employee;



public interface EmployeeService {
	List<Employee> listAll();

    Employee getById(Long id);

    Employee saveOrUpdate(Employee employee);

    void delete(Long id);

 }
