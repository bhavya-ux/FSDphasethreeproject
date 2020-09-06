package com.dell.shopping.ShoppingCart.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="productgroup")
public class productgroup {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productgroup_id")
	private long productgroupId;
	
	@Column(name = "productgroup_name")
	private String productgroupName;
	
	@JsonIgnoreProperties(value={"productgrp"})
	@OneToMany(mappedBy="productgrp")
	private Set<Product> products;

	public  productgroup()
	{
		
	}
	public productgroup(long productgroupId, String productgroupName, Set<Product> products) {
		super();
		this.productgroupId = productgroupId;
		this.productgroupName = productgroupName;
		this.products = products;
	}
	public long getproductgroupId() {
		return productgroupId;
	}
	public void setproductgroupId(long productgroupId) {
		this.productgroupId = productgroupId;
	}
	public String getproductgroupName() {
		return productgroupName;
	}
	public void setproductgroupName(String productgroupName) {
		this.productgroupName = productgroupName;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}
