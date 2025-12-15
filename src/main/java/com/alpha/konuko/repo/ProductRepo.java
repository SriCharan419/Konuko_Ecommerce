package com.alpha.konuko.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.konuko.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	
}
