package com.casestudy.Cart.Models;

import org.springframework.stereotype.Component;

@Component
public class CartForInput {
	
	String CartId;
	String CustId;
	String ProductId;
	public CartForInput() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartForInput(String cartId, String custId, String productId) {
		super();
		CartId = cartId;
		CustId = custId;
		ProductId = productId;
	}
	public String getCartId() {
		return CartId;
	}
	public void setCartId(String cartId) {
		CartId = cartId;
	}
	public String getCustId() {
		return CustId;
	}
	public void setCustId(String custId) {
		CustId = custId;
	}
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	
	

}
