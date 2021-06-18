package com.casestudy.Admin.Models;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.Document;

@Configuration
@Document(collection = "Orders")
public class Orders {

	private String _id;
	private List<String> PID;
	private String CUSTID;
	private String DEAID;
	private String DID;
	private String Status;
	private int Total;
	private boolean PaymentStatus;
	private String Date;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Orders(String _id, List<String> pID, String cUSTID, String dEAID, String dID, String status, int total,
			boolean paymentStatus, String date) {
		super();
		this._id = _id;
		PID = pID;
		CUSTID = cUSTID;
		DEAID = dEAID;
		DID = dID;
		Status = status;
		Total = total;
		PaymentStatus = paymentStatus;
		Date = date;
	}



	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public List<String> getPID() {
		return PID;
	}

	public void setPID(List<String> pID) {
		PID = pID;
	}

	public String getCUSTID() {
		return CUSTID;
	}

	public void setCUSTID(String cUSTID) {
		CUSTID = cUSTID;
	}

	public String getDEAID() {
		return DEAID;
	}

	public void setDEAID(String dEAID) {
		DEAID = dEAID;
	}

	public String getDID() {
		return DID;
	}

	public void setDID(String dID) {
		DID = dID;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public int getTotal() {
		return Total;
	}

	public void setTotal(int total) {
		Total = total;
	}

	public boolean isPaymentStatus() {
		return PaymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		PaymentStatus = paymentStatus;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	
	

}
