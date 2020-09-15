package com.beauessence.agenda.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "idSchedule")
public class Schedule {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_SCHEDULE")
	private Integer idSchedule;
	private Date scheduleDate;
	private Date scheduleTime;
	private String comment;
	@OneToOne
	@JoinColumn(name = "CUSTOMER_ID_CUSTOMER")
	private Customer customer;
	
	public Integer getIdSchedule() {
		return idSchedule;
	}
	public void setIdSchedule(Integer idSchedule) {
		this.idSchedule = idSchedule;
	}
	public Date getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public Date getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(Date scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
