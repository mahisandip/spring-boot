package com.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.email.jpa.EmailEntity;

public interface EmailJpaRepository extends JpaRepository<EmailEntity, Long>  {

}
