package com.thales.facade.impl;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thales.facade.MathematicalOpsFacade;
import com.thales.service.MathematicalOpsService;
import com.thales.vo.CommonResponse;

@Component
public class MathematicalOpsFacadeImpl extends BaseFacade implements MathematicalOpsFacade {

	@Autowired
	private MathematicalOpsService mathematicalOpsService;

	@Override
	public CommonResponse add(BigDecimal num1, BigDecimal num2, HttpServletRequest request) {

		logger.debug(getClass().getSimpleName() + " - add");

		return this.serviceRequestHandler(() -> mathematicalOpsService.add(num1, num2));
	}

}
