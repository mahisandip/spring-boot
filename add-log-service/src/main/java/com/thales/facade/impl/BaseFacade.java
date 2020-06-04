package com.thales.facade.impl;

import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.thales.common.Process;
import com.thales.common.Status;
import com.thales.exception.ServiceException;
import com.thales.logger.ILogger;
import com.thales.vo.CommonResponse;

public class BaseFacade extends ILogger {

	protected <T> CommonResponse serviceRequestHandler(Process<T> process) {

		logger.debug(getClass().getSimpleName() + " - serviceRequestHandler");

		try {
			T result = process.execute();
			return this.handle(result);

		} catch (Exception e) {

			logger.debug(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return this.handleException(e);
		}
	}

	private <T> CommonResponse handle(T result) {

		logger.debug(getClass().getSimpleName() + " - handle");
		CommonResponse response = new CommonResponse();
		response.setResult(result);
		response.setStatus(Status.SUCCESS.getVal());
		return response;
	}

	private CommonResponse handleException(Exception e) {

		logger.debug(getClass().getSimpleName() + " - handleException");
		CommonResponse response = new CommonResponse();
		response.setResult(null);
		response.setError(e.getMessage());

		if (e instanceof ServiceException)
			response.setStatus(Status.ERROR.getVal());

		else
			response.setStatus(Status.FAILED.getVal());

		return response;
	}

}
