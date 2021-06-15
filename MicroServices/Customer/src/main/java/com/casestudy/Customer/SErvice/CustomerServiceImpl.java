package com.casestudy.Customer.SErvice;

import java.util.List;
import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.casestudy.Customer.DAO.CustomerDatabase;
import com.casestudy.Customer.Models.Customer;
import com.casestudy.Customer.Models.CustomerForAdmin;
import com.casestudy.Customer.Models.CustomerForOrder;
import com.casestudy.Customer.Models.ForQueue;
import com.casestudy.Customer.Models.QueueForCart;
import com.casestudy.Customer.config.MessagingConfig;
import com.casestudy.Customer.config.MessagingQueueConfigCart;
import com.casestudy.Delivery.Models.Delivery;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDatabase repository;
	@Autowired
	CustomerForOrder customerForOrder;
	@Autowired
	CustomerForAdmin customerForAdmin;
	@Autowired
	ForQueue forQueue;
	@Autowired
	RabbitTemplate rabbitTemplate;
	@Autowired
	private RestTemplate restTemplate;

	public List<Customer> getAllCustomers() {
		return repository.findAll();
	}

	public Optional<Customer> getOneCustomer(String _id) {
		return repository.findById(_id);
	}

	public String addNewCustomer(Customer newCustomer) { // add entry into security db also
		repository.save(newCustomer);
		forQueue.set_id(newCustomer.get_id());
		forQueue.setPassword(newCustomer.getPassword());
		forQueue.setRole("Customer");
		rabbitTemplate.convertAndSend(MessagingConfig.Exchange, MessagingConfig.Routing, forQueue);// sending data to
																									// queue
		String y = restTemplate.getForObject("http://localhost:8087/cart/add/"+newCustomer.get_id(),String.class);
		return "Successfully Added New Customer With Id" + newCustomer.get_id()+" "+y;

	}

	public String updateCustomer(Customer updateCustomer) {
		repository.save(updateCustomer);
		forQueue.set_id(updateCustomer.get_id());
		forQueue.setPassword(updateCustomer.getPassword());
		forQueue.setRole("Dealer");
		rabbitTemplate.convertAndSend(MessagingConfig.Exchange, MessagingConfig.Routing, forQueue);  // sending data to queue
		return "Customer Updated Successfully";
	}

	public String deleteCustomer(String _id) { // remove entry from security db also
		repository.deleteById(_id);
		String y = restTemplate.getForObject("http://localhost:8087/cart/delete/"+_id,String.class);
		String x=restTemplate.getForObject("http://localhost:8088/security/delete/"+_id,String.class);
		return "Dealer with " + _id + " deleted successfully"+x+""+y;
	}

	public CustomerForOrder forOrderMicroservice(String _Id) { // order micro-service will require the object
																// "DealerforOrder"
		Optional<Customer> proCustomer = getOneCustomer(_Id);
		customerForOrder.setName(proCustomer.get().getName());
		customerForOrder.setCustEmail(proCustomer.get().getCustEmail());
		customerForOrder.setCustAddress(proCustomer.get().getCustAddress());
		customerForOrder.setCustMobNo(proCustomer.get().getCustMobNo());
		return customerForOrder;

	}

	public CustomerForAdmin forAdminService() { // admin micro service will get this wrapped data
		List<Customer> customerList = getAllCustomers();
		customerForAdmin.setCustomerData(customerList);
		return customerForAdmin;

	}
	
	@Override
	public String getCustomerName(String _Id) {
		// TODO Auto-generated method stub
		Customer d =repository.findById(_Id).orElse(null);
		return d.getName().getFName();
	}

}