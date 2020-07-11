package com.employee.spring_boot_employee.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.employee.spring_boot_employee.domain.ExperienceDetails;
import com.employee.spring_boot_employee.repositories.ExperienceDetailsRepository;

public class ExperienceDetailsServiceimpl implements ExperienceDetailsService {

	@Autowired
	private ExperienceDetailsRepository experienceDetailsRepository;
	
      public ExperienceDetailsServiceimpl(ExperienceDetailsRepository experienceDetailsRepository) {     
       this.experienceDetailsRepository=experienceDetailsRepository;    	  
    }	
	
	@Override
	public List<ExperienceDetails> listAll() {
		List<ExperienceDetails> exp = new ArrayList<>();
		experienceDetailsRepository.findAll().forEach(exp::add); // fun with Java 8
		return exp;
	}

	@Override
	public ExperienceDetails saveOrUpdate(ExperienceDetails exp) {
		// TODO Auto-generated method stub
		experienceDetailsRepository.save(exp);
		return exp;

	}

}
