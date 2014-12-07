package com.expressdelivery.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.expressdelivery.model.Address;
import com.expressdelivery.model.Delivery;
import com.expressdelivery.model.Parcel;
import com.expressdelivery.model.dao.DeliveryDao;

public class DeliveryQueries implements DeliveryDao{

	private Connection connection;

	public DeliveryQueries() {

		ConnectToDB connector = new ConnectToDB();
		connection = connector.getDatabase();

	}

	public void addDelivery(Delivery delivery) {

		int isPickupNow = delivery.getParcel().isPickupNow() ? 1 : 0;

		String query = "INSERT INTO deliveries "
				+ "(addressFrom, nameFrom, phoneFrom, emailFrom, addressTo, nameTo,"
				+ "phoneTo, emailTo, size, transType, pickupNow, pickupTime, price, "
				+ "sameAddress) VALUES(" + "'"
				+ delivery.getAddressFrom().getAddress()
				+ "',"
				+ "'"
				+ delivery.getAddressFrom().getFullName()
				+ "',"
				+ "'"
				+ delivery.getAddressFrom().getPhone()
				+ "',"
				+ "'"
				+ delivery.getAddressFrom().getEmail()
				+ "',"
				+ "'"
				+ delivery.getAddressTo().getAddress()
				+ "',"
				+ "'"
				+ delivery.getAddressTo().getFullName()
				+ "',"
				+ "'"
				+ delivery.getAddressTo().getPhone()
				+ "',"
				+ "'"
				+ delivery.getAddressTo().getEmail()
				+ "',"
				+ "'"
				+ delivery.getParcel().getSize()
				+ "',"
				+ "'"
				+ delivery.getParcel().getTransType()
				+ "',"
				+ isPickupNow
				+ ","
				+ "'"
				+ delivery.getParcel().getPickupTime()
				+ "',"
				+ 20
				+ "," + 1 + ")";
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

	public ArrayList<Delivery> getAllDeliveries() {

		ArrayList<Delivery> deliveries = new ArrayList<Delivery>();
		
		String query = "SELECT * FROM deliveries";
				
		PreparedStatement pst;
		ResultSet result;

		try {
			pst = connection.prepareStatement(query);

			result = pst.executeQuery();
			
			while (result.next()) {
	            
				
				Address addressFrom = new Address();
				Address addressTo = new Address();
				Delivery delivery = new Delivery();
				
				addressFrom.setAddress(result.getString("addressFrom"));
				addressFrom.setFullName(result.getString("nameFrom"));
				addressFrom.setEmail(result.getString("emailFrom"));
				addressFrom.setPhone(result.getString("phoneFrom"));
				
				addressTo.setAddress(result.getString("addressTo"));
				addressTo.setFullName(result.getString("nameTo"));
				addressTo.setEmail(result.getString("emailTo"));
				addressTo.setPhone(result.getString("phoneTo"));
				
				delivery.setAddressFrom(addressFrom);
				delivery.setAddressTo(addressTo);
				
				
				Parcel parcel = new Parcel();
				parcel.setPrice(result.getFloat("price"));
				parcel.setPickupTime(result.getString("pickupTime"));
				parcel.setSize(result.getString("size"));
				parcel.setTransType(result.getString("transType"));
				
				delivery.setParcel(parcel);
				delivery.setDatabaseId(result.getInt("id"));
				
				deliveries.add(delivery);
				
				
				//System.out.println(result.getString("addressTo") + " " + result.getString("addressTo"));
				
	        }

		} catch (SQLException e) {
			e.printStackTrace();

		}

		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return deliveries;

	}
	
	public void deleteDelivery(int id) {
		
		ArrayList<Delivery> deliveries = new ArrayList<Delivery>();
		
		String query = "DELETE FROM deliveries WHERE id = " + id;
				
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
	
public static void main(String[] argv) {
		
		DeliveryQueries queries = new DeliveryQueries();
		
		System.out.println(queries.getAllDeliveries().size());
		queries = new DeliveryQueries();
		queries.deleteDelivery(1);
		queries = new DeliveryQueries();
		System.out.println(queries.getAllDeliveries().size());
	}

}
