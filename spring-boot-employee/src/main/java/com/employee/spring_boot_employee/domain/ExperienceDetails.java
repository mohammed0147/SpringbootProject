package com.employee.spring_boot_employee.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="experience")
public class ExperienceDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sNo;
	private String preCompanyName;
	private int experience;
	private Date doj;
	private Date doe;
	private String technologies;
	
	
	public String getPreCompanyName() {
		return preCompanyName;
	}
	public void setPreCompanyName(String preCompanyName) {
		this.preCompanyName = preCompanyName;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public Date getDoe() {
		return doe;
	}
	public void setDoe(Date doe) {
		this.doe = doe;
	}
	public String getTechnologies() {
		return technologies;
	}
	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}
	public int getsNo() {
		return sNo;
	}
	public void setsNo(int sNo) {
		this.sNo = sNo;
	}
	

}
