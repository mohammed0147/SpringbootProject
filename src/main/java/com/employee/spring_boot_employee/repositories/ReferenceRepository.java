package com.employee.spring_boot_employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.spring_boot_employee.domain.Reference;

@Repository
public interface ReferenceRepository extends JpaRepository<Reference, Long>{

}
