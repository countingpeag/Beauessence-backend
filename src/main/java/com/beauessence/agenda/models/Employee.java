package com.beauessence.agenda.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "idEmployee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_EMPLOYEE")
	private Integer idEmployee;
	@NotBlank(message="Name is required")
	private String name;
	private String lastName;
	@NotBlank(message="Phone is required")
	@Size(min=8, max=10, message= "The phone should be more than 8 digits and less than 10.")	
	private String phone;
	@NotBlank(message="Email is required")
	private String email;
	@OneToMany(mappedBy="employee")
	private Set<Sale> sales;
	
	public void setIdEmployee(Integer idEmployee) {
		this.idEmployee = idEmployee;
	}
	public Integer getIdEmployee() {
		return idEmployee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Sale> getSales() {
		return sales;
	}
	public void setSales(Set<Sale> sales) {
		this.sales = sales;
	}
	
	@Override
	public String toString() {
		return "Employee [idEmployee=" + idEmployee + ", name=" + name + ", lastName=" + lastName + ", phone=" + phone
				+ ", email=" + email + ", sales=" + sales + "]";
	}
}
