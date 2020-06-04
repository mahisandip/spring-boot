package com.thales.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thales.facade.LoggingFacade;
import com.thales.vo.CommonResponse;

@RestController
@RequestMapping("/")
public class LoggingController extends BaseController {

	@Autowired
	private LoggingFacade loggingFacade;

	@RequestMapping(value = "logging", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CommonResponse> getLogs(HttpServletRequest request) {

		return this.facadeRequestHandler(() -> loggingFacade.saveLogs(request));
	}
}
