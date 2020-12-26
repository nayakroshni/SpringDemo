package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;


@Entity
@Table(name="User")
public class UserModel
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "userID")
	private Integer userID;
	
	@Column(name = "surName")
	private String surName;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "middleName")
	public String middleName;
	
	
	@ManyToOne
	@JoinColumn(name="maritalStatusID")
	private MaritalModel maritalModel;
	
	public Integer getUserID()
	{
		return userID;
	}
	public void setUserID(Integer userID)
	{
		this.userID = userID;
	}
	public String getSurName()
	{
		return surName;
	}
	public void setSurName(String surName)
	{
		this.surName = surName;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getMiddleName()
	{
		return middleName;
	}
	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}
	public MaritalModel getMaritalModel()
	{
		return maritalModel;
	}
	public void setMaritalModel(MaritalModel maritalModel)
	{
		this.maritalModel = maritalModel;
	}
	
	
	
}
