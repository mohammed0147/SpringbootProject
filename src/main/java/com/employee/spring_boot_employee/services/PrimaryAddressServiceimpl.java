package com.employee.spring_boot_employee.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.spring_boot_employee.Entity.Emp;
import com.employee.spring_boot_employee.Entity.pri;
import com.employee.spring_boot_employee.domain.Employee;
import com.employee.spring_boot_employee.domain.PrimaryAddress;
import com.employee.spring_boot_employee.repositories.EmployeeRepository;
import com.employee.spring_boot_employee.repositories.PrimaryAddressRepository;
@Service
public class PrimaryAddressServiceimpl  implements PrimaryAddressService{

	@Autowired
	private PrimaryAddressRepository primaryAddressRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
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
	public List<pri> getByEmployeeId(Long employee_id) {
	// TODO Auto-generated method stub
	List<PrimaryAddress> pri=primaryAddressRepository.getByEmployeeId(employee_id);
	return toDomain(pri);
	}
	
	public List<pri> toDomain(List<PrimaryAddress> primaryAddress) {
		// TODO Auto-generated method stub
		List<pri> r=new ArrayList<>();
		for(PrimaryAddress var : primaryAddress) {
		pri a=new pri();
		a.setId(var.getId());
		a.setHouseNumber(var.getHouseNumber());
		a.setAddressLine1(var.getAddressLine1());
		a.setAddressLine2(var.getAddressLine2());
		a.setCity(var.getCity());
		a.setState(var.getState());
		a.setCountry(var.getCountry());
		a.setPincode(var.getPincode());
		a.setIsPrimary(var.getIsPrimary());
    
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
	public PrimaryAddress saveOrUpdate(PrimaryAddress address) {
		// TODO Auto-generated method stub
		primaryAddressRepository.save(address);
		return address;
	}
	
	@Override
	public Employee CreatePriByEmp(List<PrimaryAddress> var, Long employeeId) {

	Employee employee = employeeRepository.findById(employeeId).orElse(null);
	List<PrimaryAddress> entityList = new ArrayList<PrimaryAddress>();
	for(PrimaryAddress r : var){
	r.setEmployee(employee);

	entityList.add(r);
	}
	employee.setPrimaryAddress(entityList);
	return employeeRepository.save(employee);
	}


	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		primaryAddressRepository.deleteById(id);
	}


}
