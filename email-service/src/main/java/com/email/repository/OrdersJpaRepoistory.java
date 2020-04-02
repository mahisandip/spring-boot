package com.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.email.jpa.OrdersEntity;

public interface OrdersJpaRepoistory extends JpaRepository<OrdersEntity, Long> {

	OrdersEntity findByOrderId(Long orderId);
	
}
