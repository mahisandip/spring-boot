package com.sample.ecom.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.ecom.jpa.CustomerEntity;
import com.sample.ecom.repository.CustomerJpaRepository;
import com.sample.ecom.service.CustomerService;
import com.sample.ecom.vo.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerJpaRepository customerRepo;

	@Override
	public Customer getCustomer() {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerRepo.findByCustomerId(1l), customer);
		return customer;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		CustomerEntity custEntity = new CustomerEntity();
		BeanUtils.copyProperties(customer, custEntity);
		custEntity.setCreatedBy("SYSTEM");
		custEntity.setCreatedDate(new Date());
		custEntity = customerRepo.save(custEntity);
		BeanUtils.copyProperties(custEntity, customer);
		return customer;
	}

}
