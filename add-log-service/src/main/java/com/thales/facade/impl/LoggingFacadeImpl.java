package com.thales.facade.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.thales.facade.LoggingFacade;
import com.thales.service.LoggingService;
import com.thales.vo.CommonResponse;

@Component
public class LoggingFacadeImpl extends BaseFacade implements LoggingFacade {

	@Autowired
	private LoggingService loggingService;

	@Override
	@Transactional
	public CommonResponse getLogs(HttpServletRequest request) {
		return this.serviceRequestHandler(() -> loggingService.getLogs());
	}

	@Override
	@Transactional
	public CommonResponse saveLogs(HttpServletRequest request) {
		return this.serviceRequestHandler(() -> loggingService.saveLogs());
	}

}
