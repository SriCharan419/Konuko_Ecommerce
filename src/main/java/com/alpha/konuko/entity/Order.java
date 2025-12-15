package com.alpha.konuko.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToMany
	private List<Product> purchaselist;
	@OneToOne
	private Customer customer;
	@OneToOne
	private Carrier carrier;
	private String orderstatus;
	private String date;
	@OneToOne
	private Address pickuploc;
	@OneToOne
	private Address deliveryloc;
	private String expecteddeliverydate;
	private double totalprice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Product> getPurchaselist() {
		return purchaselist;
	}
	public void setPurchaselist(List<Product> purchaselist) {
		this.purchaselist = purchaselist;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Carrier getCarrier() {
		return carrier;
	}
	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}
	public String getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Address getPickuploc() {
		return pickuploc;
	}
	public void setPickuploc(Address pickuploc) {
		this.pickuploc = pickuploc;
	}
	public Address getDeliveryloc() {
		return deliveryloc;
	}
	public void setDeliveryloc(Address deliveryloc) {
		this.deliveryloc = deliveryloc;
	}
	public String getExpecteddeliverydate() {
		return expecteddeliverydate;
	}
	public void setExpecteddeliverydate(String expecteddeliverydate) {
		this.expecteddeliverydate = expecteddeliverydate;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public Order(List<Product> purchaselist, Customer customer, Carrier carrier, String orderstatus,
			String date, Address pickuploc, Address deliveryloc, String expecteddeliverydate, double totalprice) {
		super();
		this.purchaselist = purchaselist;
		this.customer = customer;
		this.carrier = carrier;
		this.orderstatus = orderstatus;
		this.date = date;
		this.pickuploc = pickuploc;
		this.deliveryloc = deliveryloc;
		this.expecteddeliverydate = expecteddeliverydate;
		this.totalprice = totalprice;
	}
	public Order() {
		super();
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", purchaselist=" + purchaselist + ", customer=" + customer + ", carrier=" + carrier
				+ ", orderstatus=" + orderstatus + ", date=" + date + ", pickuploc=" + pickuploc + ", deliveryloc="
				+ deliveryloc + ", expecteddeliverydate=" + expecteddeliverydate + ", totalprice=" + totalprice + "]";
	}
}
