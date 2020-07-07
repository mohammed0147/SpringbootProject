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
import com.employee.spring_boot_employee.domain.Reference;
import com.employee.spring_boot_employee.exception.EmployeeNotFoundException;
import com.employee.spring_boot_employee.repositories.ReferenceRepository;

@RestController
@RequestMapping("/api")
public class ReferenceContoller {

	@Autowired
	private ReferenceRepository referenceRepository;
	
	@GetMapping("/reference")
	public List<Reference> getAllReferences() {
		return referenceRepository.findAll();
	}

	@PostMapping("/reference")
	public Reference CreateEmpReference(@Validated @RequestBody Reference reference) {
		return referenceRepository.save(reference);
	}
	
	@GetMapping("/ref_employees/{id}")
	public ResponseEntity<Reference> getReferenceEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws EmployeeNotFoundException {
		Reference reference = referenceRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id: :" + employeeId));
		return ResponseEntity.ok().body(reference);
	}
	
	@PutMapping("/ref_employees/{id}")
	public ResponseEntity<Reference> updateReferenceEmployee(@PathVariable(value = "id") long employeeId,
			@RequestBody Reference refDetails) throws EmployeeNotFoundException {
		Reference ref = referenceRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id: :" + employeeId));
		{
			ref.setRefFirstName(refDetails.getRefFirstName());
			ref.setRefLastName(refDetails.getRefLastName());
			ref.setDob(refDetails.getDob());
			ref.setEmail(refDetails.getEmail());
			ref.setPhoneNum(refDetails.getPhoneNum());
			ref.setBloodGroup(refDetails.getBloodGroup());
			referenceRepository.save(ref);
			return ResponseEntity.ok().body(ref);
		}
	}
	
	  @DeleteMapping("/ref_employees/{id}") 
	  public ResponseEntity<?>deleteReferenceEmployee(@PathVariable(value = "id") long employeeId) throws
	  EmployeeNotFoundException { referenceRepository.findById(employeeId)
	                 .orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id: :" + employeeId));
	  referenceRepository.deleteById(employeeId);
	  return ResponseEntity.ok().build();
	  
	  }
	
}
