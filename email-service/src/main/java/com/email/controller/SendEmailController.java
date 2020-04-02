package com.email.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.email.service.SendEmailService;
import com.email.vo.Email;
import com.email.vo.Request;
import com.email.vo.Response;

/**
 * Send Email Rest Controller. 
 * Created on: 27 Mar 2020
 */
@RestController
@RequestMapping("api/v1/sendEmail/")
public class SendEmailController extends BaseController<Email> {
	
	@Autowired
	private SendEmailService service;

	/**
	 * Controller method for sending email. Calls the send email service
	 * 
	 * @param request {@link Request}
	 * @param bindingResult {@link BindingResult}
	 * @return {@link ResponseEntity}
	 */
	@RequestMapping(value = "normal", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Email>> sendNormalEmail(@Valid @RequestBody Request request, BindingResult bindingResult) {
		return serviceRequestHandler(() -> service.sendNormalEmail(request), bindingResult);
	}

	@RequestMapping(value = "templates", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Email>> sendEmailWithTemplates(@Valid @RequestBody Request request,
			BindingResult bindingResult) {
		return serviceRequestHandler(() -> service.sendEmailWithTemplates(request), bindingResult);
	}
}
