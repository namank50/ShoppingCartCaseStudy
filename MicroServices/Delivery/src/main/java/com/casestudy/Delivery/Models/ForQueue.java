package com.casestudy.Delivery.Models;

import org.springframework.stereotype.Component;

@Component
public class ForQueue {

	private String _id;
	private String Password;
	private String Role;

	public ForQueue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ForQueue(String _id, String password, String role) {
		super();
		this._id = _id;
		Password = password;
		Role = role;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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
