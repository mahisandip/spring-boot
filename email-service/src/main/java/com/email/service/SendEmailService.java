package com.email.service;

import com.email.vo.Email;
import com.email.vo.Request;

public interface SendEmailService {
	
	Email sendNormalEmail(Request request);
	
	Email sendEmailWithTemplates(Request request);
	
}
