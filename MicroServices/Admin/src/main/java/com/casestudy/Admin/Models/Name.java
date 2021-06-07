package com.casestudy.Admin.Models;

public class Name {

	private String FName;
	private String LName;
	
	
	
	public Name() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Name(String fName, String lName) {
		super();
		FName = fName;
		LName = lName;
	}



	public String getFName() {
		return FName;
	}



	public void setFName(String fName) {
		FName = fName;
	}



	public String getLName() {
		return LName;
	}



	public void setLName(String lName) {
		LName = lName;
	}

	
	
	
}
