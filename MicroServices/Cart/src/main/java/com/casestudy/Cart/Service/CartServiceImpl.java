package com.casestudy.Cart.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.casestudy.Cart.DAO.CartDatabase;
import com.casestudy.Cart.Models.Cart;
import com.casestudy.Cart.Models.CartForInput;
import com.casestudy.Cart.Models.CartForOutput;
import com.casestudy.Cart.Models.Products;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	Cart cart;
	@Autowired
	CartDatabase cartDatabase;
	@Autowired
	CartForOutput cartForOutput;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	
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

	@Override
	public CartForOutput getCart(String custId) {
		String _Id="CID"+custId.split("_")[1];
		List<Products> pro=new ArrayList<>();
		int sum=0;
		Optional<Cart> cart=cartDatabase.findById(_Id);
		cartForOutput.setCartId(cart.get().get_Id());
		cartForOutput.setCustId(cart.get().getCustId());
		for(String s:cart.get().getProductId()) {
			Products p = restTemplate.getForObject("http://localhost:8085/product/getone/"+s, Products.class);
			sum=sum+p.getPrice();
			pro.add(p);
		}
		cartForOutput.setTotal(sum);
		cartForOutput.setPro(pro);
		return cartForOutput;
	}

	@Override
	public String addAproductToExistingCart(CartForInput customer) {
		Optional<Cart> cart1=cartDatabase.findById(customer.getCartId());
		cart1.get().getProductId().add(customer.getProductId());
		cartDatabase.save(cart1);
		return "Success";
	}
}
