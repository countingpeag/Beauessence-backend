package com.beauessence.agenda.models;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.validation.constraints.NotNull;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "idSale")
@Table(name="sale")
public class Sale {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_SALE")
	private Integer idSale;
	@NotNull(message = "Date cannot be null")
	private Date saleDate;
	@NotNull(message = "Time cannot be null")
	private Date saleTime;
	@NotNull(message = "Total amount cannot be null")
	private Integer total;
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID_EMPLOYEE")
	private Employee employee;
	@OneToMany
	@JoinColumn(name="ID_SERVICE")
	private Set<ServiceModel> services;
	
	public Integer getIdSale() {
		return idSale;
	}
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public Date getSaleTime() {
		return saleTime;
	}
	public void setSaleTime(Date saleTime) {
		this.saleTime = saleTime;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Set<ServiceModel> getServices() {
		return services;
	}
	public void setServices(Set<ServiceModel> services) {
		this.services = services;
	}
}
