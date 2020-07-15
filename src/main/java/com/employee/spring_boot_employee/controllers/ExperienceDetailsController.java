package com.employee.spring_boot_employee.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employee.spring_boot_employee.domain.Employee;
import com.employee.spring_boot_employee.domain.ExperienceDetails;
import com.employee.spring_boot_employee.exception.EmployeeNotFoundException;
import com.employee.spring_boot_employee.repositories.EmployeeRepository;
import com.employee.spring_boot_employee.repositories.ExperienceDetailsRepository;

@RestController
@RequestMapping("/api")
public class ExperienceDetailsController {

	@Autowired
	private ExperienceDetailsRepository experienceDetailsRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/experienceDetails")
	public List<ExperienceDetails> getAllExperienceDetails() {
		return experienceDetailsRepository.findAll();
	}
	
	@PostMapping("/experienceDetails")
	public ExperienceDetails CreateExperienceDetails(@Validated @RequestBody ExperienceDetails exp) {
		return experienceDetailsRepository.save(exp);
		}
	@GetMapping("/employees/{employees_id}/experience")
	
	/*public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "employees_id") Long employeeId)
			throws EmployeeNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id: :" + employeeId));
		return ResponseEntity.ok().body(employee);
	}
	*/

	public ResponseEntity<ExperienceDetails> getExperienceById(@PathVariable(value = "employees_id") Long experienceId)
			throws EmployeeNotFoundException {
		ExperienceDetails experience = experienceDetailsRepository.findById(experienceId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id: :" + experienceId));
		return ResponseEntity.ok().body(experience);
	}
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
	}
