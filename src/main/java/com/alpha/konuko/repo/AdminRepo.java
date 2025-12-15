package com.alpha.konuko.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.konuko.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

	Admin findByMobileno(long mobileno);

}
