package com.alpha.konuko.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.konuko.entity.Carrier;

@Repository
public interface CarrierRepo extends JpaRepository<Carrier, Integer>{

	Carrier findBymobileno(long mobileno);

}
