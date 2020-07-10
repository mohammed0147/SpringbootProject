package com.employee.spring_boot_employee.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.employee.spring_boot_employee.domain.AlternativeContacts;
import com.employee.spring_boot_employee.repositories.AlternativeContactsRepository;

public class AlternativeContactsServiceimp implements AlternativeContactsService {

	
	@Autowired
	private AlternativeContactsRepository alternativeContactsRepository;
	
	
	@Override
	public List<AlternativeContacts> listAll() {
		List<AlternativeContacts> contacts = new ArrayList<>();
		alternativeContactsRepository.findAll().forEach(contacts::add); // fun with Java 8
		return contacts;
	}

	@Override
	public AlternativeContacts getById(Long id) {
		// TODO Auto-generated method stub
		return alternativeContactsRepository.findById(id).orElse(null);
	}

	@Override
	public AlternativeContacts saveOrUpdate(AlternativeContacts contacts) {
		// TODO Auto-generated method stub
		alternativeContactsRepository.save(contacts);
		return contacts;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		alternativeContactsRepository.deleteById(id);
	}

}
