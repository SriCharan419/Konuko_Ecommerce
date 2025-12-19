package com.alpha.konuko.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Carrier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private long mobileno;
	private String mailid;
	private int capacity;
	@OneToMany(mappedBy = "carrier")
	@JsonIgnore
	private List<Order> olist=new ArrayList<>();
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
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public List<Order> getOlist() {
		return olist;
	}
	public void setOlist(List<Order> olist) {
		this.olist = olist;
	}
	public Carrier(int id, String name, long mobileno, String mailid, int capacity, List<Order> olist) {
		super();
		this.id = id;
		this.name = name;
		this.mobileno = mobileno;
		this.mailid = mailid;
		this.capacity = capacity;
		this.olist = olist;
	}
	public Carrier() {
		super();
	}
	@Override
	public String toString() {
		return "Carrier [id=" + id + ", name=" + name + ", mobileno=" + mobileno + ", mailid=" + mailid + ", capacity="
				+ capacity + ", olist=" + olist + "]";
	}
}
