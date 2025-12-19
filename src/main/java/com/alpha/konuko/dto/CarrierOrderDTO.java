package com.alpha.konuko.dto;

import com.alpha.konuko.entity.Address;

public class CarrierOrderDTO {
	
	private int orderid;
	private String custname;
	private long custmobno;
	private Address pickuploc;
	private Address deliveryloc;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public long getCustmobno() {
		return custmobno;
	}
	public void setCustmobno(long custmobno) {
		this.custmobno = custmobno;
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
	public CarrierOrderDTO(int orderid, String custname, long custmobno, Address pickuploc, Address deliveryloc) {
		super();
		this.orderid = orderid;
		this.custname = custname;
		this.custmobno = custmobno;
		this.pickuploc = pickuploc;
		this.deliveryloc = deliveryloc;
	}
	public CarrierOrderDTO() {
		super();
	}
	@Override
	public String toString() {
		return "CarrierOrderDTO [orderid=" + orderid + ", custname=" + custname + ", custmobno=" + custmobno
				+ ", pickuploc=" + pickuploc + ", deliveryloc=" + deliveryloc + "]";
	}
}
