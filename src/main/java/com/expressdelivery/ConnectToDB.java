/*Source: http://www.mkyong.com/jdbc/how-to-connect-to-mysql-with-jdbc-driver-java/
 * 		  http://jdbc.postgresql.org/documentation/93/query.html
 */

package com.expressdelivery;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectToDB {

	private static Connection connection;
	private final String host = "eu-cdbr-azure-west-b.cloudapp.net";
	private final String database = "ruxyrezAUp9fMtIc";
	private final String user = "b685f5a6772d84";
	private final String password = "5b7366c6";

	private void connect() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}

		connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://" + host
					+ "/" + database, user, password);

		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
	}

	public Connection getDatabase() {

		if (connection == null)
			connect();
		return connection;
	}
	
	/* Testing the connection */

	public static void main(String[] argv) {

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}

		String query = "SELECT * FROM registration_tbl";
		PreparedStatement pst;
		ResultSet result = null;

		try {
			pst = connection.prepareStatement(query);

			result = pst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();

		}

		try {

			while (result.next()) {

				System.out.println(result.getString(1) + " "
						+ result.getString(2));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		/*
		 * result.close(); pst.close();
		 */

	}
}