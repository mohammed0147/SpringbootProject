package com.employee.spring_boot_employee.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.employee.spring_boot_employee.domain.Employee;
import com.employee.spring_boot_employee.domain.Reference;
@Service
public interface ReferenceService {

	List<Reference> listAll();

	Reference getById(Long id);

	Reference saveOrUpdate(Reference reference);

    void delete(Long id);

   List<com.employee.spring_boot_employee.Entity.Ref> getByEmployeeId(Long employee_id);

   Employee CreateRefByEmp(List<Reference> var ,Long employee_id);

     

}
