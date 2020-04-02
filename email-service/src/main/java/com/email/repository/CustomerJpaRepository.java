package com.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.email.jpa.CustomerEntity;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {

	CustomerEntity findByCustomerId(Long id);
	
	CustomerEntity findByEmail(String email);
	
}
