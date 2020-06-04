package com.thales.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thales.facade.MathematicalOpsFacade;
import com.thales.vo.CommonResponse;

@RestController
@RequestMapping("/")
public class MathematicalOpsController extends BaseController {
	
	@Autowired
	private MathematicalOpsFacade mathematicalOpsFacade;
	
	@RequestMapping(value = "addition", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CommonResponse> add(@RequestParam(value = "num1", required = true) BigDecimal num1,
			@RequestParam(value = "num2", required = true) BigDecimal num2, HttpServletRequest request) {
		
		return this.facadeRequestHandler(() -> mathematicalOpsFacade.add(num1, num2, request));
	}
}
