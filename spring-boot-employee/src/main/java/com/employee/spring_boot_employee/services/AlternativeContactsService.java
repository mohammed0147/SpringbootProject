package com.employee.spring_boot_employee.services;

import java.util.List;

import com.employee.spring_boot_employee.domain.AlternativeContacts;

public interface AlternativeContactsService {

	List<AlternativeContacts> listAll();

	AlternativeContacts getById(Long id);

	AlternativeContacts saveOrUpdate(AlternativeContacts contacts);

    void delete(Long id);
}
