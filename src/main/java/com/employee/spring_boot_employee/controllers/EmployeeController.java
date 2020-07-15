package com.employee.spring_boot_employee.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.spring_boot_employee.domain.AlternativeContacts;
import com.employee.spring_boot_employee.domain.Employee;
import com.employee.spring_boot_employee.domain.ExperienceDetails;
import com.employee.spring_boot_employee.domain.Reference;
import com.employee.spring_boot_employee.exception.EmployeeNotFoundException;
import com.employee.spring_boot_employee.repositories.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@PostMapping("/employees")
	public Employee CreateEmployee(@Validated @RequestBody Employee employee) {
		List<Reference> refList = employee.getReference();
		List<Reference> reef = new ArrayList<Reference>();
		for (Reference ref : refList) {
			ref.setEmployee(employee);
			reef.add(ref);
		}
		employee.setReference(reef);
		
		List<AlternativeContacts> altcntcts = employee.getAlternativeContacts();
		List<AlternativeContacts> alt = new ArrayList<AlternativeContacts>();
		for (AlternativeContacts a : altcntcts) {
			a.setEmployee(employee);
			alt.add(a);
		}
		employee.setAlternativeContacts(alt);
		
		List<ExperienceDetails> exp=employee.getExpDetails();
		List<ExperienceDetails> expdetails=new ArrayList<ExperienceDetails>();
		for (ExperienceDetails e : exp ) {
			e.setEmployee(employee);
			expdetails.add(e);
		}
		employee.setExpDetails(expdetails);
		return employeeRepository.save(employee);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws EmployeeNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id: :" + employeeId));
		return ResponseEntity.ok().body(employee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") long employeeId,
			@RequestBody Employee employeeDetails) throws EmployeeNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id: :" + employeeId));
		{
			employee.setFirstName(employeeDetails.getFirstName());
			employee.setLastName(employeeDetails.getLastName());
			employee.setPrimaryAddress(employeeDetails.getPrimaryAddress());
			employee.setSecondaryAddress(employeeDetails.getSecondaryAddress());
			employee.setPhoneNumber(employeeDetails.getPhoneNumber());
			employee.setBloodGroup(employeeDetails.getBloodGroup());
			employee.setDob(employeeDetails.getDob());
			employeeRepository.save(employee);
			return ResponseEntity.ok().body(employee);
		}
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") long employeeId)
			throws EmployeeNotFoundException {
		employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id: :" + employeeId));
		employeeRepository.deleteById(employeeId);
		return ResponseEntity.ok().build();
	}
	

}
