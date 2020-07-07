package com.employee.spring_boot_employee.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="alternativeContacts")
public class AlternativeContacts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long alternativeNum;
	private String alternativeName;
	private String alternativeEmail;
	
	

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
