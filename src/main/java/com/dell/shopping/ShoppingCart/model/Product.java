package com.dell.shopping.ShoppingCart.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="product_id")
	private long productId;
	@Column(name="product_name")
	private String productName;

	@Column(name = "price")
	private double price;
	
	@Column(name = "date_added")
	private String dateAdded;  

	@ManyToOne()
	@JoinColumn(name = "productgroup_id")
	private productgroup productgrp;
	
	public Product() 
	{
		
	}

	public Product(long productId, String productName, double price, String dateAdded, productgroup productgrp) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.dateAdded = dateAdded;
		this.productgrp = productgrp;
	}


	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public productgroup getProductgrp() {
		return productgrp;
	}

	public void setProductgrp(productgroup productgrp) {
		this.productgrp = productgrp;
	}

	 

	
}
