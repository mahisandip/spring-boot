package com.email.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MsgLogger {

	@JsonIgnore
	protected Logger logger;
	
	@JsonIgnore
	private Class<?> logClass;
	
	public MsgLogger() {
		logClass = getClass();
		logger = LoggerFactory.getLogger(logClass);
	}

}
