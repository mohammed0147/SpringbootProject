package com.employee.spring_boot_employee.Entity;

import java.util.Date;
import java.util.Locale;

public class Exp {
	private long id;
    private String preCompanyName;
	private int experience;
	private Locale doj;
	private Locale doe;
	private String technologies;
	private Emp emp;
	
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	
}
