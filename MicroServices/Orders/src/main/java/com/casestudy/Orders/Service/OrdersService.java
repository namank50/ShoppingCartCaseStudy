package com.casestudy.Orders.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.casestudy.Orders.Models.OrderForAdmin;
import com.casestudy.Orders.Models.OrderForInput;
import com.casestudy.Orders.Models.OrderForOutput;
import com.casestudy.Orders.Models.OrderForPaymentOutput;
import com.casestudy.Orders.Models.Orders;

@Service
public interface OrdersService {

	List<Orders> getOrders();

	Optional<Orders> getOneOrder(String _Id);

	OrderForPaymentOutput addNewOrder(OrderForInput order);

	String deleteOrder(String _Id);

	String changeOrderStatus(String _Id, String status);


//	OrderForOutput getCustomerOrder(String _Id);
//
//	OrderForOutput getDealerOrder(String _Id);
//
//	OrderForOutput getDeliveryOrder(String _Id);
	
	public OrderForAdmin sendOrders();

	String updatePaymentStatus(String orderId);

}
