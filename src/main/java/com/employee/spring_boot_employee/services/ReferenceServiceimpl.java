package com.employee.spring_boot_employee.services;

import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.spring_boot_employee.Entity.Emp;
import com.employee.spring_boot_employee.Entity.Ref;
import com.employee.spring_boot_employee.domain.Reference;
import com.employee.spring_boot_employee.repositories.ReferenceRepository;

@Service
public class ReferenceServiceimpl implements ReferenceService {
	@Autowired
	private ReferenceRepository referenceRepository;
	 
	
	
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
	public List<com.employee.spring_boot_employee.Entity.Ref> getByEmployeeId(Long employee_id) {
		// TODO Auto-generated method stub
		List<Reference> ref=referenceRepository.getByEmployeeId(employee_id);
		return toDomain(ref);
	}
	
	public List<com.employee.spring_boot_employee.Entity.Ref> toDomain(List<Reference> reference) {
		// TODO Auto-generated method stub
		List<com.employee.spring_boot_employee.Entity.Ref> r=new ArrayList<>();
		for(Reference var : reference) {
			Ref a=new Ref();
			a.setId(var.getId());
			a.setPhoneNum(var.getPhoneNum());
			a.setEmail(var.getEmail());
			a.setRefFirstName(var.getRefFirstName());
			a.setRefLastName(var.getRefLastName());
			a.setDob(var.getDob());
			a.setBloodGroup(var.getBloodGroup());
			Emp e=new Emp();
			e.setPhoneNumber(var.getEmployee().getPhoneNumber());
			e.setPrimaryAddress(var.getEmployee().getPrimaryAddress());
			e.setLastName(var.getEmployee().getLastName());
			e.setFirstName(var.getEmployee().getFirstName());
			e.setDob(var.getEmployee().getDob());
			e.setBloodGroup(var.getEmployee().getBloodGroup());
			e.setId(var.getEmployee().getId());
			a.setEmp(e);
			r.add(a);
			}
		return r;
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
