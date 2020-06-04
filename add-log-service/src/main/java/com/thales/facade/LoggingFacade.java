package com.thales.facade;

import javax.servlet.http.HttpServletRequest;

import com.thales.vo.CommonResponse;

public interface LoggingFacade {

	CommonResponse getLogs(HttpServletRequest request);

	CommonResponse saveLogs(HttpServletRequest request);
}
