package com.emailgateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentConfig {
	
	@Value("${host.name}")
	private String hostName;
	
	@Value("${service.login.endpoint}")
	private String loginEndPoint;
	
	@Value("${service.normal.endpoint}")
	private String normalEmailEndPoint;
	
	@Value("${service.template.endpoint}")
	private String templateEmailEndPoint;

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getLoginEndPoint() {
		return loginEndPoint;
	}

	public void setLoginEndPoint(String loginEndPoint) {
		this.loginEndPoint = loginEndPoint;
	}

	public String getNormalEmailEndPoint() {
		return normalEmailEndPoint;
	}

	public void setNormalEmailEndPoint(String normalEmailEndPoint) {
		this.normalEmailEndPoint = normalEmailEndPoint;
	}

	public String getTemplateEmailEndPoint() {
		return templateEmailEndPoint;
	}

	public void setTemplateEmailEndPoint(String templateEmailEndPoint) {
		this.templateEmailEndPoint = templateEmailEndPoint;
	}
	
}
