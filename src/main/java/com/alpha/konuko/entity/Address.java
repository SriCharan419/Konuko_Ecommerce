package com.alpha.konuko.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String city;
	private int pincode;
	private String state;
	private String country;
	private String addressdescription;
	private long mobileno;
	private String addresstype;
	@ManyToOne
	@JoinColumn(name = "admin_id",nullable = true)
	@JsonIgnore
	private Admin admin;
	@ManyToOne
	@JoinColumn(name = "customer_id",nullable = true)
	@JsonIgnore
	private Customer customer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddressdescription() {
		return addressdescription;
	}
	public void setAddressdescription(String addressdescription) {
		this.addressdescription = addressdescription;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public String getAddresstype() {
		return addresstype;
	}
	public void setAddresstype(String addresstype) {
		this.addresstype = addresstype;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Address(int id, String city, int pincode, String state, String country, String addressdescription,
			long mobileno, String addresstype, Admin admin, Customer customer) {
		super();
		this.id = id;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
		this.addressdescription = addressdescription;
		this.mobileno = mobileno;
		this.addresstype = addresstype;
		this.admin = admin;
		this.customer = customer;
	}
	public Address() {
		super();
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", pincode=" + pincode + ", state=" + state + ", country="
				+ country + ", addressdescription=" + addressdescription + ", mobileno=" + mobileno + ", addresstype="
				+ addresstype + ", admin=" + admin + ", customer=" + customer + "]";
	}
}
