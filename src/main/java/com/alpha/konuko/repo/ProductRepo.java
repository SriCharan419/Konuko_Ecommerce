package com.alpha.konuko.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alpha.konuko.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	@Query("SELECT p FROM Product p WHERE p.availabilitystatus = 'Available'")
	Optional<List<Product>> findByavailabilitystatus();
	
}
