package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="merital")
public class MaritalModel
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "maritalStatusID")
	private long maritalStatusID;
	
	@Column(name = "maritalStatus")
	private String maritalStatus;
	
	public long getMaritalStatusID()
	{
		return maritalStatusID;
	}
	public void setMaritalStatusID(long maritalStatusID)
	{
		this.maritalStatusID = maritalStatusID;
	}
	public String getMaritalStatus()
	{
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus)
	{
		this.maritalStatus = maritalStatus;
	}
	
	
}
