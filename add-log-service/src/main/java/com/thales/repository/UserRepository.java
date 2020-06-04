package com.thales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thales.jpa.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	public UserEntity findByUsername(String username);
}
