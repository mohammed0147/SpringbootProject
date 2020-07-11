package com.employee.spring_boot_employee.services;

import java.util.List;
import com.employee.spring_boot_employee.domain.ExperienceDetails;

public interface ExperienceDetailsService {

	List<ExperienceDetails> listAll();

	//ExperienceDetails getById(Long id);

	ExperienceDetails saveOrUpdate(ExperienceDetails exp);

    //void delete(Long id);
}
