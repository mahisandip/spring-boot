package com.thales.facade;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import com.thales.vo.CommonResponse;

public interface MathematicalOpsFacade {

	CommonResponse add(BigDecimal num1, BigDecimal num2, HttpServletRequest request);

}
