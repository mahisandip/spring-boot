package com.emailgateway.rest;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestClientException;

public class ResponseErrorHandler extends DefaultResponseErrorHandler {

	  @Override
	  public void handleError(ClientHttpResponse response) throws IOException {
	    HttpStatus statusCode = response.getStatusCode();
	    switch (statusCode.series()) {
	    case CLIENT_ERROR:
	    case SERVER_ERROR:
	    	throw new RestClientException(" Status code [" + statusCode + "]");
	    default:
	      throw new RestClientException(" Status code [" + statusCode + "]");
	    }
	  }

}
