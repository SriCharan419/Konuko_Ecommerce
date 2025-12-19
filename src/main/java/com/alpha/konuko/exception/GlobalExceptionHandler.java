package com.alpha.konuko.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alpha.konuko.ResponseStructure;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(CarrierNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> carrierNotFoundExceptionHandler(CarrierNotFoundException e)
	{
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStatuscode(HttpStatus.NOT_FOUND.value());
		rs.setMessage("Carrier NOT FOUND");
		rs.setData("Carrier NOT FOUND");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> productNotFoundExceptionHandler(ProductNotFoundException e)
	{
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStatuscode(HttpStatus.NOT_FOUND.value());
		rs.setMessage("Product NOT FOUND");
		rs.setData("Product NOT FOUND");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> adminNotFoundExceptionHandler(AdminNotFoundException e)
	{
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStatuscode(HttpStatus.NOT_FOUND.value());
		rs.setMessage("Admin NOT FOUND");
		rs.setData("Admin NOT FOUND");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> customerNotFoundExceptionHandler(CustomerNotFoundException e)
	{
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStatuscode(HttpStatus.NOT_FOUND.value());
		rs.setMessage("Customer NOT FOUND");
		rs.setData("Customer NOT FOUND");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> orderNotFoundExceptionHandler(OrderNotFoundException e)
	{
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStatuscode(HttpStatus.NOT_FOUND.value());
		rs.setMessage("Order NOT FOUND");
		rs.setData("Order NOT FOUND");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> addressNotFoundExceptionHandler(AddressNotFoundException e)
	{
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStatuscode(HttpStatus.NOT_FOUND.value());
		rs.setMessage("Address NOT FOUND");
		rs.setData("Address NOT FOUND");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(OrderStatusException.class)
	public ResponseEntity<ResponseStructure<String>> orderStatusExceptionHandler(OrderStatusException e)
	{
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStatuscode(HttpStatus.EXPECTATION_FAILED.value());
		rs.setMessage("Order already assigned or delivered or cancelled");
		rs.setData("Order already assigned or delivered or cancelled");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(CarrierCapacityException.class)
	public ResponseEntity<ResponseStructure<String>> carrierCapacityExceptionHandler(CarrierCapacityException e)
	{
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStatuscode(HttpStatus.EXPECTATION_FAILED.value());
		rs.setMessage("Carrier capacity is full");
		rs.setData("Carrier capacity is full");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(NoAvailableProductsException.class)
	public ResponseEntity<ResponseStructure<String>> noAvailableProductsExceptionHandler(NoAvailableProductsException e)
	{
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("No available products");
		rs.setData("No available products");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.OK);
	}
	
	@ExceptionHandler(InvalidOtpException.class)
	public ResponseEntity<ResponseStructure<String>> invalidOtpExceptionHandler(InvalidOtpException e)
	{
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStatuscode(HttpStatus.NOT_ACCEPTABLE.value());
		rs.setMessage("Otp is invalid");
		rs.setData("Otp is invalid");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_ACCEPTABLE);
	}
	
}
