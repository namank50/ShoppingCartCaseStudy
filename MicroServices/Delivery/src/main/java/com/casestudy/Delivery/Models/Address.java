package com.casestudy.Delivery.Models;

public class Address {
	
	private String Street;
	private String City;
	private String State;
	private int Pincode;
	
	
	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String street, String city, String state, int pincode) {
		super();
		Street = street;
		City = city;
		State = state;
		Pincode = pincode;
	}
	
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public int getPincode() {
		return Pincode;
	}
	public void setPincode(int pincode) {
		Pincode = pincode;
	}
	
	

}
