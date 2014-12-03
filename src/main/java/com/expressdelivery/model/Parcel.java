package com.expressdelivery.model;

public class Parcel {

	private String size;
	private String transType;
	private float price;
	private String pickupTime;
	private boolean pickupNow;

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

	public void setTransType(String transportation) {
		this.transType = transportation;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
