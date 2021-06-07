package com.casestudy.Admin.Models;

import org.bson.BsonDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Admin")
public class Admin {

	@Id
	private String _Id;
	private Name AName;
	private Long AMobileNo;
	private String AEmail;
	private Address AAddress;
	private String APassword1;
	private String APassword2;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String _Id, Name aName, Long aMobileNo, String aEmail, Address aAddress,
			String aPassword2, String aPassword1) {
		super();
		this._Id = _Id;
		AName = aName;
		AMobileNo = aMobileNo;
		AEmail = aEmail;
		AAddress = aAddress;
		APassword2 = aPassword2;
		APassword1 = aPassword1;
	}

	public String get_Id() {
		return _Id;
	}

	public void set_Id(String _Id) {
		this._Id = _Id;
	}

	public Name getAName() {
		return AName;
	}

	public void setAName(Name aName) {
		AName = aName;
	}

	public Long getAMobileNo() {
		return AMobileNo;
	}

	public void setAMobileNo(Long aMobileNo) {
		AMobileNo = aMobileNo;
	}

	public String getAEmail() {
		return AEmail;
	}

	public void setAEmail(String aEmail) {
		AEmail = aEmail;
	}

	public Address getAAddress() {
		return AAddress;
	}

	public void setAAddress(Address aAddress) {
		AAddress = aAddress;
	}


	public String getAPassword2() {
		return APassword2;
	}

	public void setAPassword2(String aPassword2) {
		APassword2 = aPassword2;
	}

	public String getAPassword1() {
		return APassword1;
	}

	public void setAPassword1(String aPassword1) {
		APassword1 = aPassword1;
	}

}
