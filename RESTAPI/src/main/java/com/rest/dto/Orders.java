package com.rest.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@XmlRootElement
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property = "orderId")
@Entity

public class Orders {
	@Id
	@GeneratedValue

	private int orderId;
	private int customerId;
	private double totalPrice;
	private String address;
	private int productId;
	private String productName;
	private String productType;
	private int productQuantity;
	
	@ManyToOne
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="ProductId")
	private Orders productsList;
	
	
	//@OneToMany(mappedBy="ordersList")
	 //private List<Products> productList =new ArrayList<Products>();

	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Orders(int orderId, int customerId, double totalPrice, String address, int productId, String productName,
			String productType, int productQuantity, Customer customer) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.totalPrice = totalPrice;
		this.address = address;
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.productQuantity = productQuantity;
		this.customer = customer;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
}
	
	