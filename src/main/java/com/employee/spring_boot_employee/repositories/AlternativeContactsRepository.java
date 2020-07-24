package com.employee.spring_boot_employee.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.spring_boot_employee.domain.AlternativeContacts;
import com.employee.spring_boot_employee.domain.Reference;

@Repository
public interface AlternativeContactsRepository extends JpaRepository<AlternativeContacts, Long>{

	@Query("select distinct al from AlternativeContacts al WHERE al.employee.id = :employee_id")
	List<AlternativeContacts> getByEmployeeId(@Param("employee_id")Long  employee_id);
	
	@Query("select distinct al from AlternativeContacts al WHERE al.employee.id = :employee_id AND al.id = :alternativeContacts_id" )
	AlternativeContacts getAltByEmpIdAndAltId(@Param("employee_id")Long employee_id ,@Param("alternativeContacts_id")Long alternativeContacts_id);
}
