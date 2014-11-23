package com.project.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "employments")
@Access(AccessType.FIELD)
public class Employments {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment",strategy="increment")
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "ROLE")
	private String role;
	
	@Column(name = "YEAR_CONTRACT")
	private Integer year_contract;
	
	@OneToMany
	@JoinColumn(name = "A_ID")
	private Set<Acthors> acthors = new HashSet<>(0);
	
	@OneToOne
	@JoinColumn(name = "S_ID")
	private Spectacles spectacle = new Spectacles();
	
	public Employments() {
		// TODO Auto-generated constructor stub
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getYear_contract() {
		return year_contract;
	}

	public void setYear_contract(Integer year_contract) {
		this.year_contract = year_contract;
	}

	public Set<Acthors> getActhors() {
		return acthors;
	}

	public void setActhors(Set<Acthors> acthors) {
		this.acthors = acthors;
	}

	public Spectacles getSpectacle() {
		return spectacle;
	}

	public void setSpectacle(Spectacles spectacle) {
		this.spectacle = spectacle;
	}

	public Integer getId() {
		return id;
	}

	
}
