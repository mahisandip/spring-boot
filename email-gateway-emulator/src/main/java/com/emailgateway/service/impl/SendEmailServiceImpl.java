package com.emailgateway.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.emailgateway.common.MsgLogger;
import com.emailgateway.rest.RestClient;
import com.emailgateway.service.SendEmailService;
import com.emailgateway.vo.Request;
import com.emailgateway.vo.UserInfo;

@Component
public class SendEmailServiceImpl extends MsgLogger implements SendEmailService {
	
	@Autowired
	private RestClient restClient;

	@Override
	public String sendNormalEmail(Request request) {
		
		UserInfo info = new UserInfo();
		info.setUsername("Admin");
		info.setPassword("Admin@123");
		
		String url = "https://localhost:8443/api/v1/sendEmail/normal";
		
		MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
	    Map<String, String> httpHeadersMap = new HashMap<>();
	   
	    HttpEntity<UserInfo> response = restClient.doPostRequest(url, requestParams, UserInfo.class, httpHeadersMap, info);
	    HttpHeaders headers = response.getHeaders();
	    return headers.getFirst("Authorization");
	}

	@Override
	public String sendEmailWithTemplates(Request request) {
		
		return null;
	}

}
