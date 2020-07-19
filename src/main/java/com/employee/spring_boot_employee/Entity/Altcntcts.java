package com.employee.spring_boot_employee.Entity;

public class Altcntcts {

	private long id;
	private long alternativeNum;
	private String alternativeName;
	private String alternativeEmail;
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
