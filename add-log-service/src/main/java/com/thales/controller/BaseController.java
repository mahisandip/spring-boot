package com.thales.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.thales.common.Process;
import com.thales.common.Status;
import com.thales.logger.ILogger;
import com.thales.vo.CommonResponse;

@RestController
public class BaseController extends ILogger {

	// error handler method for those data access error which is thrown from the
	// lower layers.
	// eg: jpaRepository.save(). Any DataAccessException thrown during data base
	// commit can't be handled even at the facade layer.
	@ExceptionHandler({ DataAccessException.class })
	protected ResponseEntity<Object> handlePersistenceException(final Exception ex, final WebRequest request) {
		logger.info(ex.getClass().getName());

		CommonResponse apiError = new CommonResponse();
		apiError.setStatus(Status.FAILED.getVal());
		apiError.setError(ex.getLocalizedMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(apiError);
	}

	protected ResponseEntity<CommonResponse> facadeRequestHandler(Process<CommonResponse> process) {
		return this.facadeRequestHandler(process, null);
	}

	protected ResponseEntity<CommonResponse> facadeRequestHandler(Process<CommonResponse> process,
			BindingResult bindingResult) {

		logger.debug(getClass().getSimpleName() + " - facadeRequestHandler");
		CommonResponse response = null;

		// if the request body validation failed, then return bad request.
		if (bindingResult != null && bindingResult.hasErrors()) {
			logger.info("Error in request body");
			response = new CommonResponse();
			response.setStatus(Status.FAILED.getVal());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(response);
		}

		logger.info("Service Entry");
		response = process.execute();
		logger.info("Service Exit");

		int httpStatus = convertToHttpStatus(response.getStatus());

		// set the api status in the response to 'Failed'.
		if (httpStatus == HttpStatus.BAD_REQUEST.value())
			response.setStatus(Status.FAILED.getVal());

		return ResponseEntity.status(httpStatus).body(response);

	}

	private int convertToHttpStatus(String status) {

		logger.debug(getClass().getSimpleName() + " - convertToHttpStatus");
		int stat = HttpStatus.OK.value();

		if (status.equalsIgnoreCase(Status.FAILED.getVal()))
			stat = HttpStatus.INTERNAL_SERVER_ERROR.value();

		else if (status.equalsIgnoreCase(Status.ERROR.getVal()))
			stat = HttpStatus.BAD_REQUEST.value();

		return stat;
	}
}
