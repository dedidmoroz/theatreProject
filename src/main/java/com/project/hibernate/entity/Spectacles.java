package com.project.hibernate.entity;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "spectacles")
@Access(AccessType.FIELD)
public class Spectacles {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment",strategy="increment")
	@Column(name = "ID")
	private Integer id;
	
	@NotNull
	@Column(name = "NAME")
	private String name;
	
	@Column(name="YEAR_OF_EMPL")
	@Temporal(TemporalType.DATE)
	@Basic(fetch=FetchType.LAZY)
	private Date year;
	
	@Column(name = "BOUGETTE")
	private Integer bougette;

	@NotNull
	@OneToOne(mappedBy="spectacle")
	private Employments employment; 
	
	public Spectacles() {
		
	}

	public Spectacles(String name, Date year, Integer bougette) {
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

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public Integer getBougette() {
		return bougette;
	}

	public void setBougette(Integer bougette) {
		this.bougette = bougette;
	}

	public Integer getId() {
		return id;
	}

	public Employments getEmployment() {
		return employment;
	}

	
}
