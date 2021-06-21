package com.casestudy.Customer.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerService;

	@GetMapping("/getall")
	@ApiOperation(value = "To get all the customers",notes="List of customer")
	public List<Customer> allDealers() {
		return customerService.getAllCustomers();

	}

	@GetMapping("/getone/{_id}")
	@ApiOperation(value = "It Show details of a particular customer",notes="to view details of an existing customer")
	public Optional<Customer> oneCustomer(@PathVariable("_id") String _id) {
		return customerService.getOneCustomer(_id);

	}

	@PostMapping("/add")
	@ApiOperation(value = "To add a new customer",notes="to add in mongo database and to create its cart")
	public String addDealer(@RequestBody Customer newDealer) {
		newDealer.set_id(GenerateCustomerId.Total());
		return customerService.addNewCustomer(newDealer);
	}

	@PutMapping("/update")
	@ApiOperation(value = "To update an existing customer",notes="to update an existing customer")
	public String updateCustomer(@RequestBody Customer updateDealer) {
		return customerService.updateCustomer(updateDealer);
	}

	@DeleteMapping("/delete/{_id}")
	@ApiOperation(value = "It delete a particular customer",notes="to delete of an existing customer also deletes its cart")
	public String deleteCustomer(@PathVariable("_id") String _Id) {
		return customerService.deleteCustomer(_Id);
	}


	@GetMapping("/getdealerDetails/{_id}") // to be called by order micro-service
	@ApiOperation(value = "To get one customer details by others",notes="to be called by order micro service")
	public CustomerForOrder oneCustomerDetails(@PathVariable("_id") String _Id) {
		return customerService.forOrderMicroservice(_Id);
	}
	
	@GetMapping("/foradmin")
	@ApiOperation(value = "Data wrapped to be send to admin",notes="to be called by admin microservice to get data")
	public CustomerForAdmin forAdminCustomer() {
		return customerService.forAdminService();// for admin microservice wrapped data

	}
	
	@GetMapping("/customerFName/{_Id}")
	@ApiOperation(value = "It get customer name",notes="required by order and admin microservice")
	public String forCustomerName(@PathVariable("_Id") String _Id) {
		return customerService.getCustomerName(_Id);

	}


}
