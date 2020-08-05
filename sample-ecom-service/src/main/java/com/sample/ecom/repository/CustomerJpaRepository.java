package com.sample.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.ecom.jpa.CustomerEntity;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {

	CustomerEntity findByCustomerId(Long id);

	CustomerEntity findByEmail(String email);

}
