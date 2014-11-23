package com.project.hibernate.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "acthors")
@Access(AccessType.FIELD)
public class Acthors {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment",strategy="increment")
	@Column(name = "ID")
	private Integer id;
	
	@Pattern(regexp="^[a-zA-z].{1,20}$")
	@Size(max = 20,min = 1,message = "name is to short or long")
	@Column(name = "NAME")
	private String name;
	
	@Pattern(regexp="^[a-zA-z].{1,20}$")
	@Size(max = 20,min = 1,message = "surname is to short or long")
	@Column(name = "SURNAME")
	private String surname;
	
	@Size(max = 4,min = 1,message = "age is to short or long")
	@Column(name = "AGE")
	private Integer age;

	@Pattern(regexp="^[a-zA-z].{1,20}$")
	@Column(name = "APPOINTMENT")
	private String appointment;
	
	@Pattern(regexp="^[0-9].{1,10}$")
	@Column(name = "CARRER")
	private Integer carrer;
	
	
	public Acthors() {
		// TODO Auto-generated constructor stub
	}

	public Acthors(String name, String surname, Integer age, String appointment, Integer carrer) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.appointment = appointment;
		this.carrer = carrer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAppointment() {
		return appointment;
	}

	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}

	public Integer getCarrer() {
		return carrer;
	}

	public void setCarrer(Integer carrer) {
		this.carrer = carrer;
	}

	public Integer getId() {
		return id;
	}
	
	

}
