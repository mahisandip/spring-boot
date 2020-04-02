package com.email.common;

public enum MsgStatus {
	
	SUCCESS("Ok"), FAILED("Failed"), ERROR("Error");

	private final String val;

	MsgStatus(String val) {
		this.val = val;
	}

	public String getVal() {
		return val;
	}

}
