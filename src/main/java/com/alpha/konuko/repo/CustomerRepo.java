package com.alpha.konuko.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.konuko.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	Optional<Customer> findBymobileno(long mobileno);

}
