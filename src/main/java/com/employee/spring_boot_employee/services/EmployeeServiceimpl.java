package com.employee.spring_boot_employee.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.employee.spring_boot_employee.domain.Employee;
import com.employee.spring_boot_employee.repositories.EmployeeRepository;

public class EmployeeServiceimpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> listAll() {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employees::add); // fun with Java 8
		return employees;

	}

	@Override
	public Employee getById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public Employee saveOrUpdate(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);

	}

}
