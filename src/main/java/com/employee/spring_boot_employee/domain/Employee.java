package com.employee.spring_boot_employee.domain;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private String primaryAddress;
	private String secondaryAddress;
	private long phoneNumber;
	private Date dob;
	private String bloodGroup;
	
	
	
  @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "reference_id")
 	private Reference reference;
	
 // @JsonBackReference
	public Reference getReference() {
		return reference;
	}
	
	public void setReference(Reference reference) {
		this.reference = reference;
	}

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alternativeContacts_id")
    private AlternativeContacts alternative;

	//@JsonBackReference
	public AlternativeContacts getAlternative() {
		return alternative;
	}

	public void setAlternative(AlternativeContacts alternative) {
		this.alternative = alternative;
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
