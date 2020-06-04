package com.thales.common;

public enum Status {

	SUCCESS("Ok"), FAILED("Failed"), ERROR("Error");

	private final String val;

	private Status(String val) {
		this.val = val;
	}

	public String getVal() {
		return val;
	}

}
