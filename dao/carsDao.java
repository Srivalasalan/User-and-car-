package com.cars.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.cars.entity.Cars;

public class carsDao {

	String url = "jdbc:postgresql://localhost:5432/test";
	String user = "postgres";
	String pass = "root";
	private Connection con;

	{
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

	public void addCarDetails(Cars c) throws SQLException {
		String query = "Insert Into cars values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, c.getC_id());
		pstmt.setString(2, c.getC_name());
		pstmt.setString(3, c.getC_colour());
		pstmt.setString(4, c.getC_model());
		pstmt.setString(5, c.getC_type());
		pstmt.setString(6, c.getC_no());
		pstmt.setDouble(7, c.getC_price());
		int rows = pstmt.executeUpdate();
		System.out.println(rows > 0 ? rows + " cars Updated" : "No rows Updated");
	}

	public void updateCarByName(String name, int id) throws SQLException {
		String query = "Update cars SET c_name=? where c_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, name);
		pstmt.setInt(2, id);
		int rows = pstmt.executeUpdate();
		System.out.println(rows > 0 ? "Car Name Updated" : "Not Updated");

	}

	public void updateCarByColour(String colour, int id) throws SQLException {
		String query = "Update cars SET c_colour=? where c_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, colour);
		pstmt.setInt(2, id);
		int rows = pstmt.executeUpdate();
		System.out.println(rows > 0 ? "Car Colour Updated" : "Not Updated");

	}

	public void updateCarByModel(String model, int id) throws SQLException {
		String query = "Update cars SET c_model=? where c_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, model);
		pstmt.setInt(2, id);
		int rows = pstmt.executeUpdate();
		System.out.println(rows > 0 ? "Car Model Updated" : "Not Updated");
		
	}

	public void updateCarByType(String type, int id) throws SQLException {
		String query = "Update cars SET c_type=? where c_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, type);
		pstmt.setInt(2, id);
		int rows = pstmt.executeUpdate();
		System.out.println(rows > 0 ? "Car Type Updated" : "Not Updated");
		
		
	}

	public void updateCarByNumber(String num, int id) throws SQLException {
		String query = "Update cars SET c_no=? where c_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, num);
		pstmt.setInt(2, id);
		int rows = pstmt.executeUpdate();
		System.out.println(rows > 0 ? "Car Number Updated" : "Not Updated");
		
	}

	public void updateCarByPrice(double price, int id) throws SQLException {
		String query = "Update cars SET c_price=? where c_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setDouble(1, price);
		pstmt.setInt(2, id);
		int rows = pstmt.executeUpdate();
		System.out.println(rows > 0 ? "Car Price Updated" : "Not Updated");
		
	}

	public void fetchCars(Cars c) throws SQLException {
		String query="SELECT * FROM cars";
		Statement st =con.createStatement();
		ResultSet rs =st.executeQuery(query);
		System.out.printf("%-6s %-20s %-10s %-20s %-15s %-15s %-12s%n", 
			    "C_ID", "C_NAME", "C_COLOUR", "C_MODEL", "C_TYPE", "C_NO", "C_PRICE");
			System.out.println("-------------------------------------------------------------------------------------------------------");

			while(rs.next()) {
			    System.out.printf("%-6d %-20s %-10s %-20s %-15s %-15s %-12.2f%n",
			        rs.getInt("c_id"),
			        rs.getString("c_name"),
			        rs.getString("c_colour"),
			        rs.getString("c_model"),
			        rs.getString("c_type"),
			        rs.getString("c_no"),
			        rs.getDouble("c_price"));
			}

		
	}

	public void fetchCarByName(String name) throws SQLException {
		String query="SELECT * FROM cars where c_name=?";
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();
		System.out.printf("%-6s %-20s %-10s %-20s %-15s %-15s %-12s%n", 
			    "C_ID", "C_NAME", "C_COLOUR", "C_MODEL", "C_TYPE", "C_NO", "C_PRICE");
			System.out.println("-------------------------------------------------------------------------------------------------------");

			if(rs.next()) {
			    System.out.printf("%-6d %-20s %-10s %-20s %-15s %-15s %-12.2f%n",
			        rs.getInt("c_id"),
			        rs.getString("c_name"),
			        rs.getString("c_colour"),
			        rs.getString("c_model"),
			        rs.getString("c_type"),
			        rs.getString("c_no"),
			        rs.getDouble("c_price"));
			}
			else {
				System.out.println("No Data Found");
			}

		
		
	}

	public void deleteCar(String name, int id) throws SQLException {
		String query="DELETE FROM cars WHERE c_name=? and c_id=?";
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setString(1, name);
		pstmt.setInt(2, id);
		int rows =pstmt.executeUpdate();
		System.out.println(rows>0?rows+" cars Deleted":"Not Deleted");
		
		
	}

	public void countCarByColour(String colour) throws SQLException {
		String query="call \"countCarByColour\"(?,?)";
		CallableStatement cstmt=con.prepareCall(query);
		cstmt.setString(1, colour);
		cstmt.registerOutParameter(2, Types.INTEGER);
		cstmt.execute();
		int count=cstmt.getInt(2);
		System.out.println("No. Of Cars With "+colour+" Colour is: "+count);
		
	}
	
	// Closing the Connection
	
		public boolean closeConnection() throws SQLException {
			if(con==null) {
				System.out.println("Connection is Null");
				return false;
			}
			else if(con.isClosed()) {
				System.out.println("Connection is Already CLosed");
				return false;
			}
			else {
				System.out.println("Connection is Open. Closing Now.......");
				con.close();
				System.out.println("Connection Closed");
				return true;
			}
		}
	
//	public boolean closeConnection() throws SQLException {
//		con.close();
//		return true;
//	}
	

	
	

}
