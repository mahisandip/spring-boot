package com.sample.ecom.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "T_CUSTOMER")
@DynamicInsert
@DynamicUpdate
public class CustomerEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "customer_Sequence", sequenceName = "CUSTOMER_SEQ", 
		allocationSize = 1, schema = "C##_LOCAL_DB_USER")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "customer_Sequence")
	@Column(name = "CUSTOMER_ID", nullable = false)
	private Long customerId;
	
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "MOBILE_NUMBER", nullable = false)
	private Integer mobileNumber;
	
	@Column(name = "EMAIL", nullable = false)	
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
