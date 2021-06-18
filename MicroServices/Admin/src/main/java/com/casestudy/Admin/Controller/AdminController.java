package com.casestudy.Admin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.Admin.Models.Customer;
import com.casestudy.Admin.Models.Dealer;
import com.casestudy.Admin.Models.Delivery;
import com.casestudy.Admin.Models.Orders;
import com.casestudy.Admin.Models.Products;
import com.casestudy.Admin.Service.AdminService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/getCustomers")
	@ApiOperation(value = "To Show all the Customers to admin",notes="to view all the customers in admin frontend portal")
	public List<Customer> getAllCustomers() {
		return adminService.getAllCustomerDetails();
	}
	
	@GetMapping("/getDealer")
	@ApiOperation(value = "To Show all the Dealers to admin",notes="to view all the dealers in admin frontend portal")
	public List<Dealer> getAllDealer() {
		return adminService.getAllDealerDetails();
	}
	
	@GetMapping("/getDelivery")
	@ApiOperation(value = "To Show all the Delivery to admin",notes="to view all the dealivery in admin frontend portal")
	public List<Delivery> getAllDelivery() {
		return adminService.getAllDeliveryDetails();
	}
	
	@GetMapping("/getProducts")
	@ApiOperation(value = "To Show all the Products to admin",notes="to view all the products in admin frontend portal")
	public List<Products> getAllProducts() {
		return adminService.getAllProductsDetails();
	}
	
	@GetMapping("/getOrders")
	@ApiOperation(value = "To Show all the Orders to admin",notes="to view all the orders in admin frontend portal")
	public List<Orders> getAllOrders() {
		return adminService.getAllOrderDetails();
	}

}
