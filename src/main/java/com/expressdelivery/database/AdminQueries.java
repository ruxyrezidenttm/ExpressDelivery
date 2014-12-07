package com.expressdelivery.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import com.expressdelivery.model.Admin;
import com.expressdelivery.model.dao.AdminDao;

public class AdminQueries implements AdminDao{
	
	private Connection connection;
	private ConnectToDB connector;
	
	public AdminQueries() {
		connector = new ConnectToDB();
		
	}
	
	public Admin getAdmin(String username) {
		
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
		
		String password = null;
		String email = null;
		
		try {

			if(result.next()) {

				password = result.getString("password");
				//email = result.getString("email");
				
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
		
		Admin admin = new Admin();
		
		admin.setUsername(username);
		admin.setPassword(password);
		admin.setEmail(email);
		
		return admin;
		
		
	}
	
	public static void main(String[] argv) {
		
		AdminQueries queries = new AdminQueries();
		System.out.println(queries.getAdmin("lisa.kent").getPassword().equals("passForLisa"));
	}

}
