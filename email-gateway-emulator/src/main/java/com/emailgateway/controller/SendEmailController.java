package com.emailgateway.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emailgateway.common.MsgLogger;
import com.emailgateway.service.SendEmailService;
import com.emailgateway.vo.Request;

/**
 * Send Email Rest Controller. 
 * Created on: 27 Mar 2020
 */
@RestController
@RequestMapping("api/v1/sendEmail/")
public class SendEmailController extends MsgLogger {
	
	@Autowired
	private SendEmailService service;

	@RequestMapping(value = "normal", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String sendNormalEmail(@Valid @RequestBody Request request, BindingResult bindingResult) {
		return service.sendNormalEmail(request);
	}

	@RequestMapping(value = "templates", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String sendEmailWithTemplates(@Valid @RequestBody Request request, BindingResult bindingResult) {
		return service.sendEmailWithTemplates(request);
	}
}
