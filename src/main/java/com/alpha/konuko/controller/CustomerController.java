package com.alpha.konuko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.konuko.ResponseStructure;
import com.alpha.konuko.dto.RegCustomerDTO;
import com.alpha.konuko.entity.Address;
import com.alpha.konuko.entity.Customer;
import com.alpha.konuko.entity.Product;
import com.alpha.konuko.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService cs;
	
	@PostMapping("/registerCustomer")
	public ResponseEntity<ResponseStructure<Customer>> registerCustomer(@RequestBody RegCustomerDTO rdto)
	{
		return cs.registerCustomer(rdto);
	}
	
	@PostMapping("/addaddress")
	public ResponseEntity<ResponseStructure<Address>> addaddress(@RequestParam long mobileno,@RequestBody Address add)
	{
		return cs.addaddress(mobileno,add);
	}
	
	@DeleteMapping("/deleteaddress")
	public ResponseEntity<ResponseStructure<Address>> deleteaddress(@RequestParam long mobileno,@RequestParam int addid)
	{
		return cs.deleteaddress(mobileno,addid);
	}
	
	@GetMapping("/seeallavailableproducts")
	public ResponseEntity<ResponseStructure<List<Product>>> seeallavailableproducts()
	{
		return cs.seeallavailableproducts();
	}
	
	@PostMapping("/addproducttocart")
	public ResponseEntity<ResponseStructure<Product>> addproducttocart(@RequestParam long mobileno,@RequestParam int prodid)
	{
		return cs.addproducttocart(mobileno,prodid);
	}
}
