package com.alpha.konuko.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.konuko.ResponseStructure;
import com.alpha.konuko.dto.CarrierDTO;
import com.alpha.konuko.dto.CarrierOrderDTO;
import com.alpha.konuko.entity.Carrier;
import com.alpha.konuko.entity.Order;
import com.alpha.konuko.exception.CarrierNotFoundException;
import com.alpha.konuko.exception.InvalidOtpException;
import com.alpha.konuko.exception.OrderNotFoundException;
import com.alpha.konuko.repo.CarrierRepo;
import com.alpha.konuko.repo.OrderRepo;

@Service
public class CarrierService {

	@Autowired
	private CarrierRepo cr;
	
	@Autowired
	private OrderRepo or;
	
	public ResponseEntity<ResponseStructure<Carrier>> saveCarrier(CarrierDTO cdto) {
		Carrier c = new Carrier();
		c.setName(cdto.getName());
		c.setMobileno(cdto.getMobileno());
		c.setMailid(cdto.getMailid());
		c.setCapacity(5);
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

	public ResponseEntity<ResponseStructure<List<CarrierOrderDTO>>> seeallactiveorders(long mobileno) {
		Carrier c = cr.findBymobileno(mobileno).orElseThrow(()->new CarrierNotFoundException());
		List<CarrierOrderDTO> carrierorderlist = new ArrayList<>();
		for(Order o : c.getOlist())
		{
			if(o.getOrderstatus()=="CONFIRMED")
			{
				CarrierOrderDTO cod = new CarrierOrderDTO();
				cod.setOrderid(o.getId());
				cod.setCustname(o.getCustomer().getName());
				cod.setCustmobno(o.getCustomer().getMobileno());
				cod.setPickuploc(o.getPickuploc());
				cod.setDeliveryloc(o.getDeliveryloc());
				carrierorderlist.add(cod);
			}
		}
		ResponseStructure<List<CarrierOrderDTO>> rs = new ResponseStructure<List<CarrierOrderDTO>>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Active orders fetched");
		rs.setData(carrierorderlist);
		return new ResponseEntity<ResponseStructure<List<CarrierOrderDTO>>>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> confirmdelivery(int orderid, int otp) {
		Order o = or.findById(orderid).orElseThrow(()->new OrderNotFoundException());
		if(o.getOtp()!=otp) throw new InvalidOtpException();
		o.setOrderstatus("DELIVERED");
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Order delivered successfully");
		rs.setData("Order delivered successfully");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.OK);
	}
	
}
