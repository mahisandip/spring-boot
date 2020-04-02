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
@JsonRootName(value = "request")
public class Request implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("email")
	@NotNull
	private Email email;
	
	@JsonProperty("orderDetails")
	@NotNull
	private OrderDetails orderDetails;

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}
	
}
