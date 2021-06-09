package com.casestudy.Delivery.Controller;

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

import com.casestudy.Delivery.Models.Delivery;
import com.casestudy.Delivery.Models.DeliveryForOrder;
import com.casestudy.Delivery.SErvice.DeliveryService;
import com.casestudy.Delivery.SErvice.GenerateDeliveryId;

@RestController
@RequestMapping("/delivery")
public class DeliveryMicrosService {

	@Autowired
	DeliveryService deliveryService;

	@GetMapping("/getall")
	public List<Delivery> allDelivery() {
		return deliveryService.getAllDeliveryServices();

	}

	@GetMapping("/getone/{_Id}")
	public Optional<Delivery> oneDelivery(@PathVariable("_Id") String _Id) {
		return deliveryService.getOneDealiveryService(_Id);

	}

	@PostMapping("/add")
	public String addDealer(@RequestBody Delivery newDelivery) {
		newDelivery.set_Id(GenerateDeliveryId.Total());
		return deliveryService.addNewDelivery(newDelivery);
	}

	@PutMapping("/update")
	public String updateDealer(@RequestBody Delivery updateDelivery) {
		return deliveryService.updateDelivery(updateDelivery);
	}

	@DeleteMapping("/delete/{_Id}")
	public String deleteDealer(@PathVariable("_Id") String _Id) {
		return deliveryService.deleteDelivery(_Id);
	}

	@GetMapping("/getdeliveryDetails/{_Id}") // to be called by order micro-service
	public DeliveryForOrder oneDealerDetails(@PathVariable("_Id") String _Id) {
		return deliveryService.forOrderMicroservice(_Id);
	}

}
