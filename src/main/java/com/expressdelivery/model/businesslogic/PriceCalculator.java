package com.expressdelivery.model.businesslogic;

import com.expressdelivery.model.bean.Delivery;

public class PriceCalculator {

	public static float price(Delivery delivery) {

		float price = 6353;
		
		if (delivery.getParcel().getTransType().equals("bicycle")) {

			switch (delivery.getParcel().getSize()) {

			case "paper":				
				price = 5;
				break;

			case "smallbox":
				price = 10;
				break;

			case "mediumbox":
				price = 15;
				break;

			case "bigbox":
				price = 20;
				break;

			}
		}

		else if(delivery.getParcel().getTransType().equals("van")){

			switch (delivery.getParcel().getSize()) {

			case "paper":
				price = 8;
				break;

			case "smallbox":	
				price = 13;
				break;

			case "mediumbox":
				price = 18;
				break;

			case "bigbox":
				price = 23;
				break;

			}
		}
		
		return price;

	}
}
