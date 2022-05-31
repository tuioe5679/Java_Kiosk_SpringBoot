package com.example.demo.model;

public class KioskOrders {
	
	private String ordernum;
	private String name;
	private String price;
	private String count;
	
	public KioskOrders(String ordernum, String name, String price, String count) {
		super();
		this.ordernum = ordernum;
		this.name = name;
		this.price = price;
		this.count = count;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
	
	
	

}
