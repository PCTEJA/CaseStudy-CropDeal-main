package com.example.models;

public class Location {
	
	private String street;
	private String village;
	private String city;
	private String state;
	private int pincode;
	
	
	public Location() {
		
	}

	public Location(String street, String village, String city, String state, int pincode) {
		super();
		this.street = street;
		this.village = village;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Location [street=" + street + ", village=" + village + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + "]";
	}
	
	
	
	

}
