package com.thales.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ILogger {

	@JsonIgnore
	protected Logger logger;

	@JsonIgnore
	private Class<?> logClass;

	public ILogger() {
		logClass = getClass();
		logger = LoggerFactory.getLogger(logClass);
	}

}
