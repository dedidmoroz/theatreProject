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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "employments")
 
public class Employments {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment",strategy="increment")
	@Column(name = "ID")
	private Integer id;
	
	@NotNull
	@Column(name = "ROLE")
	private String role;
	
	@Size(min=1,max = 4)
	@Pattern(regexp="^[0-9].{1,4}$")
	@Column(name = "YEAR_CONTRACT")
	private Long year_contract;
	
	@OneToOne
	@JoinColumn(name = "A_ID")
	private Acthors achtor;
	
	@OneToOne
	@JoinColumn(name = "S_ID")
	private Spectacles spectacle = new Spectacles();
	
	@Transient
	private String act;
	@Transient
	private String spec;
	
	public Employments() {
	}

	
	
	public Employments(String role, Long year_contract) {
		super();
		this.role = role;
		this.year_contract = year_contract;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}




	public Long getYear_contract() {
		return year_contract;
	}

	public void setYear_contract(Long year_contract) {
		this.year_contract = year_contract;
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



	public String getAct() {
		return act;
	}



	public void setAct(String act) {
		this.act = act;
	}



	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}



	public Acthors getAchtor() {
		return achtor;
	}

	public void setAchtor(Acthors achtor) {
		this.achtor = achtor;
	}

	
	
}
