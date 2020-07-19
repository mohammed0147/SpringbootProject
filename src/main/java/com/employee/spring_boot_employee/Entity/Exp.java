package com.employee.spring_boot_employee.Entity;

import java.util.Date;

public class Exp {
	private long id;
    private String preCompanyName;
	private int experience;
	private Date doj;
	private Date doe;
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
	
}
