package com.casestudy.Customer.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customers")
public class Customer {

	@Id
	private String _Id;
	private Name Name;
	private Long CustMobNo;
	private String CustEmail;
	private Address CustAddress;
	private String Password;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String _Id, Name aName, Long aMobileNo, String aEmail, Address aAddress, String aPassword1) {
		super();
		this._Id = _Id;
		Name = aName;
		CustMobNo = aMobileNo;
		CustEmail = aEmail;
		CustAddress = aAddress;
		Password = aPassword1;
	}

	public String get_Id() {
		return _Id;
	}

	public void set_Id(String _Id) {
		this._Id = _Id;
	}

	public Name getAName() {
		return Name;
	}

	public void setAName(Name aName) {
		Name = aName;
	}

	public Long getAMobileNo() {
		return CustMobNo;
	}

	public void setAMobileNo(Long aMobileNo) {
		CustMobNo = aMobileNo;
	}

	public String getAEmail() {
		return CustEmail;
	}

	public void setAEmail(String aEmail) {
		CustEmail = aEmail;
	}

	public Address getAAddress() {
		return CustAddress;
	}

	public void setAAddress(Address aAddress) {
		CustAddress = aAddress;
	}


	public String getAPassword1() {
		return Password;
	}

	public void setAPassword1(String aPassword1) {
		Password = aPassword1;
	}

}
