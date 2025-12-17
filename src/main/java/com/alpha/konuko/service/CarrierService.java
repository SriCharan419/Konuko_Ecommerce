package com.alpha.konuko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.konuko.ResponseStructure;
import com.alpha.konuko.dto.CarrierDTO;
import com.alpha.konuko.entity.Carrier;
import com.alpha.konuko.exception.CarrierNotFoundException;
import com.alpha.konuko.repo.CarrierRepo;

@Service
public class CarrierService {

	@Autowired
	private CarrierRepo cr;
	
	public ResponseEntity<ResponseStructure<Carrier>> saveCarrier(CarrierDTO cdto) {
		Carrier c = new Carrier();
		c.setName(cdto.getName());
		c.setMobileno(cdto.getMobileno());
		c.setMailid(cdto.getMailid());
		cr.save(c);
		ResponseStructure<Carrier> rs = new ResponseStructure<Carrier>();
		rs.setStatuscode(HttpStatus.CREATED.value());
		rs.setMessage("Carrier saved successfully");
		rs.setData(c);
		return new ResponseEntity<ResponseStructure<Carrier>>(rs,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Carrier>> findCarrier(long mobileno) {
		Carrier c = cr.findBymobileno(mobileno).orElseThrow(()->new CarrierNotFoundException());
		ResponseStructure<Carrier> rs = new ResponseStructure<Carrier>();
		rs.setStatuscode(HttpStatus.FOUND.value());
		rs.setMessage("Carrier with mobileno:"+mobileno+"found");
		rs.setData(c);
		return new ResponseEntity<ResponseStructure<Carrier>>(rs,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<String>> deleteCarrier(long mobileno) {
		Carrier c = cr.findBymobileno(mobileno).orElseThrow(()->new CarrierNotFoundException());
		cr.delete(c);
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Carrier with mobileno:"+mobileno+"deleted");
		rs.setData("Carrier with mobileno:"+mobileno+"deleted");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.OK);
	}
	
}
