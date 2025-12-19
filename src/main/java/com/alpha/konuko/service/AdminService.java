package com.alpha.konuko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.konuko.ResponseStructure;
import com.alpha.konuko.dto.AddressDTO;
import com.alpha.konuko.dto.AdminDTO;
import com.alpha.konuko.entity.Address;
import com.alpha.konuko.entity.Admin;
import com.alpha.konuko.entity.Carrier;
import com.alpha.konuko.entity.Order;
import com.alpha.konuko.exception.AddressNotFoundException;
import com.alpha.konuko.exception.AdminNotFoundException;
import com.alpha.konuko.exception.CarrierCapacityException;
import com.alpha.konuko.exception.CarrierNotFoundException;
import com.alpha.konuko.exception.OrderNotFoundException;
import com.alpha.konuko.exception.OrderStatusException;
import com.alpha.konuko.repo.AddressRepo;
import com.alpha.konuko.repo.AdminRepo;
import com.alpha.konuko.repo.CarrierRepo;
import com.alpha.konuko.repo.OrderRepo;

@Service
public class AdminService {

	@Autowired
	private AdminRepo ar;
	
	@Autowired
	private AddressRepo adr;
	
	@Autowired
	private OrderRepo or;
	
	@Autowired
	private CarrierRepo cr;
	
	public ResponseEntity<ResponseStructure<Admin>> saveadmin(AdminDTO adto) {
		Admin a = new Admin();
		a.setName(adto.getName());
		a.setMobileno(adto.getMobileno());
		a.setMail(adto.getMail());
		ar.save(a);
		ResponseStructure<Admin> rs = new ResponseStructure<Admin>();
		rs.setStatuscode(HttpStatus.CREATED.value());
		rs.setMessage("Admin saved successfully");
		rs.setData(a);
		return new ResponseEntity<ResponseStructure<Admin>>(rs,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> addnewAddress(AddressDTO adto, long mobileno) throws AdminNotFoundException {
		Admin a = ar.findByMobileno(mobileno).orElseThrow(()->new AdminNotFoundException());
		Address add = new Address();
		add.setCity(adto.getCity());
		add.setPincode(adto.getPincode());
		add.setState(adto.getState());
		add.setCountry(adto.getCountry());
		add.setAddressdescription(adto.getAddressdescription());
		add.setMobileno(adto.getMobileno());
		add.setAddresstype(adto.getAddresstype());
		add.setAdmin(a);
		a.getAlist().add(add);
		adr.saveAndFlush(add);
		ResponseStructure<Address> rs = new ResponseStructure<Address>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("New Address added");
		rs.setData(add);
		return new ResponseEntity<ResponseStructure<Address>>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteAddress(long mobileno, int addressid) throws AdminNotFoundException {
		Admin a = ar.findByMobileno(mobileno).orElseThrow(()-> new AdminNotFoundException());
		List<Address> adlist = a.getAlist();
		Address a1=new Address();
		for(Address ad: adlist)
		{
			if(ad.getId()==addressid)
			{
				a1=ad;
				break;
			}
		}
		a.getAlist().remove(a1);
		adr.delete(a1);
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Address deleted");
		rs.setData("Address deleted");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(long mobileno) throws AdminNotFoundException {
		Admin a = ar.findByMobileno(mobileno).orElseThrow(()-> new AdminNotFoundException());
		ar.delete(a);
		ResponseStructure<Admin> rs = new ResponseStructure<Admin>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Admin deleted");
		rs.setData(a);
		return new ResponseEntity<ResponseStructure<Admin>>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> assignCarrier(int orderid, long carriermobileno, int addid) 
	{	
		Order o = or.findById(orderid).orElseThrow(()->new OrderNotFoundException());
		if(!o.getOrderstatus().equals("PENDING")) throw new OrderStatusException();
		Carrier c = cr.findBymobileno(carriermobileno).orElseThrow(()->new CarrierNotFoundException());
		if(c.getCapacity()==0) throw new CarrierCapacityException();
		c.setCapacity(c.getCapacity()-o.getPurchaseLists().size());
		o.setCarrier(c);
		o.setOrderstatus("CONFIRMED");
		Address a = adr.findById(addid).orElseThrow(()->new AddressNotFoundException());
		o.setPickuploc(a);
		or.save(o);
		c.getOlist().add(o);
		cr.save(c);
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Order assigned to carrier successfully");
		rs.setData("Order assigned to carrier successfully");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.OK);
	}
	
}
