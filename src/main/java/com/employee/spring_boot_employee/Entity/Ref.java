package com.employee.spring_boot_employee.Entity;

import java.util.Date;

import com.employee.spring_boot_employee.domain.Employee;

public class Ref {

	private long id;
	private String refFirstName;
	private String refLastName;
	private String email;
	private Date dob;
	private String bloodGroup;
	private long phoneNum;
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
	public String getRefFirstName() {
		return refFirstName;
	}
	public void setRefFirstName(String refFirstName) {
		this.refFirstName = refFirstName;
	}
	public String getRefLastName() {
		return refLastName;
	}
	public void setRefLastName(String refLastName) {
		this.refLastName = refLastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	
}
