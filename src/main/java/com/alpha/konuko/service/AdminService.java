package com.alpha.konuko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.konuko.ResponseStructure;
import com.alpha.konuko.dto.AdminDTO;
import com.alpha.konuko.entity.Address;
import com.alpha.konuko.entity.Admin;
import com.alpha.konuko.exception.AdminNotFoundException;
import com.alpha.konuko.repo.AddressRepo;
import com.alpha.konuko.repo.AdminRepo;

@Service
public class AdminService {

	@Autowired
	private AdminRepo ar;
	
	@Autowired
	private AddressRepo adr;
	
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

	public ResponseEntity<ResponseStructure<Admin>> addnewAddress(Address address, long mobileno) {
		Admin a = ar.findByMobileno(mobileno);
		a.getAlist().add(address);
		adr.save(address);
		ar.save(a);
		ResponseStructure<Admin> rs = new ResponseStructure<Admin>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("New Address added");
		rs.setData(a);
		return new ResponseEntity<ResponseStructure<Admin>>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteAddress(long mobileno, int addressid) throws AdminNotFoundException {
		Admin a = ar.findByMobileno(mobileno);
		if(a==null)
		{
			throw new AdminNotFoundException();
		}
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
		Admin a = ar.findByMobileno(mobileno);
		if(a==null)
		{
			throw new AdminNotFoundException();
		}
		ar.delete(a);
		ResponseStructure<Admin> rs = new ResponseStructure<Admin>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Admin deleted");
		rs.setData(a);
		return new ResponseEntity<ResponseStructure<Admin>>(rs,HttpStatus.OK);
	}
	
}
