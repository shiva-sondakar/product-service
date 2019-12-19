package com.shiva.productservice.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private Integer id;
	private String name;
	private String category;
	@Column(precision=14, scale=2)
	private BigDecimal retail_price;
	@Column(precision=14, scale=2)
	private BigDecimal discounted_price;
	private Boolean availability;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public BigDecimal getRetail_price() {
		return retail_price;
	}
	public void setRetail_price(BigDecimal retail_price) {
		this.retail_price = retail_price;
	}
	public BigDecimal getDiscounted_price() {
		return discounted_price;
	}
	public void setDiscounted_price(BigDecimal discounted_price) {
		this.discounted_price = discounted_price;
	}
	public Boolean getAvailability() {
		return availability;
	}
	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}
	
}
