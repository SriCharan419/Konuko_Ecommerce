package com.alpha.konuko.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private long mobileno;
	private String mail;
	@OneToMany
	private List<Address> alist=new ArrayList<Address>();
	@OneToMany
	private List<Order> olist;
	@OneToMany
	private List<Product> cart=new ArrayList<Product>();
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
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public List<Address> getAlist() {
		return alist;
	}
	public void setAlist(List<Address> alist) {
		this.alist = alist;
	}
	public List<Order> getOlist() {
		return olist;
	}
	public void setOlist(List<Order> olist) {
		this.olist = olist;
	}
	public List<Product> getCart() {
		return cart;
	}
	public void setCart(List<Product> cart) {
		this.cart = cart;
	}
	public Customer(String name, long mobileno, String mail, List<Address> alist, List<Order> olist,
			List<Product> cart) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.mail = mail;
		this.alist = alist;
		this.olist = olist;
		this.cart = cart;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", mobileno=" + mobileno + ", mail=" + mail + ", alist="
				+ alist + ", olist=" + olist + ", cart=" + cart + "]";
	}
}
