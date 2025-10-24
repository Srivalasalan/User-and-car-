package com.cars.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cars.entity.Users;



public class usersDao {
	
	String url="jdbc:postgresql://localhost:5432/test";
	String user="postgres";
	String pass="root";
	private Connection con;
	
	{
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(url,user,pass);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	// Register User
	
	public void registerUser(Users u) throws SQLException {
		
		String query="Insert Into users values(?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setInt(1, u.getU_id());
		pstmt.setString(2, u.getU_name());
		pstmt.setString(3, u.getU_email());
		pstmt.setLong(4, u.getU_mobileno());
		pstmt.setString(5, u.getU_address());
		pstmt.setString(6, u.getU_password());
		
		int rows=pstmt.executeUpdate();
		System.out.println(rows>0?"User Registration Complete":"Unable to Register");
		
		
	}
	
	// User Login

	public int Login(String mail,String pass) throws SQLException {
		String query="Select * from users where u_email_id=? and u_pwd=?";
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setString(1, mail);
		pstmt.setString(2, pass);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			return rs.getInt("u_id");
		}
		else {
			return 0;
			
		}
		
		
		
		
		
	}
	
	// Forgot Password

	public String forgotPassword(String mail) throws SQLException {
		String query="SELECT u_email_id from users where u_email_id=?";
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setString(1, mail);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			return rs.getString("u_email_id");
		}
		return null;
		
		
		
		
	}
	
	// Change Password

	public void changePassword(String mail,String pass) throws SQLException {
		
		String query="Update users SET u_pwd=? where u_email_id=?";
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setString(1, pass);
		pstmt.setString(2, mail);
		int rows=pstmt.executeUpdate();
		System.out.println(rows>0?"Password Changed":" Password does not Changed");
		
		
	}
	
	// Closing the Connection
	
	public void closeConnection() throws SQLException {
		if(con==null) {
			System.out.println("Connection is Null");
		}
		else if(con.isClosed()) {
			System.out.println("Connection is Already CLosed");
		}
		else {
			System.out.println("Connection is Open. Closing Now.......");
			con.close();
			System.out.println("Connection Closed");
		}
	}

}
