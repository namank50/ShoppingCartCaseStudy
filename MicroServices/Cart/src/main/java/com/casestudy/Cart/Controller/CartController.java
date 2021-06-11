package com.casestudy.Cart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.Cart.Models.CartForInput;
import com.casestudy.Cart.Models.CartForOutput;
import com.casestudy.Cart.Service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartService cart;
	

	@GetMapping("/getCart/{CustId}")
	public CartForOutput cartget(@PathVariable("CustId") String CustId) {
		return cart.getCart(CustId);
	}
	
	@PostMapping("/addproduct")
	public String addAproduct(@RequestBody CartForInput customer) {
		return cart.addAproductToExistingCart(customer);
		
	}
	
	
	@GetMapping("/add/{CustId}")
	public String cartAdd(@PathVariable("CustId") String CustId) {
		return cart.CreateCart(CustId);
	}
	
	@GetMapping("/delete/{CustId}")
	public String deleteCart(@PathVariable("CustId")String CustId) {
		return cart.deleteCart(CustId);
	}

}
