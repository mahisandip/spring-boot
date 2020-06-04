package com.thales.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thales.logger.ILogger;
import com.thales.logger.LoggingTraceRepository;
import com.thales.service.MathematicalOpsService;

@Service
public class MathematicalOpsServiceImpl extends ILogger implements MathematicalOpsService {

	@Autowired
	LoggingTraceRepository loggingTraceRepository;

	@Override
	public BigDecimal add(BigDecimal num1, BigDecimal num2) {

		logger.debug(getClass().getSimpleName() + " - add");
		return num1.add(num2);
	}
}
