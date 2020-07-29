package com.employee.spring_boot_employee.domain;

//import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name ="experience")
public class ExperienceDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sNo;
	private String preCompanyName;
	private int experience;
	@JsonFormat(pattern = "yyyy-mm-dd",shape = Shape.STRING)
	@Column(name = "doj")
	private Locale doj;
	
	@JsonFormat(pattern = "yyyy-mm-dd",shape = Shape.STRING)
	@Column(name = "doe")
	private Locale doe;
	
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
	
	
	
	public Locale getDoj() {
		return doj;
	}
	public void setDoj(Locale doj) {
		this.doj = doj;
	}
	public Locale getDoe() {
		return doe;
	}
	public void setDoe(Locale doe) {
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
