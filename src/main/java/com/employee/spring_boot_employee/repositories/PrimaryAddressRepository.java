package com.employee.spring_boot_employee.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.spring_boot_employee.domain.PrimaryAddress;

@Repository
public interface PrimaryAddressRepository extends JpaRepository<PrimaryAddress ,Long> {

	
	@Query("select distinct al from PrimaryAddress al WHERE al.employee.id = :employee_id")
	List<PrimaryAddress> getByEmployeeId(@Param("employee_id")Long employee_id);

	@Query("select distinct al from PrimaryAddress al WHERE al.employee.id = :employee_id AND al.id = :address_id" )
	PrimaryAddress getPrimaryAddressByEmpIdAndPriId(@Param("employee_id")Long employee_id ,@Param("address_id")Long address_id);

}
