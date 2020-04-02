package com.email.exception;

public class MailSenderException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public MailSenderException(String msg) {
		super(msg);
	}

}
