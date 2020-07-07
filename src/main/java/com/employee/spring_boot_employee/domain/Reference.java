package com.employee.spring_boot_employee.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "reference")
public class Reference {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String refFirstName;
	private String refLastName;
	private String email;
	private Date dob;
	private String bloodGroup;
	private long phoneNum;
	
	
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "alternative_Contacts_id", referencedColumnName = "id")
	 private AlternativeContacts alternative;

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
