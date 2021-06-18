package com.casestudy.Cart.Service;

import org.springframework.stereotype.Service;

import com.casestudy.Cart.Models.CartForInput;
import com.casestudy.Cart.Models.CartForOutput;

@Service
public interface CartService {

	public String CreateCart(String CustId);
	public String deleteCart(String CustId);
	public CartForOutput getCart(String custId);
	public String addAproductToExistingCart(CartForInput customer);
	public String addRemoveToExistingCart(CartForInput customer);
	
}
