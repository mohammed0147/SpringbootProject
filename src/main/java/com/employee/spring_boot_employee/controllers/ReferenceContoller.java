package com.employee.spring_boot_employee.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employee.spring_boot_employee.Entity.Ref;
import com.employee.spring_boot_employee.domain.Employee;
import com.employee.spring_boot_employee.domain.Reference;
import com.employee.spring_boot_employee.exception.EmployeeNotFoundException;
import com.employee.spring_boot_employee.repositories.EmployeeRepository;
import com.employee.spring_boot_employee.repositories.ReferenceRepository;
import com.employee.spring_boot_employee.services.ReferenceService;

@RestController
@RequestMapping("/api")
public class ReferenceContoller {

	@Autowired
	private ReferenceRepository referenceRepository;

	@Autowired
	private ReferenceService referenceService;

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/reference")
	public List<Reference> getAllReferences() {
		return referenceRepository.findAll();
	}

	@PostMapping("/reference")
	public Reference CreateEmpReference(@Validated @RequestBody Reference reference) {
		return referenceRepository.save(reference);
	}

	@PostMapping("/employee/{employee_id}/reference")
	public Employee CreateRefByEmp(@Validated @RequestBody List<Reference> var,
			@PathVariable(value = "employee_id") Long employeeId) {
		return referenceService.CreateRefByEmp(var, employeeId);

	}

	@GetMapping("/ref_employees/{id}")
	public ResponseEntity<Reference> getReferenceById(@PathVariable(value = "id") Long employeeId)
			throws EmployeeNotFoundException {
		Reference reference = referenceService.getById(employeeId);
		return ResponseEntity.ok().body(reference);
	}

	@PutMapping("/employee/{employee_id}/reference/{reference_id}")
	public ResponseEntity<Reference> updateRefByEmp(@PathVariable(value = "employee_id") long employeeId,
			@PathVariable(value = "reference_id") long referenceId, @RequestBody Reference refDetails) {
		Reference reference = referenceRepository.getReferenceByEmpIdAndRefId(employeeId, referenceId);
		reference.setRefFirstName(refDetails.getRefFirstName());
		reference.setRefLastName(refDetails.getRefLastName());
		reference.setBloodGroup(refDetails.getBloodGroup());
		reference.setEmail(refDetails.getEmail());
		reference.setDob(refDetails.getDob());
		return ResponseEntity.ok().body(referenceRepository.save(reference));
	}

	@Transactional
	@GetMapping("/employees/{employee_id}/reference")
	public ResponseEntity<List<com.employee.spring_boot_employee.Entity.Ref>> getEmployeeByReference(
			@PathVariable(value = "employee_id") Long employee_id, @RequestBody(required=false) Reference refDetails) {
		List<com.employee.spring_boot_employee.Entity.Ref> v = referenceService.getByEmployeeId(employee_id);

		return ResponseEntity.ok().body(v);
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

			return ResponseEntity.ok().body(referenceRepository.save(ref));
		}
	}

	@DeleteMapping("/ref_employees/{id}")
	public ResponseEntity<?> deleteReferenceEmployee(@PathVariable(value = "id") long employeeId)
			throws EmployeeNotFoundException {
		referenceRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id: :" + employeeId));
		referenceRepository.deleteById(employeeId);
		return ResponseEntity.ok().build();

	}

	@DeleteMapping("/employees/{employee_id}/reference/{reference_id}")
	public ResponseEntity<?> DeleteRefByEmp(@PathVariable(value = "employee_id") long employeeId,
			@PathVariable(value = "reference_id") long referenceId) {
		Reference reference = referenceRepository.getReferenceByEmpIdAndRefId(employeeId, referenceId);

		referenceRepository.delete(reference);
		return ResponseEntity.ok().body("reference deleted");
	}

}
