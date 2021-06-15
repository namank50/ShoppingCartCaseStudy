package com.casestudy.Orders.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.Orders.Models.OrderForAdmin;
import com.casestudy.Orders.Models.OrderForInput;
import com.casestudy.Orders.Models.OrderForOutput;
import com.casestudy.Orders.Models.Orders;
import com.casestudy.Orders.Service.OrdersService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrdersService orderService;

	@GetMapping("/all")
	public List<Orders> getAllOrders() {
		return orderService.getOrders();

	}

	@GetMapping("/oneorder/{_id}")
	public Optional<Orders> getOneOrders(@PathVariable("_id") String _Id) {
		return orderService.getOneOrder(_Id);

	}

	@PostMapping("/add")
	public List<String> addOrder(@RequestBody OrderForInput order) {
		return orderService.addNewOrder(order);
	}

	@DeleteMapping("/delete/{_id}")
	public String deleteOrder(@PathVariable("_id") String _Id) {
		return orderService.deleteOrder(_Id);
	}

	@PostMapping("/updateStatus/{_id}")
	public String changeStatusOrder(@PathVariable("_id") String _Id, @RequestBody String status) { // change status to
																									// prepared/shipped/delivered
																									// by
		// dealer or delivery
		return orderService.changeOrderStatus(_Id,status);
	}

	@PostMapping("/updatePayment")
	public String updatePaymentStatus(@RequestBody List<String> orderList) { // change status of payment to be called by
																				// payment service after succesfull
																				// payment
		return orderService.updatePaymentStatus(orderList);
	}

	@GetMapping("/customer/{_id}")                                               //to be sent when customer asks for all his orders
	public OrderForOutput getOrdersByCustId(@PathVariable("_id") String _Id) {
		return orderService.getCustomerOrder(_Id);

	}
	
	@GetMapping("/dealer/{_id}")
	public OrderForOutput getOrdersByDealerId(@PathVariable("_id") String _Id) { //to be sent when dealer asks for all his orders
		return orderService.getDealerOrder(_Id);

	}
	
	@GetMapping("/delivery/{_id}")
	public OrderForOutput getOrdersByDeliveryId(@PathVariable("_id") String _Id) {  //to be sent when delivery asks for all his orders
		return orderService.getDeliveryOrder(_Id);

	}
	
	@GetMapping("/forAdmin")
	public OrderForAdmin getOrdersForAdmin() {  //to be called by admin microservice
		return orderService.sendOrders();

	}
	
	

}
