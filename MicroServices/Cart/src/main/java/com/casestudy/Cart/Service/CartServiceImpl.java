package com.casestudy.Cart.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.Cart.DAO.CartDatabase;
import com.casestudy.Cart.Models.Cart;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	Cart cart;
	@Autowired
	CartDatabase cartDatabase;
	
	@Override
	public String CreateCart(String CustId) {
		 cart.set_Id("CID"+CustId.split("_")[1]);
		 cart.setCustId(CustId);
		 cart.setProductId(null);
		 cartDatabase.save(cart);
		 return "success";
	}

	public String deleteCart(String CustId) {
		 String _Id="CID"+CustId.split("_")[1];
		 cartDatabase.deleteById(_Id);
		 return "success";
	}
}
