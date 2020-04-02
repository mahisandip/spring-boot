package com.emailgateway.rest;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class RestClient {

	private RestTemplate httpsRestTemplate = new RestTemplate();

	@PostConstruct
	void init() {
		// set interceptor
		httpsRestTemplate.getInterceptors().add(new RequestLogInterceptor());
		httpsRestTemplate.setErrorHandler(new ResponseErrorHandler());
	}

	public <R, T> HttpEntity<T> doPostRequest(String hostUrl, String endPoint, MultiValueMap<String, String> requestParams, Class<T> clazz,
			Map<String, String> httpHeadersMap, R httpBody) {

		StringBuilder url = new StringBuilder(hostUrl + endPoint);
		UriComponents uriComponents = null;
		
		if (!requestParams.isEmpty()) {
			uriComponents = UriComponentsBuilder.fromHttpUrl(url.toString()).queryParams(requestParams).build();
		} else {
			uriComponents = UriComponentsBuilder.fromHttpUrl(url.toString()).build();
		}

		HttpHeaders httpHeaders = new HttpHeaders();

		for (Map.Entry<String, String> entry : httpHeadersMap.entrySet()) {
			httpHeaders.add(entry.getKey(), entry.getValue());
		}

		HttpEntity<?> httpEntity = new HttpEntity<>(httpBody, httpHeaders);
		
		return httpsRestTemplate.exchange(uriComponents.encode().toUri(), HttpMethod.POST, httpEntity, clazz);

	}

	protected static String getMethodName() {
		return "";
	}

}
