package com.rest.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity

public class Products {
	
	@Id
	@GeneratedValue
	private int productId;
	private String imageName;
	private String productName;
	private String description;
	private double price;

	
	@OneToMany(mappedBy="productsList")
	 private List<Orders> orderList =new ArrayList<Orders>();
	
   // @ManyToOne
	//@JoinColumn(name="OrderId")
	//private Orders ordersList;
	
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(int productId, String imageName, String productName, String description, double price) {
		super();
		this.productId = productId;
		this.imageName = imageName;
		this.productName = productName;
		this.description = description;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	

	
	
	
	
}
