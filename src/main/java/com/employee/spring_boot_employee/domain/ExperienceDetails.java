package com.employee.spring_boot_employee.domain;

import java.util.Date;

import java.util.List;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "experienceDetails")
public class ExperienceDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private String preCompanyName;
	private int experience;
	@JsonFormat(pattern = "yyyy-mm-dd",shape = Shape.STRING)
	@Column(name = "doj")
	private Locale doj;
	
	@JsonFormat(pattern = "yyyy-mm-dd",shape = Shape.STRING)
	@Column(name = "doe")
	private Locale doe;
	private String technologies;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id")
	@JsonBackReference
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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
