package com.cars.entity;

public class Users {
	
	private int u_id;
	private String u_name;
	private String u_email;
	private long u_mobileno;
	private String u_address;
	private String u_password;
	
	public Users() {
		
	}
	public Users(int u_id, String u_name, String u_email, long u_mobileno, String u_address, String u_password) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_email = u_email;
		this.u_mobileno = u_mobileno;
		this.u_address = u_address;
		this.u_password = u_password;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public long getU_mobileno() {
		return u_mobileno;
	}
	public void setU_mobileno(long u_mobileno) {
		this.u_mobileno = u_mobileno;
	}
	public String getU_address() {
		return u_address;
	}
	public void setU_address(String u_address) {
		this.u_address = u_address;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	
	
	

}
