package com.casestudy.Cart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.Cart.Models.CartForInput;
import com.casestudy.Cart.Models.CartForOutput;
import com.casestudy.Cart.Service.CartService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:4200")

public class CartController {
	
	@Autowired
	CartService cart;
	

	@GetMapping("/getCart/{CustId}")
	@ApiOperation(value = "It Show the cart of a particular customer",notes="to view the cart of an existing customer")
	public CartForOutput cartget(@PathVariable("CustId") String CustId) {
		return cart.getCart(CustId);
	}
	
	@PostMapping("/addproduct")
	@ApiOperation(value = "To add product to a cart",notes="to add new product to a cart")
	public String addAproduct(@RequestBody CartForInput customer) {
		return cart.addAproductToExistingCart(customer);
		
	}
	
	@PostMapping("/removeproduct")
	@ApiOperation(value = "To remove some product from cart",notes="to remove product #update cart")
	public String removeAproduct(@RequestBody CartForInput customer) {
		return cart.addRemoveToExistingCart(customer);
		
	}
	
	
	@GetMapping("/add/{CustId}")
	@ApiOperation(value = "To create a cart",notes="called by customer microservice(when new customer is added) automatically creates a cart when a user is registered")
	public String cartAdd(@PathVariable("CustId") String CustId) {
		return cart.CreateCart(CustId);
	}
	
	@GetMapping("/delete/{CustId}")
	@ApiOperation(value = "To delete a cart",notes="called by customer microservice(when a customer is deleted) automatically deletes the cart when a customer is deleted")

	
	public String deleteCart(@PathVariable("CustId")String CustId) {
		return cart.deleteCart(CustId);
	}

}
