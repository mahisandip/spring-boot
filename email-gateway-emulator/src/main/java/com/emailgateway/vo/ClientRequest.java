package com.emailgateway.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "clientrequest")
public class ClientRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("recepient")
	@NotNull
	private String recepient;
	
	@JsonProperty("emailTopic")
	@NotNull
	private String emailTopic;
	
	@JsonProperty("emailBody")
	@NotNull
	private String emailBody;
	
	@JsonProperty("orderId")
	private Long orderId;
	
	@JsonProperty("customerName")
	private String customerName;
	
	@JsonProperty("template")
	private String template;

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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}
	
}
