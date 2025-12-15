package com.alpha.konuko.dto;

public class CarrierDTO {
	
	private String name;
	private long mobileno;
	private String mailid;
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
	public CarrierDTO(String name, long mobileno, String mailid) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.mailid = mailid;
	}
	public CarrierDTO() {
		super();
	}
	@Override
	public String toString() {
		return "CarrierDTO [name=" + name + ", mobileno=" + mobileno + ", mailid=" + mailid + "]";
	}
}
