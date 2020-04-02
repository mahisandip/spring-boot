package com.emailgateway.rest;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class RequestLogInterceptor implements ClientHttpRequestInterceptor {

	  @Override
	  public ClientHttpResponse intercept(HttpRequest request, byte[] body,
	      ClientHttpRequestExecution execution) throws IOException {

	    return execution.execute(request, body);
	  } 

}
