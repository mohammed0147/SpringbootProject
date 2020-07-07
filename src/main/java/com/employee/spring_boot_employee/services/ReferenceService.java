package com.employee.spring_boot_employee.services;

import java.util.List;
import com.employee.spring_boot_employee.domain.Reference;

public interface ReferenceService {

	List<Reference> listAll();

	Reference getById(Long id);

	Reference saveOrUpdate(Reference reference);

    void delete(Long id);

}
