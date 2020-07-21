package com.employee.spring_boot_employee.services;

import java.util.List;

import com.employee.spring_boot_employee.domain.PrimaryAddress;

public interface PrimaryAddressService {

	 
		List<PrimaryAddress> listAll();

		PrimaryAddress getById(Long id);

		PrimaryAddress saveOrUpdate(PrimaryAddress contacts);

	    void delete(Long id);
}
