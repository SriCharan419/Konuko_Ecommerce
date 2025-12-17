package com.alpha.konuko.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.konuko.ResponseStructure;
import com.alpha.konuko.dto.RegCustomerDTO;
import com.alpha.konuko.entity.Address;
import com.alpha.konuko.entity.Customer;
import com.alpha.konuko.entity.Order;
import com.alpha.konuko.entity.Product;
import com.alpha.konuko.exception.CustomerNotFoundException;
import com.alpha.konuko.exception.NoAvailableProductsException;
import com.alpha.konuko.exception.ProductNotFoundException;
import com.alpha.konuko.repo.AddressRepo;
import com.alpha.konuko.repo.CustomerRepo;
import com.alpha.konuko.repo.OrderRepo;
import com.alpha.konuko.repo.ProductRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo cr;
	
	@Autowired
	private AddressRepo ar;
	
	@Autowired
	private ProductRepo pr;
	
	@Autowired
	private OrderRepo or;
	
	public ResponseEntity<ResponseStructure<Customer>> registerCustomer(RegCustomerDTO rdto) {
		Customer c = new Customer();
		c.setName(rdto.getName());
		c.setMobileno(rdto.getMobileno());
		c.setMail(rdto.getMail());
		c.getAlist().add(rdto.getAdd());
		ar.save(rdto.getAdd());
		cr.save(c);
		
		ResponseStructure<Customer> rs = new ResponseStructure<Customer>();
		rs.setStatuscode(HttpStatus.CREATED.value());
		rs.setMessage("Customer registered successfully");
		rs.setData(c);
		return new ResponseEntity<ResponseStructure<Customer>>(rs,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> addaddress(long mobileno, Address add) {
		Customer c = cr.findBymobileno(mobileno).orElseThrow(()->new CustomerNotFoundException());
		c.getAlist().add(add);
		ar.save(add);
		cr.save(c);
		ResponseStructure<Address> rs = new ResponseStructure<Address>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Customer address added");
		rs.setData(add);
		return new ResponseEntity<ResponseStructure<Address>>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Address>> deleteaddress(long mobileno, int addid) {
		Customer c = cr.findBymobileno(mobileno).orElseThrow(()->new CustomerNotFoundException());
		List<Address> alist = c.getAlist();
		Address add = new Address();
		for(Address a: alist)
		{
			if(a.getId()==addid)
			{
				add=a;
				break;
			}
		}
		c.getAlist().remove(add);
		ar.delete(add);
		cr.save(c);
		ResponseStructure<Address> rs = new ResponseStructure<Address>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Customer address deleted");
		rs.setData(add);
		return new ResponseEntity<ResponseStructure<Address>>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Product>>> seeallavailableproducts() {
		List<Product> plist = pr.findByavailabilitystatus().orElseThrow(()->new NoAvailableProductsException());
		ResponseStructure<List<Product>> rs = new ResponseStructure<List<Product>>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Available products fetched");
		rs.setData(plist);
		return new ResponseEntity<ResponseStructure<List<Product>>>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Product>> addproducttocart(long mobileno, int prodid) {
		Customer c = cr.findBymobileno(mobileno).orElseThrow(()->new CustomerNotFoundException());
		Product p = pr.findById(prodid).orElseThrow(()->new ProductNotFoundException());
		c.getCart().add(p);
		cr.save(c);
		ResponseStructure<Product> rs = new ResponseStructure<Product>();
		rs.setStatuscode(HttpStatus.CREATED.value());
		rs.setMessage("Product added to cart");
		rs.setData(p);
		return new ResponseEntity<ResponseStructure<Product>>(rs,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Product>>> seecart(long mobileno) {
		Customer c = cr.findBymobileno(mobileno).orElseThrow(()->new CustomerNotFoundException());
		List<Product> cart = c.getCart();
		ResponseStructure<List<Product>> rs = new ResponseStructure<List<Product>>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Cart list fetched");
		rs.setData(cart);
		return new ResponseEntity<ResponseStructure<List<Product>>>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Product>>> removeproductfromcart(long mobileno, int prodid) {
		Customer c = cr.findBymobileno(mobileno).orElseThrow(()->new CustomerNotFoundException());
		List<Product> cart = c.getCart();
		Product p = new Product();
		for(Product pr:cart)
		{
			if(pr.getId()==prodid)
			{
				p=pr;
				break;
			}
		}
		cart.remove(p);
		cr.save(c);
		ResponseStructure<List<Product>> rs = new ResponseStructure<List<Product>>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Product removed from the cart");
		rs.setData(cart);
		return new ResponseEntity<ResponseStructure<List<Product>>>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Order>> placeorder(long mobileno,int deliveryaddid) 
	{	
		Customer c = cr.findBymobileno(mobileno).orElseThrow(()->new CustomerNotFoundException());
		List<Product> cart = c.getCart();
		Address adr = new Address();
		for(Address a: c.getAlist())
		{
			if(a.getId()==deliveryaddid)
			{
				adr=a;
				break;
			}
		}
		Order ord = new Order();
		ord.setPurchaseLists(cart);
		ord.setCustomer(c);
		ord.setDate(LocalDate.now());
		ord.setDeliveryloc(adr);
		ord.setExpecteddeliverydate(LocalDate.now().plusDays(2));
		double totalprice=0;
		for(Product p:cart)
		{
			p.setQuantity(p.getQuantity()-1);
			totalprice+=p.getPriceperunit();
			pr.save(p);
		}
		ord.setTotalprice(totalprice);
		c.setCart(new ArrayList<Product>());
		c.getOlist().add(ord);
		or.save(ord);
		cr.save(c);
		ResponseStructure<Order> rs = new ResponseStructure<Order>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Order placed successfully");
		rs.setData(ord);
		return new ResponseEntity<ResponseStructure<Order>>(rs,HttpStatus.OK);
	}
	
}
