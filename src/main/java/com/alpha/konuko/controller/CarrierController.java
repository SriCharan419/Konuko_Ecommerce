package com.alpha.konuko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.konuko.ResponseStructure;
import com.alpha.konuko.dto.CarrierOrderDTO;
import com.alpha.konuko.service.CarrierService;

@RestController
@RequestMapping("/carrier")
public class CarrierController {
	
	@Autowired
	private CarrierService cs;
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<CarrierOrderDTO>>> seeallactiveorders(@RequestParam long mobileno)
	{
		return cs.seeallactiveorders(mobileno);
	}
	
	@PutMapping("/updateorder/confirmdelivery")
	public ResponseEntity<ResponseStructure<String>> confirmdelivery(@RequestParam int orderid,@RequestParam int otp)
	{
		return cs.confirmdelivery(orderid,otp);
	}
}
