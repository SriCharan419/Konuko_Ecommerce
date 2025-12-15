package com.alpha.konuko.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int quantity;
	private String category;
	private double priceperunit;
	private String brandname;
	private String description;
	private String availabilitystatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPriceperunit() {
		return priceperunit;
	}
	public void setPriceperunit(double priceperunit) {
		this.priceperunit = priceperunit;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAvailabilitystatus() {
		return availabilitystatus;
	}
	public void setAvailabilitystatus(String availabilitystatus) {
		this.availabilitystatus = availabilitystatus;
	}
	public Product(String name, int quantity, String category, double priceperunit, String brandname,
			String description, String availabilitystatus) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.category = category;
		this.priceperunit = priceperunit;
		this.brandname = brandname;
		this.description = description;
		this.availabilitystatus = availabilitystatus;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity + ", category=" + category
				+ ", priceperunit=" + priceperunit + ", brandname=" + brandname + ", description=" + description
				+ ", availabilitystatus=" + availabilitystatus + "]";
	}
}
