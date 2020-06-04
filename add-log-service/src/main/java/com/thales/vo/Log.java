package com.thales.vo;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Log implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("clientIpAddr")
	@NotNull
	private String ipAddr;

	private String method;

	@JsonProperty("requestedApiName")
	@NotNull
	private String apiName;

	@JsonProperty("apiInputParams")
	@NotNull
	private String inputParams;

	@JsonProperty("requestedTime")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", locale = "en_SG", timezone = "Singapore")
	@NotNull
	private Date requestedTime;

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public String getInputParams() {
		return inputParams;
	}

	public void setInputParams(String inputParams) {
		this.inputParams = inputParams;
	}

	public Date getRequestedTime() {
		return requestedTime;
	}

	public void setRequestedTime(Date requestedTime) {
		this.requestedTime = requestedTime;
	}

}
