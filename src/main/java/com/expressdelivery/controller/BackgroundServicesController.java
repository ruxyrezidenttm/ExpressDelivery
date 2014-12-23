package com.expressdelivery.controller;

import com.expressdelivery.model.businesslogic.SendEmail;
import com.expressdelivery.model.businesslogic.SendEmailService;
import com.expressdelivery.model.businesslogic.Tracking;
import com.expressdelivery.model.businesslogic.TrackingService;

public class BackgroundServicesController {

	private static TrackingService tracking;
	private static SendEmailService email;

	public static void startTracking() {
		tracking = new Tracking();

	}

	public static TrackingService getTracking() {

		return tracking;
	}

	public static void startSendEmail() {
		email = new SendEmail();

	}

	public static SendEmailService getSendEmail() {

		return email;

	}

}
