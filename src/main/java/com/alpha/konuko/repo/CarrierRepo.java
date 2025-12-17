package com.alpha.konuko.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.konuko.entity.Carrier;

@Repository
public interface CarrierRepo extends JpaRepository<Carrier, Integer>{

	Optional<Carrier> findBymobileno(long mobileno);

}
