package com.casestudy.Dealer.Models;

public class Name {

	private String FName;
	private String MName;
	private String LName;

	public Name() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Name(String fName, String mName, String lName) {
		super();
		FName = fName;
		MName = mName;
		LName = lName;
	}

	public String getFName() {
		return FName;
	}

	public void setFName(String fName) {
		FName = fName;
	}

	public String getMName() {
		return MName;
	}

	public void setMName(String mName) {
		MName = mName;
	}

	public String getLName() {
		return LName;
	}

	public void setLName(String lName) {
		LName = lName;
	}
	
	

}
