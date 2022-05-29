package com.example.demo.model;

public class KioskMembers {
	
	private String id;
	private String pwd;
	private String name;
	private String totalmoney;
	
	public KioskMembers(String id, String pwd, String name, String totalmoney) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.totalmoney = totalmoney;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(String totalmoney) {
		this.totalmoney = totalmoney;
	}

	

}
