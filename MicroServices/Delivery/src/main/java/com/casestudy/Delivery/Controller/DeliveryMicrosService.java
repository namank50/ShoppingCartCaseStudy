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
import com.casestudy.Delivery.Models.DeliveryForAdmin;
import com.casestudy.Delivery.Models.DeliveryForOrder;
import com.casestudy.Delivery.SErvice.DeliveryService;
import com.casestudy.Delivery.SErvice.GenerateDeliveryId;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/delivery")
public class DeliveryMicrosService {

	@Autowired
	DeliveryService deliveryService;

	@GetMapping("/getall")
	@ApiOperation(value = "It Show All the Delivery Services",notes="to view all the delivery services")
	public List<Delivery> allDelivery() {
		return deliveryService.getAllDeliveryServices();

	}

	@GetMapping("/getone/{_Id}")
	@ApiOperation(value = "To get a particular Delivery Services",notes="to get a particular delivery services")
	public Optional<Delivery> oneDelivery(@PathVariable("_Id") String _Id) {
		return deliveryService.getOneDealiveryService(_Id);

	}

	@PostMapping("/add")
	@ApiOperation(value = "To add a new Delivery Service",notes="to add new delivery service")
	public String addDealer(@RequestBody Delivery newDelivery) {
		newDelivery.set_Id(GenerateDeliveryId.Total());
		return deliveryService.addNewDelivery(newDelivery);
	}

	@PutMapping("/update")
	@ApiOperation(value = "To update an existing Delivery Service",notes="to update delivery service")
	public String updateDealer(@RequestBody Delivery updateDelivery) {
		return deliveryService.updateDelivery(updateDelivery);
	}

	@DeleteMapping("/delete/{_Id}")
	@ApiOperation(value = "To delete an existing Delivery Service",notes="to delete delivery service")
	public String deleteDealer(@PathVariable("_Id") String _Id) {
		return deliveryService.deleteDelivery(_Id);
	}

	@GetMapping("/getdeliveryDetails/{_Id}") 
	@ApiOperation(value = "To get delivery Service",notes="for order microservice")
	public DeliveryForOrder oneDealerDetails(@PathVariable("_Id") String _Id) {
		return deliveryService.forOrderMicroservice(_Id);
	}
	
	@GetMapping("/getdeliveryName/{_Id}") // to be called by order micro-service
	@ApiOperation(value = "To get delivery Service Name",notes="for order and admin microservice")
	public String oneDealerName(@PathVariable("_Id") String _Id) {
		return deliveryService.getDealerName(_Id);
	}
	
	@GetMapping("/foradmin")
	@ApiOperation(value = "To get delivery Services data",notes="data wrapped to be called by order microservice")
	public DeliveryForAdmin forAdminDelivery() { //to be called by admin service
		return deliveryService.forAdminService();

	}
	
	@GetMapping("/number")
	@ApiOperation(value = "To get  No. of delivery Services to be used by order microservice",notes="returns number of delivery services")
	public int noOfDealers(){ 
		return deliveryService.noOfDealers();
	}


}
