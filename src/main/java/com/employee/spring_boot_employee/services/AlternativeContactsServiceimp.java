package com.employee.spring_boot_employee.services;

import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.spring_boot_employee.Entity.Altcntcts;
import com.employee.spring_boot_employee.Entity.Emp;
import com.employee.spring_boot_employee.Entity.Ref;
import com.employee.spring_boot_employee.domain.AlternativeContacts;
import com.employee.spring_boot_employee.domain.Employee;
import com.employee.spring_boot_employee.domain.Reference;
import com.employee.spring_boot_employee.repositories.AlternativeContactsRepository;
import com.employee.spring_boot_employee.repositories.EmployeeRepository;
@Service
public class AlternativeContactsServiceimp implements AlternativeContactsService {

	
	@Autowired
	private AlternativeContactsRepository alternativeContactsRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
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
	public List<com.employee.spring_boot_employee.Entity.Altcntcts> getByEmployeeId(Long employee_id) {
		// TODO Auto-generated method stub
		List<AlternativeContacts> alt=alternativeContactsRepository.getByEmployeeId(employee_id);
		return toDomain(alt);
	}
	
	public List<com.employee.spring_boot_employee.Entity.Altcntcts> toDomain(List<AlternativeContacts> altcntct) {
		// TODO Auto-generated method stub
		List<com.employee.spring_boot_employee.Entity.Altcntcts> r=new ArrayList<>();
		for(AlternativeContacts var : altcntct) {
			Altcntcts a=new Altcntcts();
			a.setId(var.getId());
			a.setAlternativeName(var.getAlternativeName());
			a.setAlternativeEmail(var.getAlternativeEmail());
			a.setAlternativeNum(var.getAlternativeNum());
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
	public AlternativeContacts saveOrUpdate(AlternativeContacts contacts) {
		// TODO Auto-generated method stub
		alternativeContactsRepository.save(contacts);
		return contacts;
	}
		@Override
		public Employee CreateAltByEmp(List<AlternativeContacts> var, Long employeeId) {
			
			Employee employee = employeeRepository.findById(employeeId).orElse(null);
            List<AlternativeContacts> entityList = new ArrayList<AlternativeContacts>();
	for(AlternativeContacts r : var){
                    r.setEmployee(employee);

                    entityList.add(r);
                   }
               employee.setAlternativeContacts(entityList);
	return employeeRepository.save(employee);
}
		

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		alternativeContactsRepository.deleteById(id);
	}

	
}
