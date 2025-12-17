package com.alpha.konuko.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.konuko.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

	Optional<Admin> findByMobileno(long mobileno);

}
