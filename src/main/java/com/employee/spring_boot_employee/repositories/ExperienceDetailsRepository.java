package com.employee.spring_boot_employee.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.employee.spring_boot_employee.domain.ExperienceDetails;
import com.employee.spring_boot_employee.domain.Reference;

@Repository
public interface ExperienceDetailsRepository extends JpaRepository<ExperienceDetails, Long> {

	@Query("select distinct al from ExperienceDetails al WHERE al.employee.id = :employee_id")
	List<ExperienceDetails> getByEmployeeId(@Param("employee_id")Long  employee_id);

	}
