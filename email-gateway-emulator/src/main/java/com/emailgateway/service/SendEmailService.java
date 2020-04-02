package com.emailgateway.service;

import com.emailgateway.vo.ClientRequest;
import com.emailgateway.vo.UserInfo;

public interface SendEmailService {
	
	String login(UserInfo userinfo);
	
	String sendNormalEmail(ClientRequest request, String authorization);
	
	String sendEmailWithTemplates(ClientRequest request, String authorization);
}
