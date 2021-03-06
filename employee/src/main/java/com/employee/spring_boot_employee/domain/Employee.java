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
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private PrimaryAddress primaryAddress;
	private String secondaryAddress;
	private long phoneNumber;
	
	@JsonFormat(pattern = "yyyy-mm-dd",shape = Shape.STRING)
	@Column(name = "dob")
	private Locale dob;
	
	private String bloodGroup;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	public PrimaryAddress getPrimaryAddress() {
		return primaryAddress;
	}

	public void setPrimaryAddress(PrimaryAddress primaryAddress) {
		this.primaryAddress = primaryAddress;
	}

	public String getSecondaryAddress() {
		return secondaryAddress;
	}

	public void setSecondaryAddress(String secondaryAddress) {
		this.secondaryAddress = secondaryAddress;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	

	public Locale getDob() {
		return dob;
	}

	public void setDob(Locale dob) {
		this.dob = dob;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

}
