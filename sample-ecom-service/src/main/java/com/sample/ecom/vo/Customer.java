package com.sample.ecom.vo;

import java.io.Serializable;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private Long customerId;
	
	@NonNull
	@JsonProperty("firstName")
	private String firstName;
	
	@NonNull
	@JsonProperty("lastName")
	private String lastName;
	
	@NonNull
	@JsonProperty("mobileNumber")
	private Integer mobileNumber;
	
	@NonNull
	@JsonProperty("email")
	private String email;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
