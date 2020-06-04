package com.thales.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.thales.vo.Log;

public interface LoggingService {

	@Transactional
	Void saveLogs();

	@Transactional
	List<Log> getLogs();

}
