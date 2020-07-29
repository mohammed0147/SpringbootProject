package com.employee.spring_boot_employee.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.employee.spring_boot_employee.domain.Reference;
import com.employee.spring_boot_employee.repositories.ReferenceRepository;

public class ReferenceServiceimpl implements ReferenceService {
	
	private ReferenceRepository referenceRepository;
	 
	@Autowired
	public ReferenceServiceimpl(ReferenceRepository referenceRepository) {
		this.referenceRepository=referenceRepository;
	}
	
	@Override
	public List<Reference> listAll() {
		// TODO Auto-generated method stub
		List<Reference> ref = new ArrayList<>();
		referenceRepository.findAll().forEach(ref::add); // fun with Java 8
		return ref;
	}

	@Override
	public Reference getById(Long id) {
		// TODO Auto-generated method stub
		return referenceRepository.findById(id).orElse(null);
	}

	@Override
	public Reference saveOrUpdate(Reference reference) {
		// TODO Auto-generated method stub
		referenceRepository.save(reference);
		return reference;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		referenceRepository.deleteById(id);
	}

}
