package com.thales.common;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thales.exception.ServiceException;

public class CreateJsonString {

	public static <T> String creatJsonStringFromHashMap(Map<String, T> jsonMap) {

		try {
			return new ObjectMapper().writeValueAsString(jsonMap);

		} catch (JsonProcessingException e) {
			throw new ServiceException("Uncaught Exception. Invalid params");
		}
	}
}
