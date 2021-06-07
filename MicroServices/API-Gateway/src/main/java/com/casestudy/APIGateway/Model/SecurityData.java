package com.casestudy.APIGateway.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Security")
public class SecurityData {

	@Id
	private String _Id;
	private String Password;
	private String Role;

	public SecurityData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SecurityData(String _Id, String password, String role) {
		super();
		this._Id = _Id;
		Password = password;
		Role = role;
	}

	public String get_Id() {
		return _Id;
	}

	public void set_Id(String _Id) {
		this._Id = _Id;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

}
