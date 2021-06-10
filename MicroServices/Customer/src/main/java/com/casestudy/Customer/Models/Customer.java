package com.casestudy.Customer.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "Customers")
public class Customer {

	@Id
	private String _id;
	private Name Name;
	private Long CustMobNo;
	private String CustEmail;
	private Address CustAddress;
	private String Password;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Customer(String _id, com.casestudy.Customer.Models.Name name, Long custMobNo, String custEmail,
			Address custAddress, String password) {
		super();
		this._id = _id;
		Name = name;
		CustMobNo = custMobNo;
		CustEmail = custEmail;
		CustAddress = custAddress;
		Password = password;
	}


	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public Name getName() {
		return Name;
	}
	public void setName(Name name) {
		Name = name;
	}
	public Long getCustMobNo() {
		return CustMobNo;
	}
	public void setCustMobNo(Long custMobNo) {
		CustMobNo = custMobNo;
	}
	public String getCustEmail() {
		return CustEmail;
	}
	public void setCustEmail(String custEmail) {
		CustEmail = custEmail;
	}
	public Address getCustAddress() {
		return CustAddress;
	}
	public void setCustAddress(Address custAddress) {
		CustAddress = custAddress;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

	



}
