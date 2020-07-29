package com.employee.spring_boot_employee.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.spring_boot_employee.Entity.Ref;
import com.employee.spring_boot_employee.domain.Employee;
import com.employee.spring_boot_employee.domain.Reference;
@Repository
public interface ReferenceRepository extends JpaRepository<Reference, Long >{
	
	@Query("select distinct al from Reference al WHERE al.employee.id = :employee_id")
	List<Reference> getByEmployeeId(@Param("employee_id")Long  employee_id);
	
	
	@Query("select distinct al from Reference al WHERE al.employee.id = :employee_id AND al.id = :reference_id" )
	Reference getReferenceByEmpIdAndRefId(@Param("employee_id")Long employee_id ,@Param("reference_id")Long reference_id);
}
