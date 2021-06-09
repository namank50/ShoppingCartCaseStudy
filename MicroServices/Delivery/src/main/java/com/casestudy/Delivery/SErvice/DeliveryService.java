package com.casestudy.Delivery.SErvice;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.casestudy.Delivery.Models.Delivery;
import com.casestudy.Delivery.Models.DeliveryForOrder;

@Service
public interface DeliveryService {
	public List<Delivery> getAllDeliveryServices();
	public Optional<Delivery> getOneDealiveryService(String _Id);
	public String addNewDelivery(Delivery newDealer);
	public String updateDelivery(Delivery updateDealer);
	public String deleteDelivery(String _Id);
	public DeliveryForOrder forOrderMicroservice(String _Id);

}
