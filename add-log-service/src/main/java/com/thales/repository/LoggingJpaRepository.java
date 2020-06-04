package com.thales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thales.jpa.LogEntity;

@Repository
public interface LoggingJpaRepository extends JpaRepository<LogEntity, Long> {

}
