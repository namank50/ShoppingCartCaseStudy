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
import com.casestudy.Orders.Models.OrderForPaymentOutput;
import com.casestudy.Orders.Models.Orders;
import com.casestudy.Orders.Service.OrdersService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrdersService orderService;

	@GetMapping("/all")
	@ApiOperation(value = "To get all the orders",notes="to get the orders in database")
	public List<Orders> getAllOrders() {
		return orderService.getOrders();

	}

	@GetMapping("/oneorder/{_id}")
	@ApiOperation(value = "To get order by specific id",notes="to get only one order")
	public Optional<Orders> getOneOrders(@PathVariable("_id") String _Id) {
		return orderService.getOneOrder(_Id);

	}

	@PostMapping("/add")
	@ApiOperation(value = "To add new order",notes="Delivery,Product,Dealer microservice is required")
	public OrderForPaymentOutput addOrder(@RequestBody OrderForInput order) {
		return orderService.addNewOrder(order);
	}

	@DeleteMapping("/delete/{_id}")
	@ApiOperation(value = "To delete a specific order",notes="to delete an order")
	public String deleteOrder(@PathVariable("_id") String _Id) {
		return orderService.deleteOrder(_Id);
	}

	@PostMapping("/updateStatus/{_id}/{status}")
	@ApiOperation(value = "To change the status ",notes="prepared/shipped/delivered by dealer or delivery")
	public String changeStatusOrder(@PathVariable("_id") String _Id, @PathVariable("status") String status) { // change status to
																									// prepared/shipped/delivered
																									// by
		// dealer or delivery
		return orderService.changeOrderStatus(_Id,status);
	}

	@GetMapping("/updatePayment/{o}")
	@ApiOperation(value = "To update payment status",notes="called by payment service")
	public String updatePaymentStatus(@PathVariable("o") String orderId) { // change status of payment to be called by
																				// payment service after succesfull
																				// payment
		return orderService.updatePaymentStatus(orderId);
	}

//	@GetMapping("/customer/{_id}")                                               //to be sent when customer asks for all his orders
//	public OrderForOutput getOrdersByCustId(@PathVariable("_id") String _Id) {
//		return orderService.getCustomerOrder(_Id);
//		}
//	
//	@GetMapping("/dealer/{_id}")
//	public OrderForOutput getOrdersByDealerId(@PathVariable("_id") String _Id) { //to be sent when dealer asks for all his orders
//		return orderService.getDealerOrder(_Id);
//
//	}
//	
//	@GetMapping("/delivery/{_id}")
//	public OrderForOutput getOrdersByDeliveryId(@PathVariable("_id") String _Id) {  //to be sent when delivery asks for all his orders
//		return orderService.getDeliveryOrder(_Id);
//
//	}
	
	@GetMapping("/forAdmin")
	@ApiOperation(value = "To be sent to adin",notes="called by admin service data wrapped")
	public OrderForAdmin getOrdersForAdmin() {  //to be called by admin microservice
		return orderService.sendOrders();

	}
	
	

}
