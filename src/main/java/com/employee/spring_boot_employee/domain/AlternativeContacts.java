package com.employee.spring_boot_employee.domain;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="alternativeContacts")
public class AlternativeContacts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long alternativeNum;
	private String alternativeName;
	private String alternativeEmail;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id")
	@JsonBackReference
    private Employee employee;
	
    public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAlternativeNum() {
		return alternativeNum;
	}
	public void setAlternativeNum(long alternativeNum) {
		this.alternativeNum = alternativeNum;
	}
	public String getAlternativeName() {
		return alternativeName;
	}
	public void setAlternativeName(String alternativeName) {
		this.alternativeName = alternativeName;
	}
	public String getAlternativeEmail() {
		return alternativeEmail;
	}
	public void setAlternativeEmail(String alternativeEmail) {
		this.alternativeEmail = alternativeEmail;
	}
	}
