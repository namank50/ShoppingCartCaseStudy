package com.casestudy.Cart.Models;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CartForOutput {

	private String CartId;
	private String CustId;
	private List<Products> pro;
	private int CartTotal = 0;

	public CartForOutput() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartForOutput(String cartId, String custId, List<Products> pro, int total) {
		super();
		CartId = cartId;
		CustId = custId;
		this.pro = pro;
		CartTotal = total;
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

	public List<Products> getPro() {
		return pro;
	}

	public void setPro(List<Products> pro) {
		this.pro = pro;
	}

	public int getTotal() {
		return CartTotal;
	}

	public void setTotal(int total) {
		CartTotal = total;
	}

}
