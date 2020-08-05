package com.sample.ecom.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.ecom.service.CustomerService;
import com.sample.ecom.vo.Customer;

@RestController
@RequestMapping("/customers/")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@RequestMapping(value = "get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomer(HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.OK.value()).body(service.getCustomer());
	}

	@RequestMapping(value = "add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer, HttpServletRequest request,
			BindingResult bindingResult) {
		return ResponseEntity.status(HttpStatus.OK.value()).body(service.addCustomer(customer));
	}

}
