package com.employee.spring_boot_employee.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.spring_boot_employee.Entity.pri;
import com.employee.spring_boot_employee.domain.Employee;
import com.employee.spring_boot_employee.domain.PrimaryAddress;
@Service
public interface PrimaryAddressService {

	 
		List<PrimaryAddress> listAll();

		PrimaryAddress getById(Long id);

		PrimaryAddress saveOrUpdate(PrimaryAddress contacts);

	    void delete(Long id);
	    
	    List<pri> getByEmployeeId(Long employee_id);

	    Employee CreatePriByEmp(List<PrimaryAddress> var ,Long employee_id);
}
