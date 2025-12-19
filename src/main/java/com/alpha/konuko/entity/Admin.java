package com.alpha.konuko.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private long mobileno;
	private String mail;
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Address> alist = new ArrayList<>();
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
	public Admin(int id, String name, long mobileno, String mail, List<Address> alist) {
		super();
		this.id = id;
		this.name = name;
		this.mobileno = mobileno;
		this.mail = mail;
		this.alist = alist;
	}
	public Admin() {
		super();
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", mobileno=" + mobileno + ", mail=" + mail + ", alist=" + alist
				+ "]";
	}
}
