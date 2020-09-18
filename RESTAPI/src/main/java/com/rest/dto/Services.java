package com.rest.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Services {
	
	@Id
	@GeneratedValue
	private int serviceId;
	private String name;
	private String petType;
	private int numOfDays;
	private String fromDate;
	private String serviceAddress;
	private String phoneno;
	private double totalPrice;
	
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	  
	
	public Services() {
		super();
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public int getNumOfDays() {
		return numOfDays;
	}

	public void setNumOfDays(int numOfDays) {
		this.numOfDays = numOfDays;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}


	public String getServiceAddress() {
		return serviceAddress;
	}

	public void setServiceAddress(String serviceAddress) {
		this.serviceAddress = serviceAddress;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Services [serviceId=" + serviceId + ", name=" + name + ", petType=" + petType + ", numOfDays="
				+ numOfDays + ", fromDate=" + fromDate + ", serviceAddress=" + serviceAddress + ", phoneno=" + phoneno
				+ ", totalPrice=" + totalPrice + ", customer=" + customer + "]";
	}
	
	
	
	
}
