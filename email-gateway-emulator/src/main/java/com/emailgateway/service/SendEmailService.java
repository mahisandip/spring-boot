package com.emailgateway.service;

import com.emailgateway.vo.Request;

public interface SendEmailService {
	
	String sendNormalEmail(Request request);
	
	String sendEmailWithTemplates(Request request);
}
