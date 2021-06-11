package com.casestudy.Customer.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.Customer.Models.Customer;
import com.casestudy.Customer.Models.CustomerForAdmin;
import com.casestudy.Customer.Models.CustomerForOrder;
import com.casestudy.Customer.SErvice.CustomerServiceImpl;
import com.casestudy.Customer.SErvice.GenerateCustomerId;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerService;

	@GetMapping("/getall")
	public List<Customer> allDealers() {
		return customerService.getAllCustomers();

	}

	@GetMapping("/getone/{_id}")
	public Optional<Customer> oneCustomer(@PathVariable("_id") String _id) {
		return customerService.getOneCustomer(_id);

	}

	@PostMapping("/add")
	public String addDealer(@RequestBody Customer newDealer) {
		newDealer.set_id(GenerateCustomerId.Total());
		return customerService.addNewCustomer(newDealer);
	}

	@PutMapping("/update")
	public String updateCustomer(@RequestBody Customer updateDealer) {
		return customerService.updateCustomer(updateDealer);
	}

	@DeleteMapping("/delete/{_id}")
	public String deleteCustomer(@PathVariable("_id") String _Id) {
		return customerService.deleteCustomer(_Id);
	}


	@GetMapping("/getdealerDetails/{_id}") // to be called by order micro-service
	public CustomerForOrder oneCustomerDetails(@PathVariable("_id") String _Id) {
		return customerService.forOrderMicroservice(_Id);
	}
	
	@GetMapping("/foradmin")
	public CustomerForAdmin forAdminCustomer() {
		return customerService.forAdminService();// for admin microservice wrapped data

	}


}
