package com.sample.ecom.service;

import javax.transaction.Transactional;

import com.sample.ecom.vo.Customer;

public interface CustomerService {
	
	Customer getCustomer();
	
	@Transactional
	Customer addCustomer(Customer customer);

}
