package com.employee.spring_boot_employee.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
import com.employee.spring_boot_employee.domain.Employee;
import com.employee.spring_boot_employee.domain.ExperienceDetails;
import com.employee.spring_boot_employee.domain.Reference;
import com.employee.spring_boot_employee.exception.EmployeeNotFoundException;
import com.employee.spring_boot_employee.repositories.EmployeeRepository;
import com.employee.spring_boot_employee.repositories.ExperienceDetailsRepository;
import com.employee.spring_boot_employee.services.ExperienceDetailsService;

@RestController
@RequestMapping("/api")
public class ExperienceDetailsController {

	@Autowired
	private ExperienceDetailsRepository experienceDetailsRepository;

	@Autowired
	ExperienceDetailsService experienceDetailsService;
	
	
	@GetMapping("/experienceDetails")
	public List<ExperienceDetails> getAllExperienceDetails() {
		return experienceDetailsRepository.findAll();
	}
	
	@PostMapping("/experienceDetails")
	public ExperienceDetails CreateExperienceDetails(@Validated @RequestBody ExperienceDetails exp) {
		return experienceDetailsRepository.save(exp);
		}
	
	
	@Transactional
	@GetMapping("/employees/{employee_id}/experience")
	public ResponseEntity<List<com.employee.spring_boot_employee.Entity.Exp>>getEmployeeByReference(@PathVariable(value = "employee_id")Long employee_id,@RequestBody ExperienceDetails expDetails){
		List<com.employee.spring_boot_employee.Entity.Exp> v= experienceDetailsService.getByEmployeeId(employee_id);
     
		return ResponseEntity.ok().body(v);
	}
	
	
	
	@PutMapping("/experienceDetails/{id}")
	public ResponseEntity<ExperienceDetails> updateExpdetails(@PathVariable(value = "id") long employeeId,
			@RequestBody ExperienceDetails expDetails) throws EmployeeNotFoundException {
		ExperienceDetails exp = experienceDetailsRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id: :" + employeeId));
		{
			exp.setExperience(expDetails.getExperience());
			exp.setDoe(expDetails.getDoe());
			exp.setDoj(expDetails.getDoj());
			exp.setPreCompanyName(expDetails.getPreCompanyName());
			exp.setTechnologies(expDetails.getTechnologies());
			return ResponseEntity.ok().body(exp);
		}
	}
	
	  @DeleteMapping("/experienceDetails/{id}") 
	  public ResponseEntity<?>deleteExperienceDetailsByEmployee(@PathVariable(value = "id") long employeeId) throws
	  EmployeeNotFoundException {experienceDetailsRepository.findById(employeeId)
	                 .orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id: :" + employeeId));
	  experienceDetailsRepository.deleteById(employeeId);
	  return ResponseEntity.ok().build();
	  
	  }
	
}
	
