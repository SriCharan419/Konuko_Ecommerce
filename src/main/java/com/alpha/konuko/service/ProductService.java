package com.alpha.konuko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.konuko.ResponseStructure;
import com.alpha.konuko.dto.SaveProductDTO;
import com.alpha.konuko.entity.Product;
import com.alpha.konuko.exception.ProductNotFoundException;
import com.alpha.konuko.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo pr;
	
	public ResponseEntity<ResponseStructure<Product>> addnewProduct(SaveProductDTO spdto) {
		Product p = new Product();
		p.setName(spdto.getName());
		p.setQuantity(spdto.getQuantity());
		p.setCategory(spdto.getCategory());
		p.setPriceperunit(spdto.getPriceperunit());
		p.setBrandname(spdto.getBrandname());
		p.setDescription(spdto.getDescription());
		p.setAvailabilitystatus("Available");
		pr.save(p);
		ResponseStructure<Product> rs = new ResponseStructure<Product>();
		rs.setStatuscode(HttpStatus.CREATED.value());
		rs.setMessage("Product added successfully");
		rs.setData(p);
		return new ResponseEntity<ResponseStructure<Product>>(rs,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Product>>> findallProducts() {
		List<Product> plist= pr.findAll();
		ResponseStructure<List<Product>> rs = new ResponseStructure<List<Product>>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Product list fetched");
		rs.setData(plist);
		return new ResponseEntity<ResponseStructure<List<Product>>>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Product>> updateProductavailabilityStatus(int id, String status) {
		Product p = pr.findById(id).orElseThrow(()->new ProductNotFoundException());
		p.setAvailabilitystatus(status);
		ResponseStructure<Product> rs = new ResponseStructure<Product>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Product status updated");
		rs.setData(p);
		return new ResponseEntity<ResponseStructure<Product>>(rs,HttpStatus.OK);
	}
	
}
