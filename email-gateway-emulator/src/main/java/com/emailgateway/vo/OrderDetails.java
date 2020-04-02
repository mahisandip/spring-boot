package com.emailgateway.vo;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "orderDetails")
public class OrderDetails implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("customerName")
	@NotNull
	private String customerName;
	
	@JsonProperty("orderId")
	@NotNull
	private Long orderId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,
		      pattern = "dd-MM-yyyy HH:mm:ss", locale = "en_SG",
		      timezone = "Singapore")
	@JsonProperty("orderTime")
	private Date orderTime;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,
		      pattern = "dd-MM-yyyy HH:mm:ss", locale = "en_SG",
		      timezone = "Singapore")
	@JsonProperty("shipTime")
	private Date shipTime;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,
		      pattern = "dd-MM-yyyy HH:mm:ss", locale = "en_SG",
		      timezone = "Singapore")
	@JsonProperty("cancelTime")
	private Date cancelTime;
	
	@JsonProperty("cancelReason")
	private String cancelReason;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getShipTime() {
		return shipTime;
	}

	public void setShipTime(Date shipTime) {
		this.shipTime = shipTime;
	}

	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

}
