package com.email.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import com.email.common.MsgLogger;
import com.email.common.MsgStatus;
import com.email.common.Process;
import com.email.exception.MailSenderException;
import com.email.vo.Response;

@RestController
public class BaseController<T> extends MsgLogger {

	protected ResponseEntity<Response<T>> serviceRequestHandler(Process<T> process) {
		return this.serviceRequestHandler(process, null);
	}

	protected ResponseEntity<Response<T>> serviceRequestHandler(Process<T> process, BindingResult bindingResult) {

		Response<T> response = null;
		if (bindingResult != null && bindingResult.hasErrors()) {
			logger.info("Error in request body");
			response = new Response<T>();
			response.setStatus(MsgStatus.FAILED.getVal());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(response);
		}

		try {
			logger.debug("Service Entry");
			T result = process.execute();
			response = handle(result);
			logger.debug("Service Exit");
		
		} catch (Exception e) {
			logger.error("Error in service", e);
			response = handleException(e);
		}

		int httpStatus = convertToHttpStatus(response.getStatus());
		if (httpStatus == 404)
			response.setStatus(MsgStatus.FAILED.getVal());

		return ResponseEntity.status(httpStatus).body(response);

	}

	private Response<T> handle(T result) {
		Response<T> response = new Response<T>();
		response.setResult(result);
		response.setStatus(MsgStatus.SUCCESS.getVal());
		return response;
	}

	private Response<T> handleException(Exception e) {
		
		Response<T> response = new Response<T>();
		response.setResult(null);
		response.setError(e.getMessage());
		
		if (e instanceof MailSenderException)
			response.setStatus(MsgStatus.ERROR.getVal());
		
		else
			response.setStatus(MsgStatus.FAILED.getVal());
		
		return response;
	}

	private int convertToHttpStatus(String status) {
		int stat = HttpStatus.OK.value();

		if (status.equalsIgnoreCase(MsgStatus.FAILED.getVal()))
			stat = HttpStatus.INTERNAL_SERVER_ERROR.value();
		
		else if (status.equalsIgnoreCase(MsgStatus.ERROR.getVal()))
			stat = HttpStatus.NOT_FOUND.value();

		return stat;
	}
}
