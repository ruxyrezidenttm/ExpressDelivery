package com.expressdelivery.model.bean;

import java.io.Serializable;

public class Address implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String address;
	private String fullName;
	private String phone;
	private String email;

	public Address() {

	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
