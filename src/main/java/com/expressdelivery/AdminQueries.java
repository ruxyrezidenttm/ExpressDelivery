package com.expressdelivery;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;

public class AdminQueries {
	
	private Connection connection;
	private ConnectToDB connector;
	
	public AdminQueries() {
		connector = new ConnectToDB();
		
	}
	
	public boolean checkLoginCred(String username, String password) {
		
		connection = connector.getDatabase();
		String query = "SELECT password FROM admins WHERE username = '" + username + "'";
		PreparedStatement pst;
		ResultSet result = null;
		
		try {
			pst = connection.prepareStatement(query);

			result = pst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		boolean check = false;
		
		try {

			if(result.next()) {

				//System.out.println(result.getString(1));
				check = result.getString(1).equals(password);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		catch(NullPointerException e){
			
		}
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return check;
		
	}
	
	public static void main(String[] argv) {
		
		AdminQueries queries = new AdminQueries();
		System.out.println(queries.checkLoginCred("lisa.kent", "passoForLisa"));
	}

}
