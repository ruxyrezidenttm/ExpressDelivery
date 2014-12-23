package com.expressdelivery.model.bean;

import java.io.Serializable;

public class Parcel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String size;
	private String transType;
	private float price;
	private String pickupTime;
	private boolean pickupNow;
	
	public Parcel() {
		
	}

	public String getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
	}

	public boolean isPickupNow() {
		return pickupNow;
	}

	public void setPickupNow(boolean pickupNow) {
		this.pickupNow = pickupNow;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
