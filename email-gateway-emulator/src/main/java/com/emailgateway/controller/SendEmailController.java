package com.emailgateway.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.emailgateway.common.MsgLogger;
import com.emailgateway.service.SendEmailService;
import com.emailgateway.vo.ClientRequest;
import com.emailgateway.vo.UserInfo;

/**
 * Send Email Rest Controller. Created on: 27 Mar 2020
 */
@RestController
@RequestMapping("api/v1/sendEmail/")
public class SendEmailController extends MsgLogger {

	@Autowired
	private SendEmailService service;

	@RequestMapping(value = "login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String login(@Valid @RequestBody UserInfo request, BindingResult bindingResult) {
		return service.login(request);
	}

	@RequestMapping(value = "normal", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String sendNormalEmail(@RequestHeader("Authorization") String authorization,
			@Valid @RequestBody ClientRequest request, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST	);
		}
		
		return service.sendNormalEmail(request, authorization);
	}

	@RequestMapping(value = "templates", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String sendEmailWithTemplates(@RequestHeader("Authorization") String authorization,
			@Valid @RequestBody ClientRequest request, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		}
		
		return service.sendEmailWithTemplates(request, authorization);
	}
}
