package com.expressdelivery.model.businesslogic;

import com.expressdelivery.model.bean.Delivery;

public class SendEmail implements SendEmailService{

	@Override
	public void sendEmail(Delivery delivery) {
		// TODO Auto-generated method stub
		GenerateBill.generateBill(delivery);
		
	}

}
