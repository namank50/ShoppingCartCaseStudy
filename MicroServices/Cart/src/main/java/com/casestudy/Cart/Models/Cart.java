package com.casestudy.Cart.Models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "Cart")
public class Cart {

	private String _id;
	private String CustId;
	private List<String> ProductId;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(String _id, String custId, List<String> productId) {
		super();
		this._id = _id;
		CustId = custId;
		ProductId = productId;
	}

	public String get_Id() {
		
		return _id;
	}

	public void set_Id(String _Id) {
		this._id = _Id;
	}

	public String getCustId() {
		return CustId;
	}

	public void setCustId(String custId) {
		CustId = custId;
	}

	public List<String> getProductId() {
		return ProductId;
	}

	public void setProductId(List<String> productId) {
		ProductId = productId;
	}

}
