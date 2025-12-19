package com.alpha.konuko.dto;

public class AddressDTO {
	
	private String city;
	private int pincode;
	private String state;
	private String country;
	private String addressdescription;
	private long mobileno;
	private String addresstype;
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
	public AddressDTO(String city, int pincode, String state, String country, String addressdescription, long mobileno,
			String addresstype) {
		super();
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
		this.addressdescription = addressdescription;
		this.mobileno = mobileno;
		this.addresstype = addresstype;
	}
	public AddressDTO() {
		super();
	}
	@Override
	public String toString() {
		return "AddressDTO [city=" + city + ", pincode=" + pincode + ", state=" + state + ", country=" + country
				+ ", addressdescription=" + addressdescription + ", mobileno=" + mobileno + ", addresstype="
				+ addresstype + "]";
	}
}
