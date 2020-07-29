package com.employee.spring_boot_employee.services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.spring_boot_employee.Entity.Emp;
import com.employee.spring_boot_employee.Entity.Exp;
import com.employee.spring_boot_employee.Entity.Ref;
import com.employee.spring_boot_employee.domain.Employee;
import com.employee.spring_boot_employee.domain.ExperienceDetails;
import com.employee.spring_boot_employee.domain.Reference;
import com.employee.spring_boot_employee.repositories.EmployeeRepository;
import com.employee.spring_boot_employee.repositories.ExperienceDetailsRepository;
@Service
public class ExperienceDetailsServiceimpl implements ExperienceDetailsService {

	@Autowired
	private ExperienceDetailsRepository experienceDetailsRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	

	public ExperienceDetailsServiceimpl(ExperienceDetailsRepository experienceDetailsRepository) {
		this.experienceDetailsRepository = experienceDetailsRepository;
	}
	@Override
	public List<com.employee.spring_boot_employee.Entity.Exp> getByEmployeeId(Long employee_id) {
		// TODO Auto-generated method stub
		List<ExperienceDetails> exp = experienceDetailsRepository.getByEmployeeId(employee_id);
		return toDomain(exp);
	}
	
	public List<com.employee.spring_boot_employee.Entity.Exp> toDomain(List<ExperienceDetails> expDetails) {
		// TODO Auto-generated method stub
		List<com.employee.spring_boot_employee.Entity.Exp> r=new ArrayList<>();
		for( ExperienceDetails var : expDetails) {
			Exp a=new Exp();
			a.setId(var.getId());
			a.setPreCompanyName(var.getPreCompanyName());
			a.setTechnologies(var.getTechnologies());
			a.setExperience(var.getExperience());
			a.setDoj(var.getDoj());
			a.setDoe(var.getDoe());
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
	public List<ExperienceDetails> listAll() {
		List<ExperienceDetails> exp = new ArrayList<>();
		experienceDetailsRepository.findAll().forEach(exp::add); // fun with Java 8
		return exp;
	}
	
	@Override
	public ExperienceDetails saveOrUpdate(ExperienceDetails exp) {
		// TODO Auto-generated method stub
		experienceDetailsRepository.save(exp);
		return exp;

	}
	@Override
	public ExperienceDetails getById(Long id) {
		// TODO Auto-generated method stub
		return experienceDetailsRepository.findById(id).orElse(null);
		
	}
	
	@Override
	public Employee CreateExpByEmp(List<ExperienceDetails> var, Long employeeId) {
		
		Employee employee = employeeRepository.findById(employeeId).orElse(null);
                List<ExperienceDetails> entityList = new ArrayList<ExperienceDetails>();
		for(ExperienceDetails r : var){
                        r.setEmployee(employee);

                        entityList.add(r);
                       }
                   employee.setExpDetails(entityList);
		return employeeRepository.save(employee);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		experienceDetailsRepository.deleteById(id);
	}

	
	
}
