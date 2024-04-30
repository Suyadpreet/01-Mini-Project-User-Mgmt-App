package com.example.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
public class UserAccount 
{
	
	@Id
	@GeneratedValue
	private Integer userId;
	
	private String fullName;
	
	private String email;

	private Long phno;
	
	private String gender;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	private Long ssn;
	
	private String activeSw;
	
	@CreationTimestamp
	@Column(name = "createdDate",updatable = false)
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(name = "updatedDate",insertable = false)
	private LocalDate updatedDate;
	
	public Integer getUserId()
	{
		return userId;
	}

	public void setUserId(Integer userId) 
	{
		this.userId = userId;
	}

	public String getFullName() 
	{
		return fullName;
	}

	public void setFullName(String fullName) 
	{
		this.fullName = fullName;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public Long getPhno() 
	{
		return phno;
	}

	public void setPhno(Long phno) 
	{
		this.phno = phno;
	}

	public String getGender() 
	{
		return gender;
	}

	public void setGender(String gender) 
	{
		this.gender = gender;
	}

	public LocalDate getDob() 
	{
		return dob;
	}

	public void setDob(LocalDate dob) 
	{
		this.dob = dob;
	}

	public Long getSsn() 
	{
		return ssn;
	}

	public void setSsn(Long ssn) 
	{
		this.ssn = ssn;
	}

	public String getActiveSw() 
	{
		return activeSw;
	}

	public void setActiveSw(String activeSw) 
	{
		this.activeSw = activeSw;
	}

	public LocalDate getCreatedDate() 
	{
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) 
	{
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() 
	{
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) 
	{
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() 
	{
		return "UserAccount [userId=" + userId + ", fullName=" + fullName + ", email=" + email + ", phno=" + phno
				+ ", gender=" + gender + ", dob=" + dob + ", ssn=" + ssn + ", activeSw=" + activeSw + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + "]";
	}
	
	
}
