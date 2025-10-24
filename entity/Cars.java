package com.cars.entity;

public class Cars {
	
	private int c_id;
	private String c_name;
	private String c_colour;
	private String c_model;
	private String c_type;
	private String c_no;
	private double c_price;
	
	public Cars() {
	
	}
	public Cars(int c_id, String c_name, String c_colour, String c_model, String c_type, String c_no, double c_price) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_colour = c_colour;
		this.c_model = c_model;
		this.c_type = c_type;
		this.c_no = c_no;
		this.c_price = c_price;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_colour() {
		return c_colour;
	}
	public void setC_colour(String c_colour) {
		this.c_colour = c_colour;
	}
	public String getC_model() {
		return c_model;
	}
	public void setC_model(String c_model) {
		this.c_model = c_model;
	}
	public String getC_type() {
		return c_type;
	}
	public void setC_type(String c_type) {
		this.c_type = c_type;
	}
	public String getC_no() {
		return c_no;
	}
	public void setC_no(String c_no) {
		this.c_no = c_no;
	}
	public double getC_price() {
		return c_price;
	}
	public void setC_price(double c_price) {
		this.c_price = c_price;
	}
	
	

}
