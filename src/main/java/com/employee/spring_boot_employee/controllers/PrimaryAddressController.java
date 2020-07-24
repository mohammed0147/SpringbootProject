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

import com.employee.spring_boot_employee.domain.Employee;
import com.employee.spring_boot_employee.domain.PrimaryAddress;
import com.employee.spring_boot_employee.exception.EmployeeNotFoundException;
import com.employee.spring_boot_employee.repositories.EmployeeRepository;
import com.employee.spring_boot_employee.repositories.PrimaryAddressRepository;
import com.employee.spring_boot_employee.services.PrimaryAddressService;

@RestController
@RequestMapping("/api")
public class PrimaryAddressController {

	@Autowired
	PrimaryAddressRepository primaryAddressRepository;
	
	@Autowired
	private PrimaryAddressService primaryAddressService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
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
	
	@PostMapping("/employee/{employee_id}/primaryAddress")
	public Employee CreatePriByEmp(@Validated @RequestBody List<PrimaryAddress> var,
			@PathVariable(value = "employee_id") Long employeeId) {
			return primaryAddressService.CreatePriByEmp(var, employeeId);

			}
	
	@PutMapping("/employee/{employee_id}/primaryAddress/{address_id}")
	public ResponseEntity<PrimaryAddress> updatePriByEmp(@PathVariable(value = "employee_id") long employeeId,
	@PathVariable(value = "address_id") long addressId, @RequestBody PrimaryAddress priDetails) {
	PrimaryAddress primaryAddress = primaryAddressRepository.getPrimaryAddressByEmpIdAndPriId(employeeId, addressId);
	primaryAddress.setHouseNumber(priDetails.getHouseNumber());
	primaryAddress.setAddressLine1(priDetails.getAddressLine1());
	primaryAddress.setAddressLine2(priDetails.getAddressLine2());
	primaryAddress.setCity(priDetails.getCity());
	primaryAddress.setState(priDetails.getState());
	primaryAddress.setCountry(priDetails.getCountry());
	primaryAddress.setPincode(priDetails.getPincode());
	primaryAddress.setIsPrimary(priDetails.getIsPrimary());
	return ResponseEntity.ok().body(primaryAddressRepository.save(primaryAddress));
	//return ResponseEntity.ok().body(referenceRepository.save(reference));
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
			add.setAddressLine1(address.getAddressLine1());
			add.setAddressLine2(address.getAddressLine2());
			add.setCity(address.getCity());
			add.setState(address.getState());
			add.setCountry(address.getCountry());
			add.setPincode(address.getPincode());
			add.setIsPrimary(address.getIsPrimary());
			primaryAddressRepository.save(add);
			return ResponseEntity.ok().body(add);
		}
	}
	@DeleteMapping("/primaryAddress/{id}") 
	  public ResponseEntity<?>deletePrimaryAddress(@PathVariable(value = "id") long employeeId) throws
	  EmployeeNotFoundException { primaryAddressRepository.findById(employeeId)
	                 .orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id: :" + employeeId));
	   primaryAddressRepository.deleteById(employeeId);
	  return ResponseEntity.ok().build();
	  }
	
	@DeleteMapping("/employees/{employee_id}/primaryAddress/{address_id}")
	public ResponseEntity<?> DeletepriByEmp(@PathVariable(value = "employee_id") long employeeId,
	@PathVariable(value = "address_id") long addressId) {
		PrimaryAddress primaryAddress = primaryAddressRepository.getPrimaryAddressByEmpIdAndPriId(employeeId, addressId);

	primaryAddressRepository.delete(primaryAddress);
	return ResponseEntity.ok().body("address deleted");
	}

	}
