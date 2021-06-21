package com.casestudy.Dealer.Controller;

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

import com.casestudy.Dealer.Models.Dealer;
import com.casestudy.Dealer.Models.DealerForAdmin;
import com.casestudy.Dealer.Models.DealerForOrder;
import com.casestudy.Dealer.Service.CustomerServiceImpl;
import com.casestudy.Dealer.Service.DealerServiceImpl;
import com.casestudy.Dealer.Service.GenerateDealerId;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/dealer")
@CrossOrigin(origins = "http://localhost:4200")

public class DealerMicrosService {

	@Autowired
	DealerServiceImpl dealerService;

	@GetMapping("/getall")
	@ApiOperation(value = "It Show All the Dealers",notes="to view all the dealers")
	public List<Dealer> allDealers() {
		return dealerService.getAllDealers();

	}

	@GetMapping("/getone/{_Id}")
	@ApiOperation(value = "To get only one dealer by id",notes="to view only one dealer")
	public Optional<Dealer> oneDealer(@PathVariable("_Id") String _Id) {
		return dealerService.getOneDealer(_Id);

	}

	@PostMapping("/add")
	@ApiOperation(value = "To add a new dealer ",notes="to add new dealer in database")
	public String addDealer(@RequestBody Dealer newDealer) {
		newDealer.set_Id(GenerateDealerId.Total());
		return dealerService.addNewDealer(newDealer);
	}

	@PutMapping("/update")
	@ApiOperation(value = "To update an existing  dealer ",notes="to update dealer in database")
	public String updateDealer(@RequestBody Dealer updateDealer) {
		return dealerService.updateDealer(updateDealer);
	}

	@DeleteMapping("/delete/{_Id}")
	@ApiOperation(value = "To delete a dealer ",notes="to deleta a dealer from the database")
	public String deleteDealer(@PathVariable("_Id") String _Id) {
		return dealerService.deleteDealer(_Id);
	}

	@GetMapping("/getFirmName/{_Id}") 
	@ApiOperation(value = "To get the firm name of dealer ",notes="to be called by product microservice")
	public String oneDealerFirmName(@PathVariable("_Id") String _Id) {
		return dealerService.forProductMicroservice(_Id);
	}

	@GetMapping("/getdealerDetails/{_Id}") // to be called by order micro-service
	@ApiOperation(value = "To get the details of dealer ",notes="to be called by order microservice")
	public DealerForOrder oneDealerDetails(@PathVariable("_Id") String _Id) {
		return dealerService.forOrderMicroservice(_Id);
	}
	
	@GetMapping("/foradmin")
	@ApiOperation(value = "To get the details of dealer ",notes="data wrapped to be sent to admin microservice")
	public DealerForAdmin forAdminDealers() {
		return dealerService.forAdminService();// for admin microservice wrapped data

	}


}
