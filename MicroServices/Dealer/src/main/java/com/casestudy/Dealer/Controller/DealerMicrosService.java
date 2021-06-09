package com.casestudy.Dealer.Controller;

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

import com.casestudy.Dealer.Models.Dealer;
import com.casestudy.Dealer.Models.DealerForAdmin;
import com.casestudy.Dealer.Models.DealerForOrder;
import com.casestudy.Dealer.Service.DealerServiceImpl;
import com.casestudy.Dealer.Service.GenerateDealerId;

@RestController
@RequestMapping("/dealer")
public class DealerMicrosService {

	@Autowired
	DealerServiceImpl dealerService;

	@GetMapping("/getall")
	public List<Dealer> allDealers() {
		return dealerService.getAllDealers();

	}

	@GetMapping("/getone/{_Id}")
	public Optional<Dealer> oneDealer(@PathVariable("_Id") String _Id) {
		return dealerService.getOneDealer(_Id);

	}

	@PostMapping("/add")
	public String addDealer(@RequestBody Dealer newDealer) {
		newDealer.set_Id(GenerateDealerId.Total());
		return dealerService.addNewDealer(newDealer);
	}

	@PutMapping("/update")
	public String updateDealer(@RequestBody Dealer updateDealer) {
		return dealerService.updateDealer(updateDealer);
	}

	@DeleteMapping("/delete/{_Id}")
	public String deleteDealer(@PathVariable("_Id") String _Id) {
		return dealerService.deleteDealer(_Id);
	}

	@GetMapping("/getFirmName/{_Id}") // to be called by product micro-service
	public String oneDealerFirmName(@PathVariable("_Id") String _Id) {
		return dealerService.forProductMicroservice(_Id);
	}

	@GetMapping("/getdealerDetails/{_Id}") // to be called by order micro-service
	public DealerForOrder oneDealerDetails(@PathVariable("_Id") String _Id) {
		return dealerService.forOrderMicroservice(_Id);
	}
	
	@GetMapping("/foradmin")
	public DealerForAdmin forAdminDealers() {
		return dealerService.forAdminService();// for admin microservice wrapped data

	}


}
