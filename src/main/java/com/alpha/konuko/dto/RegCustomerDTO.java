package com.alpha.konuko.dto;

public class RegCustomerDTO {
	
	private String name;
	private long mobileno;
	private String mail;
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
	public RegCustomerDTO(String name, long mobileno, String mail) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.mail = mail;
	}
	public RegCustomerDTO() {
		super();
	}
	@Override
	public String toString() {
		return "RegCustomerDTO [name=" + name + ", mobileno=" + mobileno + ", mail=" + mail + "]";
	}
}
