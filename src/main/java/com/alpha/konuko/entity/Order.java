package com.alpha.konuko.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToMany
	@JoinTable(
	    name = "orders_purchaselist",
	    joinColumns = @JoinColumn(name = "order_id"),
	    inverseJoinColumns = @JoinColumn(name = "purchaselist_id")
	)
	private List<Product> purchaseLists;
	@OneToOne
	private Customer customer;
	@OneToOne
	private Carrier carrier;
	private String orderstatus="PENDING";
	private LocalDate date;
	@OneToOne
	private Address pickuploc;
	@OneToOne
	private Address deliveryloc;
	private LocalDate expecteddeliverydate;
	private double totalprice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Product> getPurchaseLists() {
		return purchaseLists;
	}
	public void setPurchaseLists(List<Product> purchaseLists) {
		this.purchaseLists = purchaseLists;
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
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
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
	public LocalDate getExpecteddeliverydate() {
		return expecteddeliverydate;
	}
	public void setExpecteddeliverydate(LocalDate expecteddeliverydate) {
		this.expecteddeliverydate = expecteddeliverydate;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public Order(int id, List<Product> purchaseLists, Customer customer, Carrier carrier, String orderstatus,
			LocalDate date, Address pickuploc, Address deliveryloc, LocalDate expecteddeliverydate, double totalprice) {
		super();
		this.id = id;
		this.purchaseLists = purchaseLists;
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
		return "Order [id=" + id + ", purchaseLists=" + purchaseLists + ", customer=" + customer + ", carrier="
				+ carrier + ", orderstatus=" + orderstatus + ", date=" + date + ", pickuploc=" + pickuploc
				+ ", deliveryloc=" + deliveryloc + ", expecteddeliverydate=" + expecteddeliverydate + ", totalprice="
				+ totalprice + "]";
	}
}
