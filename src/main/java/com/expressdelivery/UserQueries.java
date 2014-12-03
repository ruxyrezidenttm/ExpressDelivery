package com.expressdelivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserQueries {
	
	private Connection connection;

	public UserQueries() {
		
		ConnectToDB connector = new ConnectToDB();
		connection = connector.getDatabase();
		
		
	}
	
	public void addDelivery(Delivery delivery) {
		
		int isPickupNow = delivery.getParcel().isPickupNow() ? 1 : 0;
		
		String query = "INSERT INTO deliveries " +
				"(addressFrom, nameFrom, phoneFrom, emailFrom, addressTo, nameTo,"
				+ "phoneTo, emailTo, size, transType, pickupNow, pickupTime, price, "
				+ "sameAddress) VALUES("
				+ "'" + delivery.getAddressFrom().getAddress() + "',"
				+ "'" + delivery.getAddressFrom().getFullName() + "',"
				+ "'" + delivery.getAddressFrom().getPhone() + "',"
				+ "'" + delivery.getAddressFrom().getEmail() + "',"
				+ "'" + delivery.getAddressTo().getAddress() + "',"
				+ "'" + delivery.getAddressTo().getFullName() + "',"
				+ "'" + delivery.getAddressTo().getPhone() + "',"
				+ "'" + delivery.getAddressTo().getEmail() + "',"
				+ "'" + delivery.getParcel().getSize() + "',"
				+ "'" + delivery.getParcel().getTransType() + "',"
				+ isPickupNow + ","
				+ "'" + delivery.getParcel().getPickupTime()+ "',"
				+ 20 + ","
				+ 1 + ")";
		PreparedStatement pst;
		int result;
		
		try {
			pst = connection.prepareStatement(query);

			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
