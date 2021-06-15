package com.casestudy.Payment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.casestudy.Payment.DTO.Order;
import com.casestudy.Payment.Service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

@Controller
public class PaypalController {

	@Autowired
	PaypalService service;
	@Autowired
	Order order;
	
	public static final String SUCCESS_URL = "pay/success";
	public static final String CANCEL_URL = "pay/cancel";


	@GetMapping("/pay")
	public String payment() {
		order.setCurrency("USD");
		order.setPrice(10);
		order.setIntent("sale");
		order.setMethod("paypal");
		order.setDescription("testing payment");
		try {
			Payment payment = service.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
					order.getIntent(), order.getDescription(), "http://localhost:8089/" + CANCEL_URL,
					"http://localhost:8089/" + SUCCESS_URL);
			for(Links link:payment.getLinks()) {
				if(link.getRel().equals("approval_url")) {
					return "redirect:"+link.getHref();
				}
			}
			
		} catch (PayPalRESTException e) {
		
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	 @GetMapping(value = CANCEL_URL)
	 @ResponseBody
	    public String cancelPay() {
	        return "cancel";
	    }

	    @GetMapping(value = SUCCESS_URL)
	    @ResponseBody
	    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
	        try {
	            Payment payment = service.executePayment(paymentId, payerId);
	            System.out.println(payment.toJSON());
	            if (payment.getState().equals("approved")) {
	                return "success";
	            }
	        } catch (PayPalRESTException e) {
	         System.out.println(e.getMessage());
	        }
	        return "redirect:/";
	    }

}
