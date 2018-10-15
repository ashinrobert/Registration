package com.nissan.training.advancedjava.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationServices {

	private String url = "jdbc:mysql://localhost:3306/";
	private String db = "users";
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String user = "root";
	private String pass = "Kerala18";
	Connection con;

	/* Getters for fields */
	public String getUrl() {
		return url;
	}

	public String getDb() {
		return db;
	}

	public String getDriver() {
		return driver;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public Connection getCon() {
		return con;
	}

	/* Creating connection object */
	Connection connect() {
		if (con != null) { // if connection is already set
			return con;
		} else {
			try {
				Class.forName(getDriver());
				con = DriverManager.getConnection(getUrl() + getDb(), getUser(), getPass());
				if (con == null) {
					System.out.println("Connection cannot be established");
				}
			} catch (Exception e) {
				System.out.println("Connection Error");
			}
			return con;
		}
	}

	public boolean insertUser(String fname, String lname, String email, String mobile) {
		try {
			con = connect();
			String query = "insert into user values (?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, fname);
			stmt.setString(2, lname);
			stmt.setString(3, email);
			stmt.setString(4, mobile);
			stmt.executeUpdate();
		} catch (SQLException e) {
			return false;
		}
		return true;

	}

}
