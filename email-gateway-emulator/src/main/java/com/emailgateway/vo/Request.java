package com.emailgateway.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "request")
public class Request implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("recepient")
	private String recepient;
	
	@JsonProperty("emailTopic")
	private String emailTopic;
	
	@JsonProperty("emailBody")
	private String emailBody;
	
	@JsonProperty("orderId")
	private Long orderId;

	public String getRecepient() {
		return recepient;
	}

	public void setRecepient(String recepient) {
		this.recepient = recepient;
	}

	public String getEmailTopic() {
		return emailTopic;
	}

	public void setEmailTopic(String emailTopic) {
		this.emailTopic = emailTopic;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
}
