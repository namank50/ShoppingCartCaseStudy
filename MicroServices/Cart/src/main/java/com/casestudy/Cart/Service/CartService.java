package com.casestudy.Cart.Service;

import org.springframework.stereotype.Service;

@Service
public interface CartService {

	public String CreateCart(String CustId);
	public String deleteCart(String CustId);
	
}
