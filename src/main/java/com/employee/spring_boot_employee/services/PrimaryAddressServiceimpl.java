package com.employee.spring_boot_employee.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.employee.spring_boot_employee.domain.PrimaryAddress;
import com.employee.spring_boot_employee.repositories.PrimaryAddressRepository;

public class PrimaryAddressServiceimpl  implements PrimaryAddressService{

	@Autowired
	private PrimaryAddressRepository primaryAddressRepository;
	
	
	@Override
	public List<PrimaryAddress> listAll() {
		List<PrimaryAddress> address = new ArrayList<>();
		primaryAddressRepository.findAll().forEach(address::add); // fun with Java 8
		return address;
	}

	@Override
	public PrimaryAddress getById(Long id) {
		// TODO Auto-generated method stub
		return primaryAddressRepository.findById(id).orElse(null);
	}
	

	@Override
	public PrimaryAddress saveOrUpdate(PrimaryAddress address) {
		// TODO Auto-generated method stub
		primaryAddressRepository.save(address);
		return address;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		primaryAddressRepository.deleteById(id);
	}


}
