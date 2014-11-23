package com.project.hibernate.entity;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "spectacles")
@Access(AccessType.FIELD)
public class Spectacles {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment",strategy="increment")
	@Column(name = "ID")
	private Long id;
	
	@NotNull
	@Column(name = "NAME")
	private String name;
	
	@Column(name="YEAR_OF_EMPL")
	
	private Long year;
	
	@Size(min=1,max = 10)
	@Pattern(regexp="^[0-9].{1,10}$")
	@Column(name = "BOUGETTE")
	private Long bougette;

 
	public Spectacles() {
		
	}


	public Spectacles(String name, Long year, Long bougette) {
		super();
		this.name = name;
		this.year = year;
		this.bougette = bougette;
	}





	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 
	public Long getBougette() {
		return bougette;
	}

	public void setBougette(Long bougette) {
		this.bougette = bougette;
	}

	public Long getId() {
		return id;
	}
 
	public Long getYear() {
		return year;
	}


	public void setYear(Long year) {
		this.year = year;
	}

	
	 
}
