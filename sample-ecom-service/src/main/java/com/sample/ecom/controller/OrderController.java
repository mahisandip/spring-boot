package com.sample.ecom.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@RequestMapping(value = "/orders/print", method = RequestMethod.GET)
	public String print(HttpServletRequest request) {
		System.out.println("test sample print");
		return "test sample print";
	}

}
