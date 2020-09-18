package com.rest.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import java.util.ArrayList;

@XmlRootElement
@Entity
public class Customer {
	@Id
	@GeneratedValue
	private int customerId;
	private String customerName;
	private String mobileNum;
	private String address;
	private String email;
	private String password;
	
	/* @OneToMany(mappedBy="Customer",fetch = FetchType.LAZY)
	private List<Orders> ordersList =new ArrayList<Orders>();

	 @OneToMany(mappedBy="Customer",fetch = FetchType.LAZY)
	 private List<Service> serviceList =new ArrayList<Service>(); */
	
	@OneToMany(mappedBy="customer")
	private List<Orders> ordersList =new ArrayList<Orders>();

	 @OneToMany(mappedBy="customer")
	 private List<Services> serviceList =new ArrayList<Services>();
	 
	 public Customer() {
		super();
	}

	
	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getMobileNum() {
		return mobileNum;
	}


	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;

	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

}

	
	

	