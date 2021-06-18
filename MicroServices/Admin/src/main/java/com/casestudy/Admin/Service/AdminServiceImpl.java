package com.casestudy.Admin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.casestudy.Admin.Models.Customer;
import com.casestudy.Admin.Models.CustomerForAdmin;
import com.casestudy.Admin.Models.Dealer;
import com.casestudy.Admin.Models.DealerForAdmin;
import com.casestudy.Admin.Models.Delivery;
import com.casestudy.Admin.Models.DeliveryForAdmin;
import com.casestudy.Admin.Models.OrderForAdmin;
import com.casestudy.Admin.Models.Orders;
import com.casestudy.Admin.Models.Products;
import com.casestudy.Admin.Models.ProductsForAdmin;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Customer> getAllCustomerDetails() {
			CustomerForAdmin custList=restTemplate.getForObject("http://localhost:8081/customer/foradmin", CustomerForAdmin.class);
			List<Customer> cust = custList.getCustomerData().stream().toList() ;
			return cust;
	}
	
	@Override
	public List<Dealer> getAllDealerDetails() {
			DealerForAdmin dealerList=restTemplate.getForObject("http://localhost:8082/dealer/foradmin", DealerForAdmin.class);
			List<Dealer> dealers = dealerList.getDealerData().stream().toList() ;
			return dealers;
	}
	
	
	@Override
	public List<Delivery> getAllDeliveryDetails() {
			DeliveryForAdmin dealerList=restTemplate.getForObject("http://localhost:8083/delivery/foradmin", DeliveryForAdmin.class);
			List<Delivery> deliveries = dealerList.getDeliveryData().stream().toList() ;
			return deliveries;
	}

	@Override
	public List<Products> getAllProductsDetails() {
		ProductsForAdmin productList=restTemplate.getForObject("http://localhost:8085/product/foradmin", ProductsForAdmin.class);
		List<Products> products = productList.getProducts().stream().toList() ;
		for(Products p : products) {
			String DealerFirmName = restTemplate.getForObject("http://localhost:8082/dealer//getFirmName/"+p.getDealerId(), String.class);
			p.setDealerId(DealerFirmName);
		}
		return products;
	}
	
	
	@Override
	public List<Orders> getAllOrderDetails() {
			OrderForAdmin orderList=restTemplate.getForObject("http://localhost:8086/order/forAdmin", OrderForAdmin.class);
			List<Orders> orders = orderList.getOrderList().stream().toList() ;
			return orders;
	}


}
