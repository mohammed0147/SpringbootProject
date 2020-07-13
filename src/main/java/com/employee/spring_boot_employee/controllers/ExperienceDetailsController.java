package com.employee.spring_boot_employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.spring_boot_employee.domain.ExperienceDetails;
import com.employee.spring_boot_employee.repositories.ExperienceDetailsRepository;

@RestController
@RequestMapping("/api")
public class ExperienceDetailsController {

	@Autowired
	private ExperienceDetailsRepository experienceDetailsRepository;
	
	@GetMapping("/experienceDetails")
	public List<ExperienceDetails> getAllExperienceDetails() {
		return experienceDetailsRepository.findAll();
	}
	
	@PostMapping("/experienceDetails")
	public ExperienceDetails CreateExperienceDetails(@Validated @RequestBody ExperienceDetails exp) {
		return experienceDetailsRepository.save(exp);
	}
}
