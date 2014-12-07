package com.expressdelivery.model.dao;

import java.util.ArrayList;

import com.expressdelivery.model.Delivery;

public interface DeliveryDao {
	
	public ArrayList<Delivery> getAllDeliveries();
	public void addDelivery(Delivery delivery);
	public void deleteDelivery(int id);

}
