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

import com.employee.spring_boot_employee.domain.PrimaryAddress;
import com.employee.spring_boot_employee.exception.EmployeeNotFoundException;
import com.employee.spring_boot_employee.repositories.PrimaryAddressRepository;

@RestController
@RequestMapping("/api")
public class PrimaryAddressController {

	@Autowired
	PrimaryAddressRepository primaryAddressRepository;
	
	
	@GetMapping("/primaryAddress")
	public List<PrimaryAddress> getAllPrimaryAddress() {
		return primaryAddressRepository.findAll();
	}
	@PostMapping("/primaryAddress")
	public PrimaryAddress CreatePrimaryAddress(@Validated @RequestBody PrimaryAddress address) {
		if(address.getIsPrimary() == true)
		{
			return primaryAddressRepository.save(address);

		}
		else {
			return primaryAddressRepository.save(address);

		}
}


	@GetMapping("/primaryAddress/{id}")
	public ResponseEntity<PrimaryAddress> getPrimaryAddressById(@PathVariable(value = "id") Long employeeId)
			throws EmployeeNotFoundException {
		PrimaryAddress address = primaryAddressRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id: :" + employeeId));
		return ResponseEntity.ok().body(address);
	}
	
	
	@PutMapping("/primaryAddress/{id}")
	public ResponseEntity<PrimaryAddress> updatePrimaryAddress(@PathVariable(value = "id") long employeeId,
			@RequestBody PrimaryAddress address) throws EmployeeNotFoundException {
		PrimaryAddress add = primaryAddressRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id: :" + employeeId));
		{
			
			add.setHouseNumber(address.getHouseNumber());
			add.setStreet(address.getStreet());
			add.setCity(address.getCity());
			add.setState(address.getState());
			add.setPincode(address.getPincode());
			add.setIsPrimary(address.getIsPrimary());
			primaryAddressRepository.save(add);
			return ResponseEntity.ok().body(add);
		}
	}
	
	@DeleteMapping("/primaryAddress/{id}") 
	  public ResponseEntity<?> deletePrimaryAddress(@PathVariable(value = "id") long employeeId) throws
	  EmployeeNotFoundException { primaryAddressRepository.findById(employeeId)
	                 .orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id: :" + employeeId));
	   primaryAddressRepository.deleteById(employeeId);
	  return ResponseEntity.ok().build();
	  
	  }
	

}
