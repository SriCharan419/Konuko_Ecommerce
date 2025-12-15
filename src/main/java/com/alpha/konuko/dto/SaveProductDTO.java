package com.alpha.konuko.dto;

public class SaveProductDTO {
	
	private String name;
	private int quantity;
	private String category;
	private double priceperunit;
	private String brandname;
	private String description;
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
	public SaveProductDTO(String name, int quantity, String category, double priceperunit, String brandname,
			String description) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.category = category;
		this.priceperunit = priceperunit;
		this.brandname = brandname;
		this.description = description;
	}
	public SaveProductDTO() {
		super();
	}
	@Override
	public String toString() {
		return "SaveProductDTO [name=" + name + ", quantity=" + quantity + ", category=" + category + ", priceperunit="
				+ priceperunit + ", brandname=" + brandname + ", description=" + description + "]";
	}
}
