package com.alpha.konuko.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.konuko.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer>{

}
