package com.expressdelivery.model;


public class Delivery {

	private Address addressTo;
	private Address addressFrom;
	private Address addressBilling;
	private int databaseId;
	
	public Address getAddressBilling() {
		return addressBilling;
	}

	public void setAddressBilling(Address addressBilling) {
		this.addressBilling = addressBilling;
	}

	private Parcel parcel;

	public Address getAddressTo() {
		return addressTo;
	}

	public void setAddressTo(Address addressTo) {
		this.addressTo = addressTo;
	}

	public Address getAddressFrom() {
		return addressFrom;
	}

	public void setAddressFrom(Address addressFrom) {
		this.addressFrom = addressFrom;
	}

	public Parcel getParcel() {
		return parcel;
	}

	public void setParcel(Parcel parcel) {
		this.parcel = parcel;
	}

	public int getDatabaseId() {
		return databaseId;
	}

	public void setDatabaseId(int databaseId) {
		this.databaseId = databaseId;
	}
	
	

}
