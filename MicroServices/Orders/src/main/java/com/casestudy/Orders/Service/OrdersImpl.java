package com.casestudy.Orders.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.casestudy.Orders.DAO.OrdersDatabase;
import com.casestudy.Orders.Models.OrderForAdmin;
import com.casestudy.Orders.Models.OrderForInput;
import com.casestudy.Orders.Models.OrderForOutput;
import com.casestudy.Orders.Models.Orders;
import com.casestudy.Orders.Models.Products;

@Service
public class OrdersImpl implements OrdersService {
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	OrdersDatabase orderDatabase;
	@Autowired
	Orders orders;
	@Autowired
	GenerateDID generateDID;
	@Autowired
	OrderForAdmin orderForAdmin;
	
	@Autowired
	OrderForOutput orderForOutput;

//	Set<String> s1= new HashSet<>();
//	List<Products> p2= new ArrayList<>();
//	List<String> p5=new ArrayList<>();
	

	@Override
	public List<Orders> getOrders() {
		// TODO Auto-generated method stub
		return orderDatabase.findAll();
	}

	@Override
	public Optional<Orders> getOneOrder(String _Id) {
		// TODO Auto-generated method stub
		return orderDatabase.findById(_Id);
	}

	@Override
	public List<String> addNewOrder(OrderForInput order1) {
		Set<String> s1= new HashSet<>();
		int total=0;
		List<Products> p2= new ArrayList<>();
		List<String> odd= new ArrayList<>();
		int flag=0;
		LocalDate myObj = LocalDate.now();
		String s=String.valueOf(myObj);
		for(String p: order1.getPID()) {
			ResponseEntity<Products> p1=restTemplate.getForEntity("http://localhost:8085/product/getone/"+p, Products.class);
			s1.add(p1.getBody().getDealerId());
			p2.add(p1.getBody());			
		}
		for(Products pro:p2) {
			flag=0;
			if(pro.getQuantity()>0)
				flag=1;
		}
		if(flag==1) {
			for(String did : s1) {
				List<String> p5=new ArrayList<>();
				int sum=0;
				for(Products prod: p2) {
					if(prod.getDealerId().matches(did)) {
						p5.add(prod.get_id());
						sum=sum+prod.getPrice();
						total+=prod.getPrice();
					}
				}
				String y=GenerateDeliveryId.Total();
				orders.set_id(y);
				odd.add(y);
				orders.setPID(p5);
				orders.setDEAID(did);
				orders.setDate(s);
				orders.setCUSTID(order1.getCUSTID());
				orders.setStatus("Ordered");
				orders.setPaymentStatus(false);
				orders.setTotal(sum);
				orders.setDID(generateDID.generateDID());
				orderDatabase.save(orders);
			}
			return odd;
		}
		return odd;
		
	}

	@Override
	public String deleteOrder(String _Id) {
		orderDatabase.deleteById(_Id);
		return "Success";
	}

	@Override
	public String changeOrderStatus(String _Id,String status) {
		Orders o = orderDatabase.findById(_Id).orElse(null);
		o.setStatus(status);
		orderDatabase.save(o);
		return "Changed Status of" +_Id + "to"+status ;
	}

	@Override
	public String updatePaymentStatus(List<String> orderList) {
		for(String o : orderList) {
			Orders o1 = orderDatabase.findById(o).orElse(null);
			o1.setPaymentStatus(true);
			orderDatabase.save(o1);
			
		}
		return "Updated";
	}

	@Override
	public OrderForOutput getCustomerOrder(String _Id) {
		List<Orders> oCustomer = orderDatabase.findAll();
		List<Orders> oCust = new ArrayList<Orders>();
		for(Orders o : oCustomer) {
			if(o.getCUSTID().matches(_Id)) {
				oCust.add(o);
			}
		}
		
		return generateOrderObject( oCust);
	}

	@Override
	public OrderForOutput getDealerOrder(String _Id) {
		List<Orders> oCustomer = orderDatabase.findAll();
		List<Orders> oCust = new ArrayList<Orders>();
		for(Orders o : oCustomer) {
			if(o.getDEAID().matches(_Id)) {
				oCust.add(o);
			}
		}
		return generateOrderObject( oCust);
	}

	@Override
	public OrderForOutput getDeliveryOrder(String _Id) {
		List<Orders> oCustomer = orderDatabase.findAll();
		List<Orders> oCust = new ArrayList<Orders>();
		for(Orders o : oCustomer) {
			if(o.getDID().matches(_Id)) {
				oCust.add(o);
			}
		}
		return generateOrderObject( oCust);
	}
	
	
	public OrderForOutput generateOrderObject(List<Orders> oCust) {
		List<String> l1= new ArrayList<String>();
		List<OrderForOutput> l2= new ArrayList<>();
		for(Orders o1: oCust) {
			orderForOutput.set_id(o1.get_id());
			orderForOutput.setDate(o1.getDate());
			orderForOutput.setPaymentStatus(o1.isPaymentStatus());
			orderForOutput.setStatus(o1.getStatus());
			orderForOutput.setTotal(o1.getTotal());
			String DealerName =restTemplate.getForObject("http://localhost:8082/dealer/getFirmName/"+o1.getDEAID(), String.class);
			orderForOutput.setDealerName(DealerName);
			String DealiveryName =restTemplate.getForObject("http://localhost:8083/delivery/getdeliveryName/"+o1.getDID(), String.class);
			orderForOutput.setDealiiveryName(DealiveryName);
			String CustName =restTemplate.getForObject("http://localhost:8081/customer/customerFName/"+o1.getCUSTID(), String.class);
			orderForOutput.setDealiiveryName(CustName);
			for(String p : o1.getPID()) {
				String p1=restTemplate.getForObject("http://localhost:8085/product/productName/"+p, String.class);	
				l1.add(p1);
			}
			orderForOutput.setPName(l1);
			l2.add(orderForOutput);		
		}
		return orderForOutput;
	}

	@Override
	public OrderForAdmin sendOrders() {
		List<Orders> o1=getOrders();
		orderForAdmin.setOrderList(o1);		
		return orderForAdmin;
	}
	
	

}
