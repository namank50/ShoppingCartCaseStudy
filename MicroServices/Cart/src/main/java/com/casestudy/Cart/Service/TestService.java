package com.casestudy.Cart.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.Cart.DAO.CartDatabase;
import com.casestudy.Cart.Models.Cart;

@Service
public class TestService {
	@Autowired
	CartDatabase cartDataBase;
	
	public List<Cart> getAllData(){
		return cartDataBase.findAll();
	}
}
