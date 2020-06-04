package com.thales.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_LOG")
public class LogEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "LOG_ID", nullable = false)
	private Long logId;

	@Column(name = "IP_ADDRESS")
	private String ipAddr;

	@Column(name = "METHOD")
	private String method;

	@Column(name = "NAME")
	private String apiName;

	@Column(name = "INPUT_PARAMS")
	private String inputParams;

	@Column(name = "REQUESTED_TIME")
	private Date requestedTime;

	public Long getLogId() {
		return logId;
	}

	public void setLogId(Long id) {
		this.logId = id;
	}

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
