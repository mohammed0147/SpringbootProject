package com.employee.spring_boot_employee.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.spring_boot_employee.domain.AlternativeContacts;
@Service
public interface AlternativeContactsService {

	List<AlternativeContacts> listAll();

	AlternativeContacts getById(Long id);

	AlternativeContacts saveOrUpdate(AlternativeContacts contacts);

    void delete(Long id);
    
    List<com.employee.spring_boot_employee.Entity.Altcntcts> getByEmployeeId(Long employee_id);
}
