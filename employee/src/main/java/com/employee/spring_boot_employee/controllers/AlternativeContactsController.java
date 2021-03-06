package com.employee.spring_boot_employee.controllers;

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
import com.employee.spring_boot_employee.exception.EmployeeNotFoundException;
import com.employee.spring_boot_employee.repositories.AlternativeContactsRepository;

@RestController
@RequestMapping("/api")
public class AlternativeContactsController {

	@Autowired
	AlternativeContactsRepository alternativeContactsRepository;
	 
	@GetMapping("/alternativeContacts")
	public List<AlternativeContacts> getAllAlternativeContacts() {
		return alternativeContactsRepository.findAll();
	}

	@PostMapping("/alternativeContacts")
	public AlternativeContacts CreateAlternativeContacts(@Validated @RequestBody AlternativeContacts contacts) {
		return alternativeContactsRepository.save(contacts);
	}
	
	@GetMapping("/ref_contacts/{id}")
	public ResponseEntity<AlternativeContacts> getAlternativeContactsById(@PathVariable(value = "id") Long employeeId)
			throws EmployeeNotFoundException {
		AlternativeContacts contacts = alternativeContactsRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id: :" + employeeId));
		return ResponseEntity.ok().body(contacts);
	}
	
	@PutMapping("/ref_contacts/{id}")
	public ResponseEntity<AlternativeContacts> updateAlternativeContacts(@PathVariable(value = "id") long employeeId,
			@RequestBody AlternativeContacts contacts) throws EmployeeNotFoundException {
		AlternativeContacts alter = alternativeContactsRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id: :" + employeeId));
		{
			alter.setAlternativeNum(contacts.getAlternativeNum());
			alter.setAlternativeName(contacts.getAlternativeName());
			alter.setAlternativeEmail(contacts.getAlternativeEmail());
			alternativeContactsRepository.save(alter);
			return ResponseEntity.ok().body(alter);
		}
	}
	
	@DeleteMapping("/ref_contacts/{id}") 
	  public ResponseEntity<?>deleteAlternativeContacts(@PathVariable(value = "id") long employeeId) throws
	  EmployeeNotFoundException { alternativeContactsRepository.findById(employeeId)
	                 .orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id: :" + employeeId));
	  alternativeContactsRepository.deleteById(employeeId);
	  return ResponseEntity.ok().build();
	  
	  }
	
}
