package com.emailgateway.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;

import com.emailgateway.common.MsgLogger;
import com.emailgateway.config.EnvironmentConfig;
import com.emailgateway.rest.RestClient;
import com.emailgateway.service.SendEmailService;
import com.emailgateway.vo.ClientRequest;
import com.emailgateway.vo.Email;
import com.emailgateway.vo.OrderDetails;
import com.emailgateway.vo.Request;
import com.emailgateway.vo.Response;
import com.emailgateway.vo.UserInfo;

@Component
public class SendEmailServiceImpl extends MsgLogger implements SendEmailService {

	@Autowired
	private RestClient restClient;

	@Autowired
	private EnvironmentConfig config;

	@Override
	public String login(UserInfo userinfo) {

		MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
		Map<String, String> httpHeadersMap = new HashMap<>();

		HttpEntity<UserInfo> response = restClient.doPostRequest(config.getHostName(), config.getLoginEndPoint(),
				requestParams, UserInfo.class, httpHeadersMap, userinfo);
		HttpHeaders headers = response.getHeaders();
		return headers.getFirst("Authorization");
	}

	@Override
	public String sendNormalEmail(ClientRequest request, String authorization) {

		Email email = new Email();
		email.setRecipientEmailAddress(request.getRecepient());
		email.setEmailTopic(request.getEmailTopic());
		email.setEmailBody(request.getEmailBody());
		
		OrderDetails od = new OrderDetails();
		Request rq = new Request();
		rq.setEmail(email);
		rq.setOrderDetails(od);
		
		MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
		Map<String, String> httpHeadersMap = new HashMap<>();
		httpHeadersMap.put("Authorization", authorization);

		HttpEntity<Response> response = restClient.doPostRequest(config.getHostName(), config.getNormalEmailEndPoint(),
				requestParams, Response.class, httpHeadersMap, rq);
		if(response.getBody().getStatus() == "Failed") {
			throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(response.getBody().getResult() instanceof LinkedHashMap) {
			LinkedHashMap<String, String> r = (LinkedHashMap<String, String>) response.getBody().getResult();
			email.setEmailBody(r.get("emailBody"));
			email.setFrom(r.get("from"));
		}
		return email.toString();
	}

	@Override
	public String sendEmailWithTemplates(ClientRequest request, String authorization) {

		Email email = new Email();
		email.setRecipientEmailAddress(request.getRecepient());
		email.setTemplate(request.getTemplate());
		
		OrderDetails od = new OrderDetails();
		od.setOrderId(request.getOrderId());
		od.setCustomerName(request.getCustomerName());
		
		Request rq = new Request();
		rq.setEmail(email);
		rq.setOrderDetails(od);
		
		MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
		Map<String, String> httpHeadersMap = new HashMap<>();
		httpHeadersMap.put("Authorization", authorization);
		
		HttpEntity<Response> response = restClient.doPostRequest(config.getHostName(), config.getTemplateEmailEndPoint(),
				requestParams, Response.class, httpHeadersMap, rq);
		if(response.getBody().getStatus() == "Failed") {
			throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(response.getBody().getResult() instanceof LinkedHashMap) {
			LinkedHashMap<String, String> r = (LinkedHashMap<String, String>) response.getBody().getResult();
			email.setEmailBody(r.get("emailBody"));
			email.setFrom(r.get("from"));
			email.setEmailTopic(r.get("emailTopic"));
		}
		return email.toString();
	}

}
