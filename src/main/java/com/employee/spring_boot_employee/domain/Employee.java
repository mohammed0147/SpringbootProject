package com.employee.spring_boot_employee.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private long id;
	private String firstName;
	private String lastName;
	private String primaryAddress;
	private String secondaryAddress;
	private long phoneNumber;
	private Date dob;
	private String bloodGroup;

	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Reference> reference;

	public List<Reference> getReference() {
		return reference;
	}

	public void setReference(List<Reference> reference) {
		this.reference = reference;
	}
	

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<AlternativeContacts> alternativeContacts;

	public List<AlternativeContacts> getAlternativeContacts() {
		return alternativeContacts;
	}

	public void setAlternativeContacts(List<AlternativeContacts> alternativeContacts) {
		this.alternativeContacts = alternativeContacts;
	}
	

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<ExperienceDetails> expDetails;

	public List<ExperienceDetails> getExpDetails() {
		return expDetails;
	}

	public void setExpDetails(List<ExperienceDetails> expDetails) {
		this.expDetails = expDetails;
	}
	
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

	public String getPrimaryAddress() {
		return primaryAddress;
	}

	public void setPrimaryAddress(String primaryAddress) {
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

}
