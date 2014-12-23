package com.expressdelivery.model.businesslogic;

import com.expressdelivery.model.bean.Delivery;

public interface TrackingService {
	
	void addTrack(Delivery delivery);
	void updateTrack(int deliveryId);
	void removeTrack(int deliveryId);

}
