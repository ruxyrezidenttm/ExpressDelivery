package com.expressdelivery;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;

public class AdminQueries {
	
	private Connection connection;
	
	public AdminQueries(Connection connection) {
		this.connection = connection;
	}
	
	public boolean checkLoginCred(String username, String password) {
		
		
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
		
		return check;
		
	}
	
	public static void main(String[] argv) {
		
		ConnectToDB connector = new ConnectToDB();
		Connection database = connector.getDatabase();
		
		AdminQueries queries = new AdminQueries(database);
		System.out.println(queries.checkLoginCred("lisa.kent", "passoForLisa"));
	}

}
