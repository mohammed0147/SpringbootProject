package com.employee.spring_boot_employee.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.spring_boot_employee.domain.Employee;
import com.employee.spring_boot_employee.domain.ExperienceDetails;
@Service
public interface ExperienceDetailsService {

	List<ExperienceDetails> listAll();

	//ExperienceDetails getById(Long id);

	ExperienceDetails saveOrUpdate(ExperienceDetails exp);

	 List<com.employee.spring_boot_employee.Entity.Exp> getByEmployeeId(Long employee_id);
	
    //void delete(Long id);
}
